package br.edu.lanceArt.api.exceptions;

public class ObraDeArteNotFoundException extends RuntimeException{
    public ObraDeArteNotFoundException(Long id) {
        super("Obra de arte com ID " + id + " não encontrada.");
    }
}
