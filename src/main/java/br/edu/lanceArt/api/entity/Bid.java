package br.edu.lanceArt.api.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(nullable = false)
    private OffsetDateTime data;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "obra_de_arte_id")
    private WorkOfArt workOfArt;

    public Bid(BigDecimal valor, OffsetDateTime data, User user, WorkOfArt workOfArt) {
        this.valor = valor;
        this.data = data;
        this.user = user;
        this.workOfArt = workOfArt;
    }

    public Bid() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public OffsetDateTime getData() {
        return data;
    }

    public void setData(OffsetDateTime data) {
        this.data = data;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public WorkOfArt getWorkOfArt() {
        return workOfArt;
    }

    public void setWorkOfArt(WorkOfArt workOfArt) {
        this.workOfArt = workOfArt;
    }
}
