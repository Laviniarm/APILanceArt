package br.edu.lanceArt.api.dto;

public record LoginResponseDTO(
        String token,
        String type,
        long expiresIn,
        Long userId,
        String nome,
        String email
) {
}
