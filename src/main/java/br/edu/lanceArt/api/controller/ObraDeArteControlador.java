package br.edu.lanceArt.api.controller;

import br.edu.lanceArt.api.dto.ObraDeArteDTO;
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
    public List<ObraDeArteDTO> listar() {
        return this.service.listar();
    }

    @GetMapping("/{id}")
    public ObraDeArte buscar(@PathVariable(name = "id") Long id) {
        return this.service.buscarPorId(id);
    }

    @PostMapping
    public ObraDeArte cadastrar(@RequestBody ObraDeArteDTO obra) {
        return this.service.cadastrar(obra);
    }

    @PutMapping
    public ObraDeArte atualizar(@RequestBody ObraDeArteDTO obra) {
        return this.service.atualizar(obra);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable(name = "id") Long id) {
        this.service.remover(id);
    }


}
