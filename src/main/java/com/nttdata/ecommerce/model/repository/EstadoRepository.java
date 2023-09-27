package com.nttdata.ecommerce.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.ecommerce.model.entity.Estado;
import java.util.Optional;


public interface EstadoRepository extends JpaRepository<Estado, Long> {
Optional<Estado> findBySigla(String sigla);
}
