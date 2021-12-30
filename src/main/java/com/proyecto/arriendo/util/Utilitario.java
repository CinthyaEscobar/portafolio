package com.proyecto.arriendo.util;

import java.time.LocalDateTime;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Utilitario {
	
	public static String ACTIVO = "1";
	public static String INACTIVO = "0";
	public static String PATH = "./src/main/resources/static/img/";
	
	
	
	public static long generarId()
	{
		LocalDateTime ldt = LocalDateTime.now();
		String idS = ldt.getYear() + "" + ldt.getMonthValue() + "" + ldt.getDayOfMonth() + 
				"" + ldt.getHour() + "" + ldt.getMinute() + "" + ldt.getSecond();
		Long id = Long.parseLong(idS);
		return id;
	}
	
	
	public static BCryptPasswordEncoder passwordEncoder()
	{
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		return bcpe;
	}
}
