package br.gov.conectasos.controller;

import br.gov.conectasos.model.Anexo;
import br.gov.conectasos.util.ConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/UploadAnexoServlet")
@MultipartConfig
public class UploadAnexoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int ocorrenciaId = Integer.parseInt(req.getParameter("ocorrencia_id"));
        Part filePart = req.getPart("anexo");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String tipo = filePart.getContentType();
        String uploadPath = getServletContext().getRealPath("/uploads/") + File.separator + fileName;
        try (InputStream fileContent = filePart.getInputStream();
             FileOutputStream fos = new FileOutputStream(uploadPath)) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fileContent.read(buffer)) > 0) fos.write(buffer, 0, len);
        }
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO anexos (ocorrencia_id, tipo, caminho) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ocorrenciaId);
            stmt.setString(2, tipo);
            stmt.setString(3, fileName);
            stmt.executeUpdate();
            resp.sendRedirect("pages/dashboard.jsp");
        } catch (Exception e) {
            req.setAttribute("mensagemErro", "Erro ao fazer upload: " + e.getMessage());
            req.getRequestDispatcher("pages/erro.jsp").forward(req, resp);
        }
    }
} 