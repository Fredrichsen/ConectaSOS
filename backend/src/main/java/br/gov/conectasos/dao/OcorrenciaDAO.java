package br.gov.conectasos.dao;

import br.gov.conectasos.model.Ocorrencia;
import java.sql.*;
import java.util.*;

public class OcorrenciaDAO {
    private Connection conn;
    public OcorrenciaDAO(Connection conn) { this.conn = conn; }

    public boolean inserir(Ocorrencia o) throws SQLException {
        String sql = "INSERT INTO ocorrencias (usuario_id, orgao_id, categoria, descricao, latitude, longitude, endereco, status, termo_aceito) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, o.getUsuarioId());
            stmt.setInt(2, o.getOrgaoId());
            stmt.setString(3, o.getCategoria());
            stmt.setString(4, o.getDescricao());
            if (o.getLatitude() != null) stmt.setDouble(5, o.getLatitude()); else stmt.setNull(5, Types.DOUBLE);
            if (o.getLongitude() != null) stmt.setDouble(6, o.getLongitude()); else stmt.setNull(6, Types.DOUBLE);
            stmt.setString(7, o.getEndereco());
            stmt.setString(8, o.getStatus());
            stmt.setBoolean(9, o.isTermoAceito());
            return stmt.executeUpdate() > 0;
        }
    }

    public List<Ocorrencia> buscarPorUsuario(int usuarioId) throws SQLException {
        String sql = "SELECT * FROM ocorrencias WHERE usuario_id = ? ORDER BY criado_em DESC";
        List<Ocorrencia> lista = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) lista.add(map(rs));
        }
        return lista;
    }

    public List<Ocorrencia> buscarPorOrgao(int orgaoId) throws SQLException {
        String sql = "SELECT * FROM ocorrencias WHERE orgao_id = ? ORDER BY criado_em DESC";
        List<Ocorrencia> lista = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, orgaoId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) lista.add(map(rs));
        }
        return lista;
    }

    public Ocorrencia buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM ocorrencias WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return map(rs);
        }
        return null;
    }

    public boolean atualizarStatus(int id, String status) throws SQLException {
        String sql = "UPDATE ocorrencias SET status=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setInt(2, id);
            return stmt.executeUpdate() > 0;
        }
    }

    private Ocorrencia map(ResultSet rs) throws SQLException {
        Ocorrencia o = new Ocorrencia();
        o.setId(rs.getInt("id"));
        o.setUsuarioId(rs.getInt("usuario_id"));
        o.setOrgaoId(rs.getInt("orgao_id"));
        o.setCategoria(rs.getString("categoria"));
        o.setDescricao(rs.getString("descricao"));
        o.setLatitude(rs.getObject("latitude") != null ? rs.getDouble("latitude") : null);
        o.setLongitude(rs.getObject("longitude") != null ? rs.getDouble("longitude") : null);
        o.setEndereco(rs.getString("endereco"));
        o.setStatus(rs.getString("status"));
        o.setTermoAceito(rs.getBoolean("termo_aceito"));
        o.setCriadoEm(rs.getTimestamp("criado_em"));
        return o;
    }
} 