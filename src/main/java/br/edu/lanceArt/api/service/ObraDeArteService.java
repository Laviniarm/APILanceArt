package br.edu.lanceArt.api.service;

import br.edu.lanceArt.api.dto.ObraDeArteDTO;
import br.edu.lanceArt.api.model.ObraDeArte;
import br.edu.lanceArt.api.repository.ObraDeArteRepositorio;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObraDeArteService {

    @Autowired
    private ObraDeArteRepositorio repositorio;

    public List<ObraDeArteDTO> listar() {
        return repositorio.findAll().stream().map(ObraDeArteDTO::new).toList();
    }

    public ObraDeArte buscarPorId(Long id) {
        return this.repositorio.findById(id).orElse(null);
    }

    public ObraDeArte cadastrar(ObraDeArteDTO obraDeArteInserir){
        return repositorio.save(new ObraDeArte(obraDeArteInserir));
    }

    @Transactional
    public ObraDeArte atualizar(ObraDeArteDTO obraDeArteDTO){
        if (obraDeArteDTO.id() == null) {
            throw new IllegalArgumentException("O ID da obra de arte não pode ser nulo para atualização.");
        }
        Optional<ObraDeArte> obraExistente = repositorio.findById(obraDeArteDTO.id());

        if (obraExistente.isPresent()) {
            ObraDeArte obraAtualizada = obraExistente.get();
            obraAtualizada.setTitulo(obraDeArteDTO.titulo());
            obraAtualizada.setNomeArtista(obraDeArteDTO.nomeArtista());
            obraAtualizada.setAno(obraDeArteDTO.ano());
            obraAtualizada.setValorInicial(obraDeArteDTO.valorInicial());
            obraAtualizada.setImagem(obraDeArteDTO.imagem());

            return repositorio.save(obraAtualizada);
        } else {
            throw new EntityNotFoundException("Obra de arte não encontrada.");
        }
    }

    public void remover(Long id){
        repositorio.deleteById(id);
    }

}
