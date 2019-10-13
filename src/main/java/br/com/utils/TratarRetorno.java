package br.com.utils;

import java.util.List;

import br.com.entity.Pessoa;

public class TratarRetorno {

	public static List<Pessoa> retornoPessoa(List<Pessoa> pessoa) {
		for(Pessoa p: pessoa) {
			p.setDocumento(changeCharInPosition(p.getDocumento()));
		}
		
		return pessoa;
		
	}
	
	public static String changeCharInPosition( String str){
		int position = 1;
		char ch = '*';
	    char[] charArray = str.toCharArray();
	    charArray[position] = ch;
	    return new String(charArray);
	}
}
