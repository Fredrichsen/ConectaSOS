package br.gov.conectasos.controller;

import br.gov.conectasos.dao.UsuarioDAO;
import br.gov.conectasos.model.Usuario;
import br.gov.conectasos.util.ConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.security.MessageDigest;
import java.sql.Connection;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        String perfil = req.getParameter("perfil");
        try (Connection conn = ConnectionFactory.getConnection()) {
            UsuarioDAO dao = new UsuarioDAO(conn);
            Usuario u = dao.buscarPorEmail(email);
            if (u == null || !u.getTipo().equals(perfil) || !u.getSenhaHash().equals(hashSenha(senha))) {
                req.setAttribute("mensagemErro", "Usuário ou senha inválidos!");
                req.getRequestDispatcher("pages/login.jsp").forward(req, resp);
                return;
            }
            HttpSession session = req.getSession();
            session.setAttribute("usuario", u);
            if (perfil.equals("cidadao")) resp.sendRedirect("pages/dashboard.jsp");
            else resp.sendRedirect("pages/admin_dashboard.jsp");
        } catch (Exception e) {
            req.setAttribute("mensagemErro", "Erro ao logar: " + e.getMessage());
            req.getRequestDispatcher("pages/erro.jsp").forward(req, resp);
        }
    }
    private String hashSenha(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(senha.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (Exception e) { return senha; }
    }
} 