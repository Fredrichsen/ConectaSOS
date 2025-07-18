package br.gov.conectasos.controller;

import br.gov.conectasos.dao.OcorrenciaDAO;
import br.gov.conectasos.model.Ocorrencia;
import br.gov.conectasos.util.ConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/AdminPainelServlet")
public class AdminPainelServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int orgaoId = Integer.parseInt(req.getParameter("orgao_id"));
        String status = req.getParameter("status");
        try (Connection conn = ConnectionFactory.getConnection()) {
            OcorrenciaDAO dao = new OcorrenciaDAO(conn);
            List<Ocorrencia> lista;
            if (status != null && !status.isEmpty()) {
                // Filtro por status
                lista = dao.buscarPorOrgao(orgaoId);
                lista.removeIf(o -> !o.getStatus().equals(status));
            } else {
                lista = dao.buscarPorOrgao(orgaoId);
            }
            req.setAttribute("ocorrencias", lista);
            req.getRequestDispatcher("pages/admin_dashboard.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("mensagemErro", "Erro ao listar ocorrências: " + e.getMessage());
            req.getRequestDispatcher("pages/erro.jsp").forward(req, resp);
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int ocorrenciaId = Integer.parseInt(req.getParameter("ocorrencia_id"));
        String acao = req.getParameter("acao");
        String justificativa = req.getParameter("justificativa");
        try (Connection conn = ConnectionFactory.getConnection()) {
            OcorrenciaDAO dao = new OcorrenciaDAO(conn);
            if (acao.equals("aceitar")) {
                dao.atualizarStatus(ocorrenciaId, "Em andamento");
            } else if (acao.equals("finalizar")) {
                dao.atualizarStatus(ocorrenciaId, "Finalizada");
            } else if (acao.equals("recusar")) {
                dao.atualizarStatus(ocorrenciaId, "Aberta");
                // Justificativa pode ser salva em tabela de log/atendimento
            }
            resp.sendRedirect("AdminPainelServlet?orgao_id=" + req.getParameter("orgao_id"));
        } catch (Exception e) {
            req.setAttribute("mensagemErro", "Erro ao atualizar ocorrência: " + e.getMessage());
            req.getRequestDispatcher("pages/erro.jsp").forward(req, resp);
        }
    }
} 