package br.edu.lanceArt.api.model;

import br.edu.lanceArt.api.dto.ObraDeArteDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_obras")
public class ObraDeArte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    private String artista;
    private Integer ano;
    private Double valorInicial;
    private String imagem;

//    todo
//    private String userId;

    public ObraDeArte() {
    }


    public ObraDeArte(Long id, String titulo, String nomeArtista, Integer ano, Double valorInicial) {
        this.id = id;
        this.titulo = titulo;
        this.artista = nomeArtista;
        this.ano = ano;
        this.valorInicial = valorInicial;
    }

    public ObraDeArte(ObraDeArteDTO dto) {
        this.titulo = dto.titulo();
        this.artista = dto.artista();
        this.ano = dto.ano();
        this.valorInicial = dto.valorInicial();
        this.imagem = dto.imagem();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomeArtista() {
        return artista;
    }

    public void setNomeArtista(String nomeArtista) {
        this.artista = nomeArtista;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        return "ObraDeArte{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", nomeArtista='" + artista + '\'' +
                ", ano=" + ano +
                ", valorInicial=" + valorInicial +
                ", imagem='" + imagem + '\'' +
                '}';
    }
}