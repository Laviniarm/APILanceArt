package br.edu.lanceArt.api.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record BidCreateDTO(
        @NotNull
        @DecimalMin(value = "0.01")
        BigDecimal valor,

        @NotNull
        OffsetDateTime data,

        @NotNull
        Long userId,

        @NotNull
        Long workOfArtId
) {
}
