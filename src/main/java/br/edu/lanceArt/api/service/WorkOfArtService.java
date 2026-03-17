package br.edu.lanceArt.api.service;

import br.edu.lanceArt.api.dto.WorkOfArtCreateDTO;
import br.edu.lanceArt.api.dto.WorkOfArtResponseDTO;
import br.edu.lanceArt.api.entity.WorkOfArt;
import br.edu.lanceArt.api.exceptions.InvalidObraDeArteIdException;
import br.edu.lanceArt.api.exceptions.ObraDeArteNotFoundException;
import br.edu.lanceArt.api.repository.WorkOfArtRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WorkOfArtService {

    @Autowired
    private WorkOfArtRepositorio repository;

    public List<WorkOfArtResponseDTO> list() {
        return repository.findAll()
                .stream()
                .map(WorkOfArtResponseDTO::new)
                .toList();
    }

    public WorkOfArtResponseDTO  findById(Long id) {
        WorkOfArt work = repository.findById(id)
                .orElseThrow(() -> new ObraDeArteNotFoundException(id));
        return new WorkOfArtResponseDTO(work);
    }

    public WorkOfArtResponseDTO create(WorkOfArtCreateDTO dto) {

        WorkOfArt work = new WorkOfArt();
        work.setTitle(dto.title());
        work.setArtist(dto.artist());
        work.setYear(dto.year());
        work.setInitialValue(dto.initialValue());
        work.setImage(dto.image());
        work.setUserId(dto.userId());

        WorkOfArt saved = repository.save(work);

        return new WorkOfArtResponseDTO(saved);
    }


    @Transactional
    public WorkOfArtResponseDTO update(Long id, WorkOfArtCreateDTO dto) {

        WorkOfArt work = repository.findById(id)
                .orElseThrow(() -> new ObraDeArteNotFoundException(id));

        work.setTitle(dto.title());
        work.setArtist(dto.artist());
        work.setYear(dto.year());
        work.setInitialValue(dto.initialValue());
        work.setImage(dto.image());
        work.setUserId(dto.userId());

        return new WorkOfArtResponseDTO(work);
    }

    @Transactional
    public void delete(Long id) {
        WorkOfArt work = repository.findById(id)
                .orElseThrow(() -> new ObraDeArteNotFoundException(id));

        repository.delete(work);
    }

    public List<WorkOfArt> findByUserId(String userId) {
        return repository.findByUsuarioId(userId);
    }
}
