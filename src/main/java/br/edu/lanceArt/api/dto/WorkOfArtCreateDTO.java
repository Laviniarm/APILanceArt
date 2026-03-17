package br.edu.lanceArt.api.dto;
import java.math.BigDecimal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record WorkOfArtCreateDTO(
        @NotBlank
        String title,

        @NotBlank
        String artist,

        Integer year,

        @NotNull
        BigDecimal initialValue,

        String image,

        @NotBlank
        String userId
) {

}