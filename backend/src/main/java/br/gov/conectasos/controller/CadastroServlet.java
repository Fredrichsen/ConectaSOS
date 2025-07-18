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

@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String telefone = req.getParameter("telefone");
        String documento = req.getParameter("documento");
        String senha = req.getParameter("senha");
        String perfil = req.getParameter("perfil");
        Usuario u = new Usuario();
        u.setNome(nome);
        u.setEmail(email);
        u.setTelefone(telefone);
        u.setDocumento(documento);
        u.setSenhaHash(hashSenha(senha));
        u.setTipo(perfil);
        u.setOrgaoId(null);
        try (Connection conn = ConnectionFactory.getConnection()) {
            UsuarioDAO dao = new UsuarioDAO(conn);
            if (dao.buscarPorEmail(email) != null) {
                req.setAttribute("mensagemErro", "E-mail já cadastrado!");
                req.getRequestDispatcher("pages/cadastro.jsp").forward(req, resp);
                return;
            }
            dao.cadastrar(u);
            resp.sendRedirect("pages/login.jsp");
        } catch (Exception e) {
            req.setAttribute("mensagemErro", "Erro ao cadastrar: " + e.getMessage());
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