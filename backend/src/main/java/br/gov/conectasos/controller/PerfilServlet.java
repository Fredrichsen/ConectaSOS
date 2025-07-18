package br.gov.conectasos.controller;

import br.gov.conectasos.dao.UsuarioDAO;
import br.gov.conectasos.model.Usuario;
import br.gov.conectasos.util.ConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/PerfilServlet")
public class PerfilServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("usuario") == null) {
            resp.sendRedirect("pages/login.jsp");
            return;
        }
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        usuario.setNome(req.getParameter("nome"));
        usuario.setTelefone(req.getParameter("telefone"));
        usuario.setDocumento(req.getParameter("documento"));
        usuario.setLocalizacaoPadrao(req.getParameter("localizacao_padrao"));
        try (Connection conn = ConnectionFactory.getConnection()) {
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.atualizarPerfil(usuario);
            session.setAttribute("usuario", usuario);
            resp.sendRedirect("pages/perfil.jsp");
        } catch (Exception e) {
            req.setAttribute("mensagemErro", "Erro ao atualizar perfil: " + e.getMessage());
            req.getRequestDispatcher("pages/erro.jsp").forward(req, resp);
        }
    }
} 