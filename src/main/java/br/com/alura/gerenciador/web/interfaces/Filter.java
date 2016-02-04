package br.com.alura.gerenciador.web.interfaces;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public interface Filter extends javax.servlet.Filter {

	void destroy();

	void init(FilterConfig config) throws ServletException;

	void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain, HttpServletResponse resp) throws IOException,
			ServletException;
	
	void doFilter(ServletRequest request, ServletResponse response,
			FilterChain req) throws IOException, ServletException;
		
}
