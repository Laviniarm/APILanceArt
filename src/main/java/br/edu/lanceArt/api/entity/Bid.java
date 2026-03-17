package br.edu.lanceArt.api.entity;

import jakarta.persistence.*;

@Entity
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String valor;
    private String data;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "obra_de_arte_id")
    private WorkOfArt workOfArt;

    public Bid(String valor, String data, User user, WorkOfArt workOfArt) {
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
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
