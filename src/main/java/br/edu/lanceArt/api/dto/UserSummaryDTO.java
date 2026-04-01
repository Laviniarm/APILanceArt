package br.edu.lanceArt.api.dto;

import br.edu.lanceArt.api.entity.User;

public record UserSummaryDTO(
        Long id,
        String nome
) {
    public UserSummaryDTO(User user) {
        this(
                user.getId(),
                user.getNome()
        );
    }
}
