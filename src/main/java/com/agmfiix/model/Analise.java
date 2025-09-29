package com.agmfiix.model;

import jakarta.persistence.*;

@Entity
@Table(name = "analise")
public class Analise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "filme_id")
    private Long filmeId;

    @Column(nullable = false)
    private String analise;

    @Column(nullable = false)
    private Integer nota;

    @Column(nullable = false)
    private String comentario;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getFilmeId() { return filmeId; }
    public void setFilmeId(Long filmeId) { this.filmeId = filmeId; }

    public String getAnalise() { return analise; }
    public void setAnalise(String analise) { this.analise = analise; }

    public Integer getNota() { return nota; }
    public void setNota(Integer nota) { this.nota = nota; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
}
