package br.gov.conectasos.model;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String senhaHash;
    private String documento;
    private String localizacaoPadrao;
    private String tipo;
    private Integer orgaoId;

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getSenhaHash() { return senhaHash; }
    public void setSenhaHash(String senhaHash) { this.senhaHash = senhaHash; }
    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }
    public String getLocalizacaoPadrao() { return localizacaoPadrao; }
    public void setLocalizacaoPadrao(String localizacaoPadrao) { this.localizacaoPadrao = localizacaoPadrao; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public Integer getOrgaoId() { return orgaoId; }
    public void setOrgaoId(Integer orgaoId) { this.orgaoId = orgaoId; }
} 