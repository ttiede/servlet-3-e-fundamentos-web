package br.com.alura.gerenciador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/busca")
public class BuscaEmpresa extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
			PrintWriter writer = resp.getWriter();
			writer.println("<html>");
			writer.println("<body>");
			writer.println("Resultado da busca:<br/>");
			writer.println("</body>");
			writer.println("</html>");

	}
}
