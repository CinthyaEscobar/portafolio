package com.proyecto.arriendo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.proyecto.arriendo.details.CustomUserDetails;
import com.proyecto.arriendo.model.Cuenta;
import com.proyecto.arriendo.repository.CuentaRepository;

@Service
public class UsuarioService implements UserDetailsService {

	@Autowired
	private CuentaRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Cuenta c = repo.findByCorreo(username);
		ArrayList<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		System.out.println(c.getIdCuenta()+ " "+ c.getIdTipocuenta().getDescripcion());
		roles.add(new SimpleGrantedAuthority(String.valueOf(c.getIdTipocuenta().getIdTipocuenta())));
		CustomUserDetails userDT = new CustomUserDetails(roles,c.getCorreo(),c.getNombre(), c.getApellidop(),c.getApellidom(),c.getContrasena(), c.getIdCuenta(),true);
		// TODO Auto-generated method stub
		return userDT;
	}

}
