package br.edu.lanceArt.api.dto;

import br.edu.lanceArt.api.model.ObraDeArte;

public record ObraDeArteDTO(
        Long id,
        String titulo,
        String nomeArtista,
        Integer ano,
        Double valorInicial,
        String imagem
) {
    public ObraDeArteDTO(ObraDeArte obraDeArte) {
        this(
                obraDeArte.getId(),
                obraDeArte.getTitulo(),
                obraDeArte.getNomeArtista(),
                obraDeArte.getAno(),
                obraDeArte.getValorInicial(),
                obraDeArte.getImagem()
        );
    }
}