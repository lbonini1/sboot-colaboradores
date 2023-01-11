package br.com.sboot.colaboradores.utils;

public class StringUtils {
	
	public static String retornoTextoCaixaAlta(String texto) {
		return "".equals(texto) || null == texto  ? null : texto.toUpperCase();
	}
	
}
