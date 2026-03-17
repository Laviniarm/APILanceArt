package br.edu.lanceArt.api.dto;

import java.math.BigDecimal;
import br.edu.lanceArt.api.entity.WorkOfArt;


public record WorkOfArtResponseDTO(
    Long id,
    String title,
    String artist,
    Integer year,
    BigDecimal initialValue,
    String image,
    String userId

) {

    public WorkOfArtResponseDTO(WorkOfArt workOfArt) {
            this(
                    workOfArt.getId(),
                    workOfArt.getTitle(),
                    workOfArt.getArtist(),
                    workOfArt.getYear(),
                    workOfArt.getInitialValue(),
                    workOfArt.getImage(),
                    workOfArt.getUserId()
            );
        }
    }
