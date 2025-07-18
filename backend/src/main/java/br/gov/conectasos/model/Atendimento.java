package br.gov.conectasos.model;

import java.sql.Timestamp;

public class Atendimento {
    private int id;
    private int ocorrenciaId;
    private int atendenteId;
    private String status;
    private String justificativa;
    private Timestamp criadoEm;

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getOcorrenciaId() { return ocorrenciaId; }
    public void setOcorrenciaId(int ocorrenciaId) { this.ocorrenciaId = ocorrenciaId; }
    public int getAtendenteId() { return atendenteId; }
    public void setAtendenteId(int atendenteId) { this.atendenteId = atendenteId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getJustificativa() { return justificativa; }
    public void setJustificativa(String justificativa) { this.justificativa = justificativa; }
    public Timestamp getCriadoEm() { return criadoEm; }
    public void setCriadoEm(Timestamp criadoEm) { this.criadoEm = criadoEm; }
} 