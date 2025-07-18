package br.gov.conectasos.dao;

import br.gov.conectasos.model.Usuario;
import java.sql.*;

public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean cadastrar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nome, email, telefone, senha_hash, documento, localizacao_padrao, tipo, orgao_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getTelefone());
            stmt.setString(4, usuario.getSenhaHash());
            stmt.setString(5, usuario.getDocumento());
            stmt.setString(6, usuario.getLocalizacaoPadrao());
            stmt.setString(7, usuario.getTipo());
            if (usuario.getOrgaoId() != null) stmt.setInt(8, usuario.getOrgaoId());
            else stmt.setNull(8, Types.INTEGER);
            return stmt.executeUpdate() > 0;
        }
    }

    public Usuario buscarPorEmail(String email) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE email = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return map(rs);
        }
        return null;
    }

    public Usuario buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return map(rs);
        }
        return null;
    }

    public boolean atualizarPerfil(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuarios SET nome=?, telefone=?, documento=?, localizacao_padrao=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getTelefone());
            stmt.setString(3, usuario.getDocumento());
            stmt.setString(4, usuario.getLocalizacaoPadrao());
            stmt.setInt(5, usuario.getId());
            return stmt.executeUpdate() > 0;
        }
    }

    private Usuario map(ResultSet rs) throws SQLException {
        Usuario u = new Usuario();
        u.setId(rs.getInt("id"));
        u.setNome(rs.getString("nome"));
        u.setEmail(rs.getString("email"));
        u.setTelefone(rs.getString("telefone"));
        u.setSenhaHash(rs.getString("senha_hash"));
        u.setDocumento(rs.getString("documento"));
        u.setLocalizacaoPadrao(rs.getString("localizacao_padrao"));
        u.setTipo(rs.getString("tipo"));
        int orgaoId = rs.getInt("orgao_id");
        u.setOrgaoId(rs.wasNull() ? null : orgaoId);
        return u;
    }
} 