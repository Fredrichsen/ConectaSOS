package br.gov.conectasos.model;

import java.sql.Timestamp;

public class Comentario {
    private int id;
    private int ocorrenciaId;
    private int usuarioId;
    private String comentario;
    private Timestamp criadoEm;

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getOcorrenciaId() { return ocorrenciaId; }
    public void setOcorrenciaId(int ocorrenciaId) { this.ocorrenciaId = ocorrenciaId; }
    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }
    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
    public Timestamp getCriadoEm() { return criadoEm; }
    public void setCriadoEm(Timestamp criadoEm) { this.criadoEm = criadoEm; }
} 