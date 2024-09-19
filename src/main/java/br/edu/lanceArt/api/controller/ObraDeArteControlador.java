package br.edu.lanceArt.api.controller;

import br.edu.lanceArt.api.model.ObraDeArte;
import br.edu.lanceArt.api.service.ObraDeArteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras")
public class ObraDeArteControlador {

    @Autowired
    private ObraDeArteService service;

    @GetMapping
    public List<ObraDeArte> listar() {
        return this.service.listar();
    }
    @PostMapping
    public ObraDeArte cadastrar(@RequestBody ObraDeArte obra) {
        return this.service.cadastrar(obra);
    }
}
