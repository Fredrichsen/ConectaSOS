package br.gov.conectasos.controller;

import br.gov.conectasos.dao.OcorrenciaDAO;
import br.gov.conectasos.model.Ocorrencia;
import br.gov.conectasos.model.Usuario;
import br.gov.conectasos.util.ConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/OcorrenciaServlet")
public class OcorrenciaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("usuario") == null) {
            resp.sendRedirect("pages/login.jsp");
            return;
        }
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        String categoria = req.getParameter("categoria");
        String descricao = req.getParameter("descricao");
        String endereco = req.getParameter("localizacao");
        String status = "Aberta";
        boolean termo = req.getParameter("termo") != null;
        // Para MVP, latitude/longitude ficam nulos
        int orgaoId = getOrgaoIdPorCategoria(categoria);
        Ocorrencia o = new Ocorrencia();
        o.setUsuarioId(usuario.getId());
        o.setOrgaoId(orgaoId);
        o.setCategoria(categoria);
        o.setDescricao(descricao);
        o.setEndereco(endereco);
        o.setStatus(status);
        o.setTermoAceito(termo);
        try (Connection conn = ConnectionFactory.getConnection()) {
            OcorrenciaDAO dao = new OcorrenciaDAO(conn);
            dao.inserir(o);
            resp.sendRedirect("pages/dashboard.jsp");
        } catch (Exception e) {
            req.setAttribute("mensagemErro", "Erro ao registrar ocorrência: " + e.getMessage());
            req.getRequestDispatcher("pages/erro.jsp").forward(req, resp);
        }
    }
    // Simulação de atribuição de órgão por categoria
    private int getOrgaoIdPorCategoria(String categoria) {
        switch (categoria) {
            case "Assalto":
            case "Disparos de arma de fogo":
            case "Agressão contra mulheres":
                return 1; // Polícia
            case "Incêndio":
            case "Queda de árvore obstruindo via pública":
                return 2; // Defesa Civil
            default:
                return 3; // Outro órgão
        }
    }
} 