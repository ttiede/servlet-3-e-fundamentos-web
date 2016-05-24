package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.web.interfaces.Filter;

@WebFilter(urlPatterns="/*")

public class FiltroDeAuditoria implements Filter{

	@Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
    	String usuario = getUsuario(req);
		String uri = req.getRequestURI();
		System.out.println("Usuario " + usuario + " acessando a URI " + uri);
        chain.doFilter(request, response);
    }
    
	private String getUsuario(HttpServletRequest req) {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
		if(usuario==null) return "<deslogado>";
		return usuario.getEmail();
	}

}
