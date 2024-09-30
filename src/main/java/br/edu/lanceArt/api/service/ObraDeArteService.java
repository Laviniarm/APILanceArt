package br.edu.lanceArt.api.service;

import br.edu.lanceArt.api.dto.ObraDeArteDTO;
import br.edu.lanceArt.api.exceptions.InvalidObraDeArteIdException;
import br.edu.lanceArt.api.exceptions.ObraDeArteNotFoundException;
import br.edu.lanceArt.api.model.ObraDeArte;
import br.edu.lanceArt.api.repository.ObraDeArteRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraDeArteService {

    @Autowired
    private ObraDeArteRepositorio repositorio;

    public List<ObraDeArteDTO> listar() {
        return repositorio.findAll().stream().map(ObraDeArteDTO::new).toList();
    }

    public ObraDeArte buscarPorId(Long id) {
        return this.repositorio.findById(id)
                .orElseThrow(() -> new ObraDeArteNotFoundException(id));
    }

    public ObraDeArte cadastrar(ObraDeArteDTO obraDeArteInserir) {
        return repositorio.save(new ObraDeArte(obraDeArteInserir));
    }

    @Transactional
    public ObraDeArte atualizar(ObraDeArteDTO obraDeArteDTO) {
        if (obraDeArteDTO.id() == null) {
            throw new InvalidObraDeArteIdException();
        }
        ObraDeArte obraAtualizada = repositorio.findById(obraDeArteDTO.id())
                .orElseThrow(() -> new ObraDeArteNotFoundException(obraDeArteDTO.id()));

        obraAtualizada.setTitulo(obraDeArteDTO.titulo());
        obraAtualizada.setArtista(obraDeArteDTO.artista());
        obraAtualizada.setAno(obraDeArteDTO.ano());
        obraAtualizada.setValorInicial(obraDeArteDTO.valorInicial());
        obraAtualizada.setImagem(obraDeArteDTO.imagem());

        return repositorio.save(obraAtualizada);
    }

    @Transactional
    public void remover(Long id) {
        ObraDeArte obra = repositorio.findById(id)
                .orElseThrow(() -> new ObraDeArteNotFoundException(id));
        repositorio.delete(obra);
    }

    public List<ObraDeArte> listarPorUsuarioId(String usuarioId) {
        return repositorio.findByUsuarioId(usuarioId);
    }
}