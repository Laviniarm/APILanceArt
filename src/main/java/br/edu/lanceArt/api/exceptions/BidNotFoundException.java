package br.edu.lanceArt.api.exceptions;

public class BidNotFoundException extends RuntimeException {
    public BidNotFoundException(Long id) {
        super("Lance com ID " + id + " nao encontrado.");
    }
}
