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
    private String nomeArtista;
    private Integer ano;
    private Double valorInicial;
    private String imagem;

    public ObraDeArte() {
    }


    public ObraDeArte(Long id, String titulo, String nomeArtista, Integer ano, Double valorInicial) {
        this.id = id;
        this.titulo = titulo;
        this.nomeArtista = nomeArtista;
        this.ano = ano;
        this.valorInicial = valorInicial;
    }

    public ObraDeArte(ObraDeArteDTO dto) {
        this.titulo = dto.titulo();
        this.nomeArtista = dto.nomeArtista();
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
        return nomeArtista;
    }

    public void setNomeArtista(String nomeArtista) {
        this.nomeArtista = nomeArtista;
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
                ", nomeArtista='" + nomeArtista + '\'' +
                ", ano=" + ano +
                ", valorInicial=" + valorInicial +
                ", imagem='" + imagem + '\'' +
                '}';
    }
}