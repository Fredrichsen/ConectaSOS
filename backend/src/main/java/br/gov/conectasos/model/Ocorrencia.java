package br.gov.conectasos.model;

import java.sql.Timestamp;

public class Ocorrencia {
    private int id;
    private int usuarioId;
    private int orgaoId;
    private String categoria;
    private String descricao;
    private Double latitude;
    private Double longitude;
    private String endereco;
    private String status;
    private boolean termoAceito;
    private Timestamp criadoEm;

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }
    public int getOrgaoId() { return orgaoId; }
    public void setOrgaoId(int orgaoId) { this.orgaoId = orgaoId; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }
    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public boolean isTermoAceito() { return termoAceito; }
    public void setTermoAceito(boolean termoAceito) { this.termoAceito = termoAceito; }
    public Timestamp getCriadoEm() { return criadoEm; }
    public void setCriadoEm(Timestamp criadoEm) { this.criadoEm = criadoEm; }
} 