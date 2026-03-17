package br.edu.lanceArt.api.repository;

import br.edu.lanceArt.api.entity.WorkOfArt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkOfArtRepositorio extends JpaRepository<WorkOfArt, Long> {

    List<WorkOfArt> findByUsuarioId(String usuarioId);

}
