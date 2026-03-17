package br.edu.lanceArt.api.controller;

import br.edu.lanceArt.api.dto.WorkOfArtCreateDTO;
import br.edu.lanceArt.api.dto.WorkOfArtResponseDTO;
import br.edu.lanceArt.api.entity.WorkOfArt;
import br.edu.lanceArt.api.service.WorkOfArtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/works-of-art")
public class WorkOfArtController {

    @Autowired
    private WorkOfArtService service;

    @GetMapping
    public ResponseEntity<List<WorkOfArtResponseDTO>> list() {
        List<WorkOfArtResponseDTO> works = this.service.list();
        return ResponseEntity.ok(works);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkOfArtResponseDTO> findById(@PathVariable Long id) {
        WorkOfArtResponseDTO work = this.service.findById(id);
        return ResponseEntity.ok(work);
    }

    @PostMapping
    public ResponseEntity<WorkOfArtResponseDTO> create(
            @Valid @RequestBody WorkOfArtCreateDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkOfArtResponseDTO> update(
            @PathVariable Long id,
            @RequestBody WorkOfArtCreateDTO workDto) {

        WorkOfArtResponseDTO updatedWork = service.update(id, workDto);

        return ResponseEntity.ok(updatedWork);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<WorkOfArt>> findByUserId(@PathVariable String userId) {
        List<WorkOfArt> works = this.service.findByUserId(userId);
        return ResponseEntity.ok(works);
    }
}