package br.gov.conectasos.controller;

import br.gov.conectasos.dao.OcorrenciaDAO;
import br.gov.conectasos.model.Ocorrencia;
import br.gov.conectasos.util.ConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

@WebServlet("/RelatorioExportServlet")
public class RelatorioExportServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tipo = req.getParameter("tipo"); // "pdf" ou "excel"
        try (Connection conn = ConnectionFactory.getConnection()) {
            OcorrenciaDAO dao = new OcorrenciaDAO(conn);
            List<Ocorrencia> lista = dao.buscarPorOrgao(1); // Exemplo: órgão 1
            if ("excel".equals(tipo)) {
                resp.setContentType("application/vnd.ms-excel");
                resp.setHeader("Content-Disposition", "attachment; filename=relatorio_ocorrencias.xls");
                PrintWriter out = resp.getWriter();
                out.println("ID\tCategoria\tStatus\tDescrição");
                for (Ocorrencia o : lista) {
                    out.println(o.getId()+"\t"+o.getCategoria()+"\t"+o.getStatus()+"\t"+o.getDescricao());
                }
            } else {
                resp.setContentType("application/pdf");
                resp.setHeader("Content-Disposition", "attachment; filename=relatorio_ocorrencias.pdf");
                PrintWriter out = resp.getWriter();
                out.println("Relatório de Ocorrências\n\n");
                for (Ocorrencia o : lista) {
                    out.println("ID: "+o.getId()+" | Categoria: "+o.getCategoria()+" | Status: "+o.getStatus()+" | Desc: "+o.getDescricao());
                }
            }
        } catch (Exception e) {
            resp.setContentType("text/plain");
            resp.getWriter().println("Erro ao exportar relatório: "+e.getMessage());
        }
    }
} 