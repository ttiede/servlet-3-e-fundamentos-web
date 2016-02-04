package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns="/login")
public class Autenticar extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			String email = req.getParameter("email");
	        String senha = req.getParameter("senha");		
	        PrintWriter writer = resp.getWriter();
	        Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
	        HttpSession session = req.getSession();
	        if (usuario != null) {
	        	session.setAttribute("usuario.logado", usuario);
	        	writer.println("<html><body>Usuário logado: " + email
                    + "</body></html>");
	        }
	        else{
	        	writer.println("<html><body>Usuário ou senha inválida</body></html>");
	        }
		}
}
