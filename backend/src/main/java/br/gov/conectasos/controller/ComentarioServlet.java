package br.gov.conectasos.controller;

import br.gov.conectasos.model.Comentario;
import br.gov.conectasos.util.ConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ComentarioServlet")
public class ComentarioServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int ocorrenciaId = Integer.parseInt(req.getParameter("ocorrencia_id"));
        String comentario = req.getParameter("comentario");
        HttpSession session = req.getSession(false);
        int usuarioId = (session != null && session.getAttribute("usuario") != null) ? ((br.gov.conectasos.model.Usuario)session.getAttribute("usuario")).getId() : 0;
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO comentarios (ocorrencia_id, usuario_id, comentario) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ocorrenciaId);
            stmt.setInt(2, usuarioId);
            stmt.setString(3, comentario);
            stmt.executeUpdate();
            resp.sendRedirect("pages/dashboard.jsp");
        } catch (Exception e) {
            req.setAttribute("mensagemErro", "Erro ao comentar: " + e.getMessage());
            req.getRequestDispatcher("pages/erro.jsp").forward(req, resp);
        }
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int ocorrenciaId = Integer.parseInt(req.getParameter("ocorrencia_id"));
        List<Comentario> comentarios = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM comentarios WHERE ocorrencia_id = ? ORDER BY criado_em ASC";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ocorrenciaId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Comentario c = new Comentario();
                c.setId(rs.getInt("id"));
                c.setOcorrenciaId(rs.getInt("ocorrencia_id"));
                c.setUsuarioId(rs.getInt("usuario_id"));
                c.setComentario(rs.getString("comentario"));
                c.setCriadoEm(rs.getTimestamp("criado_em"));
                comentarios.add(c);
            }
            req.setAttribute("comentarios", comentarios);
            req.getRequestDispatcher("pages/ocorrencia_detalhe.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("mensagemErro", "Erro ao listar comentários: " + e.getMessage());
            req.getRequestDispatcher("pages/erro.jsp").forward(req, resp);
        }
    }
} 