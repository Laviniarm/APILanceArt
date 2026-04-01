package br.edu.lanceArt.api.dto;

import br.edu.lanceArt.api.entity.Bid;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record BidResponseDTO(
        Long id,
        BigDecimal valor,
        OffsetDateTime data,
        Long userId,
        Long workOfArtId
) {
    public BidResponseDTO(Bid bid) {
        this(
                bid.getId(),
                bid.getValor(),
                bid.getData(),
                bid.getUser() != null ? bid.getUser().getId() : null,
                bid.getWorkOfArt() != null ? bid.getWorkOfArt().getId() : null
        );
    }
}
