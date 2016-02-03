package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebFilter;
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
    	String uri = req.getRequestURI();
    	System.out.println("Usuario acessando a URI " + uri);
    	chain.doFilter(request, response);
    }
}
