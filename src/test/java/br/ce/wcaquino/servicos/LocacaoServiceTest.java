package br.ce.wcaquino.servicos;


import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.servicos.LocacaoService;
import br.ce.wcaquino.utils.DataUtils;
import br.com.wcaquino.exceptions.FilmeSemEstoqueException;
import br.com.wcaquino.exceptions.LocadoraException;

public class LocacaoServiceTest {
		
	// instacia global
	private Locacao service;
	
	 @Rule // 1 Excecao
	   public ErrorCollector error = new ErrorCollector();
	
	 @Rule // 3 Excecao
	 public ExpectedException exception = ExpectedException.none();
	 
	 
	 @Before
	 public void setup() {
		 System.out.println("Before");
		 LocacaoService service = new LocacaoService();
	 }
	 
	 // vai ser executado após cada Teste
	 @After
	 public void tearDown() {
		 System.out.println("After");
	 }
	 
	 /*
	 @Test
		public void teste() throws Exception {
			
			// cenario
			LocacaoService service = new LocacaoService();
			Usuario usuario = new Usuario("Usuario 1");
			Filme filmes = new Filme("Filme 1", 2, 5.0);
			
			System.out.println("Teste!");
			
			// acao
			locacao locacao = service.alugarFilme(usuario, filmes);
			
			// verificação com usando erroThat
				error.checkThat(locacao.getValor(), CoreMatchers.is(5.0)); // eigual ao valor
				error.checkThat(locacao.getValor(), CoreMatchers.not(8.0)); // verifica se o valor nao e igual
				Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date())); // data alocacao
				Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
				
	 }
				/* verificacao usando a assertiva AssertThat
				 * Assert.assertThat(locacao.getValor(), CoreMatchers.is(5.0)); // eigual ao valor
				Assert.assertThat(locacao.getValor(), CoreMatchers.not(8.0)); // verifica se o valor nao e igual
				Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date())); // data alocacao
				Assert.assertTrue(DataUtils.isMesmaData(locaca
				 */
				
				
				
			//Assert.assertTrue(locacao.getValor() == 5.0); // checando o valor  do filme
			 // verificar retorno com diderença de apenas 1 dia
			
			
			
					// 1 Execeção, TEste Elegante
	@Test(expected=Exception.class)  // Lanca uma excecao Esperada
	public void testLocacao_FilmeSemEstoque() throws Exception {
			  // cenario
	LocacaoService service = new LocacaoService();
	Usuario usuario = new Usuario("Usuario 1");
	List<Filme>filmes = Arrays.asList(new Filme("Filme 1", 0, 4.0));				
	
					// acao

	
     service.alugarFilme(usuario, filmes);
					
	}
	
	//Tratamento 2Robusto
	@Test
	public void testLocacao_usuarioVazio() throws FilmeSemEstoqueException {
		// cenario
		LocacaoService service = new LocacaoService();
		List<Filme> filmes = Arrays.asList(new Filme("Filme 2", 1, 4.0));
		
		// acao
			// quando for vazio, o teste ira falhar
			try {
				service.alugarFilme(null, filmes);
				Assert.fail();
			} catch (LocadoraException e) {
			 Assert.assertEquals(e.getMessage(), ("Usuario vazio"));
			}
	}
	
	
	// 2 Excpetion,maneira Nova
	// 
	@Test(expected = FilmeSemEstoqueException.class)
	public void testLocacao_filmeSemEstoque() { 
	// cenario
	Usuario usuario = new Usuario("Usuario 1");
	List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 0, 4.0));
	
	// acao
	service.alugarFilme(usuario, filmes);
	
	} 
	
	public void deveAlugarFilme() throws FilmeSemEstoqueException, LocadoraException {
	 // cenario
	 LocacaoService service = new LocacaoService();
	 Usuario usuario = new Usuario("Usuario 1");
	 
	 exception.expect(LocadoraException.class);
	 exception.expectMessage("Filme vazio");
	 
	 // acao
	 service.alugarFilme(usuario, null);
	}
}
