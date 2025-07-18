package br.gov.conectasos.controller;

import br.gov.conectasos.model.Notificacao;
import br.gov.conectasos.util.ConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/NotificacaoServlet")
public class NotificacaoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int usuarioId = Integer.parseInt(req.getParameter("usuario_id"));
        String mensagem = req.getParameter("mensagem");
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO notificacoes (usuario_id, mensagem) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, usuarioId);
            stmt.setString(2, mensagem);
            stmt.executeUpdate();
            resp.setStatus(200);
        } catch (Exception e) {
            resp.setStatus(500);
        }
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int usuarioId = Integer.parseInt(req.getParameter("usuario_id"));
        List<Notificacao> notificacoes = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM notificacoes WHERE usuario_id = ? ORDER BY criado_em DESC";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Notificacao n = new Notificacao();
                n.setId(rs.getInt("id"));
                n.setUsuarioId(rs.getInt("usuario_id"));
                n.setMensagem(rs.getString("mensagem"));
                n.setLida(rs.getBoolean("lida"));
                n.setCriadoEm(rs.getTimestamp("criado_em"));
                notificacoes.add(n);
            }
            req.setAttribute("notificacoes", notificacoes);
            req.getRequestDispatcher("pages/notificacoes.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("mensagemErro", "Erro ao listar notificações: " + e.getMessage());
            req.getRequestDispatcher("pages/erro.jsp").forward(req, resp);
        }
    }
} 