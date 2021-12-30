package com.proyecto.arriendo.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.stereotype.Component;


@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserDetails user = (UserDetails) authentication.getPrincipal();
		
		String url = request.getContextPath();
		
				
		if(user.getAuthorities().contains(new SimpleGrantedAuthority("1")))
		{
			url = "/admin";
		}
		else if(user.getAuthorities().contains(new SimpleGrantedAuthority("2")))
		{
			url = "/index/funcionario";
		}
		else
		{	
			DefaultSavedRequest r = (DefaultSavedRequest)request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST");
			if(r == null)
			{
				url = "/";
			}
			else {
				url = r.getRedirectUrl();
			}
			
		}
		response.sendRedirect(url);	
		
	}

	
}
