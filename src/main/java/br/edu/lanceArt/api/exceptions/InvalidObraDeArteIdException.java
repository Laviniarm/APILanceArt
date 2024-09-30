package br.edu.lanceArt.api.exceptions;

public class InvalidObraDeArteIdException extends RuntimeException {
    public InvalidObraDeArteIdException() {
        super("O ID da obra de arte não pode ser nulo.");
    }
}
