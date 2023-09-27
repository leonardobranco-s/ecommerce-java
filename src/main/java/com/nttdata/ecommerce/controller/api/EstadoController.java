package com.nttdata.ecommerce.controller.api;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nttdata.ecommerce.controller.service.EstadoService;
import com.nttdata.ecommerce.model.dto.EstadoDto;





@RestController
@RequestMapping("/estados")
public class EstadoController {
    

    @Autowired
    private EstadoService estadoService;

    @PostMapping
    public EstadoDto create (@RequestBody EstadoDto input) {
        return estadoService.create(input);
    }

    @GetMapping
    public List<EstadoDto> readList(){
        return estadoService.findList();
    }

    @GetMapping("/{id}")
    public EstadoDto readbyId(@PathVariable("id") Long id) {
        return estadoService.findByID(id);
    }

    @GetMapping("/sigla/{sigla}")
    public EstadoDto readbyId(@PathVariable("sigla") String sigla) {
        return estadoService.findByID(sigla);
    }
    @PutMapping("/{id}")
    public EstadoDto update(@PathVariable("id")Long id, @RequestBody EstadoDto input) {
        return estadoService.update(id, input);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Long id) {
        estadoService.delete(id);
    }
}

