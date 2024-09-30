package br.edu.lanceArt.api.dto;

import br.edu.lanceArt.api.model.ObraDeArte;

public record ObraDeArteDTO(
        Long id,
        String titulo,
        String artista,
        Integer ano,
        Double valorInicial,
        String imagem,

        String usuarioId
) {
    public ObraDeArteDTO(ObraDeArte obraDeArte) {
        this(
                obraDeArte.getId(),
                obraDeArte.getTitulo(),
                obraDeArte.getArtista(),
                obraDeArte.getAno(),
                obraDeArte.getValorInicial(),
                obraDeArte.getImagem(),
                obraDeArte.getUsuarioId()
        );
    }

}