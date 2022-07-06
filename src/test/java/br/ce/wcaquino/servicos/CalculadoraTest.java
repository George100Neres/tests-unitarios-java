package br.ce.wcaquino.servicos;

import org.junit.Test;

import br.com.wcaquino.exceptions.NaoPodeDividirPorZeroException;

import org.junit.Assert;
import org.junit.Before;

public class CalculadoraTest {
  
	// a Instaciaçao da Calculadora será Global
	private Calculadora calc;
	
	
	@Before
	public void setup() {
		calc = new Calculadora();
	}
	
	@Test
	public void deveSomarDoisValores() {
		//cenario
		int a = 5;
		int b = 3;
		
		
		// acao
	  int resultado = calc.somar(a, b);
		
	  //verificaçao resulado deve ser 8
	  Assert.assertEquals(8, resultado);
	}
	
	
	@Test
	public void deveSubtrairDoisValores() {
		//cenario
		int a = 8;
		int b = 5;
		Calculadora calc = new Calculadora();
		//acao
		int resultado = calc.subtrair(a, b);
		
		//verificacao
		Assert.assertEquals(3,  resultado);
	}
	
	public void deveDividirDoisValores() throws NaoPodeDividirPorZeroException {
		//cenario
		int a =6;
		int b = 3;
		
		
		// acao
		int resultado = calc.divide(a,b);
		
		//verificacao
		Assert.assertEquals(2, resultado);
	}
	
	@Test(expected = NaoPodeDividirPorZeroException.class)
	public void deveLancarExcecaoAoDividirPorZero() throws NaoPodeDividirPorZeroException {
		int a =10;
		int b = 0;
		
		
		calc.divide(a, b);
	}
}
