package br.edu.lanceArt.api.exceptions;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException() {
        super("Email ou senha invalidos.");
    }
}
