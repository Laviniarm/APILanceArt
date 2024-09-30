package br.edu.lanceArt.api.controller;

import br.edu.lanceArt.api.dto.ObraDeArteDTO;
import br.edu.lanceArt.api.model.ObraDeArte;
import br.edu.lanceArt.api.service.ObraDeArteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras")
public class ObraDeArteControlador {

    @Autowired
    private ObraDeArteService service;

    @GetMapping
    public ResponseEntity<List<ObraDeArteDTO>> listar() {
        List<ObraDeArteDTO> obras = this.service.listar();
        return ResponseEntity.ok(obras);   // 200 Ok
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObraDeArte> buscar(@PathVariable(name = "id") Long id) {
        ObraDeArte obra = this.service.buscarPorId(id);
        return ResponseEntity.ok(obra); // 200 OK
    }

    @PostMapping
    public ResponseEntity<ObraDeArte> cadastrar(@RequestBody ObraDeArteDTO obra) {
        ObraDeArte novaObra = this.service.cadastrar(obra);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaObra); // 201 Created
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObraDeArte> atualizar(@RequestBody ObraDeArteDTO obra) {
        ObraDeArte obraAtualizada = this.service.atualizar(obra);
        return ResponseEntity.ok(obraAtualizada); // 200 OK

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable(name = "id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();  // 204 No Content

    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<ObraDeArte>> listarPorUsuario(@PathVariable(name = "usuarioId") String usuarioId) {
        List<ObraDeArte> obras = this.service.listarPorUsuarioId(usuarioId);
        return ResponseEntity.ok(obras); // 200 OK
    }

}
