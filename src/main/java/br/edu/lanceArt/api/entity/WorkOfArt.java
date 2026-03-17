package br.edu.lanceArt.api.entity;

import br.edu.lanceArt.api.dto.WorkOfArtCreateDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tb_obras")
public class WorkOfArt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = false, length = 100)
    private String artist;

    private Integer year;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal initialValue;

    @Column(length = 500)
    private String image;

    @Column(nullable = false)
    private String userId;

    public WorkOfArt() {
    }

    public WorkOfArt(Long id, String title, String artist, Integer year,
                     BigDecimal initialValue, String image, String userId) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.initialValue = initialValue;
        this.image = image;
        this.userId = userId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public BigDecimal getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(BigDecimal initialValue) {
        this.initialValue = initialValue;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "WorkOfArt{" +
                "id=" + id +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", year=" + year +
                ", initialValue=" + initialValue +
                ", image='" + image + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}