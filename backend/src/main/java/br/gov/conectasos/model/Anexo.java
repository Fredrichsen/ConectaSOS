package br.gov.conectasos.model;

import java.sql.Timestamp;

public class Anexo {
    private int id;
    private int ocorrenciaId;
    private String tipo;
    private String caminho;
    private Timestamp criadoEm;

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getOcorrenciaId() { return ocorrenciaId; }
    public void setOcorrenciaId(int ocorrenciaId) { this.ocorrenciaId = ocorrenciaId; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getCaminho() { return caminho; }
    public void setCaminho(String caminho) { this.caminho = caminho; }
    public Timestamp getCriadoEm() { return criadoEm; }
    public void setCriadoEm(Timestamp criadoEm) { this.criadoEm = criadoEm; }
} 