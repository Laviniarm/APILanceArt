package br.edu.lanceArt.api.repository;

import br.edu.lanceArt.api.model.ObraDeArte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObraDeArteRepositorio extends JpaRepository<ObraDeArte, Long> {

    List<ObraDeArte> findByUsuarioId(String usuarioId);

}
