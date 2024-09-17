package br.edu.lanceArt.api.service;

import br.edu.lanceArt.api.model.ObraDeArte;
import br.edu.lanceArt.api.repository.ObraDeArteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraDeArteService {

    @Autowired
    private ObraDeArteRepositorio repositorio;

    public List<ObraDeArte> listar() {
        return repositorio.findAll();
    }

}
