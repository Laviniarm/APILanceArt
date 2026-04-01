package br.edu.lanceArt.api.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Usuario com ID " + id + " nao encontrado.");
    }
}
