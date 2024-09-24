package br.edu.lanceArt.api.service;

import br.edu.lanceArt.api.dto.ObraDeArteDTO;
import br.edu.lanceArt.api.model.ObraDeArte;
import br.edu.lanceArt.api.repository.ObraDeArteRepositorio;
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
        return this.repositorio.findById(id).orElse(null);
    }

    public ObraDeArte cadastrar(ObraDeArteDTO obraDeArteInserir){
        return repositorio.save(new ObraDeArte(obraDeArteInserir));
    }

    public ObraDeArte atualizar(ObraDeArteDTO obra){
        return repositorio.save(new ObraDeArte(obra));
    }

    public void remover(Long id){
        repositorio.deleteById(id);
    }

}
