package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Usuario;

public class AssertTest {
  
	
	@Test
	public void test() {
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		
		Assert.assertEquals(1, 1); // compara 2 valores iguais
		
		int i = 5;
		Integer i2 = 5;
		// vai comparar se os valores sao osde outro objeto
		Assert.assertEquals(Integer.valueOf(i), i2);
		Assert.assertEquals(i, i2.intValue());
		
		Assert.assertEquals("bola", "bola");
		Assert.assertNotEquals("bola", "casa");
		Assert.assertTrue("bola" .equalsIgnoreCase("Bola")); // ignora letras maiusculas
		Assert.assertTrue("bola".startsWith("bo")); // verifica a letra inicial
		
		// Instaciacao das variaveis
		Usuario u1 = new Usuario("Usuario 1");
		Usuario u2 = new Usuario("Usuario 1");
		Usuario u3 = u2;
		// COmparação das msms instancias
		Assert.assertSame(u3, u2);
		
		
	}
}
