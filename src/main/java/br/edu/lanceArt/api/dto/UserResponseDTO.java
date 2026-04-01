package br.edu.lanceArt.api.dto;

import br.edu.lanceArt.api.entity.User;

public record UserResponseDTO(
        Long id,
        String nome,
        String email
) {
    public UserResponseDTO(User user) {
        this(
                user.getId(),
                user.getNome(),
                user.getEmail()
        );
    }
}
