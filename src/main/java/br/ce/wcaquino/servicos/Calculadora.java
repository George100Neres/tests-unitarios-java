package br.ce.wcaquino.servicos;

import br.com.wcaquino.exceptions.NaoPodeDividirPorZeroException;

public class Calculadora {

	public int somar(int a, int b) {
		// TODO Auto-generated method stub
		return  a + b;
	}

	public int subtrair(int a, int b) {
		// TODO Auto-generated method stub
		return a - b;
	}

	public int divide(int a, int b) throws NaoPodeDividirPorZeroException {
		
		if(b == 0) {
			throw new NaoPodeDividirPorZeroException();
		}
		
		return a / b;
	}
}
