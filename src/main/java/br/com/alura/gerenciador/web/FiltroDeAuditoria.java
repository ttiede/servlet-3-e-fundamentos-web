package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebFilter;
import br.com.alura.gerenciador.web.interfaces.Filter;
import br.com.alura.gerenciador.system.Cookies;

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
            FilterChain chain, HttpServletResponse resp) throws IOException, ServletException {
    	HttpServletRequest req = (HttpServletRequest) request;
    	Cookie cookie = new Cookies(req.getCookies()).getUsuarioLogado();
    	String usuario = "<deslogado>";        
        if (cookie != null){
             usuario = cookie.getValue();
             cookie.setMaxAge(60 * 10); // 10 * 60 segundos, são dez minutos
             resp.addCookie(cookie);
        }
         System.out.println("Usuario " + usuario + " acessando a URI "
                 + req.getRequestURI());
         chain.doFilter(request, response);
    }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain req) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}


}
