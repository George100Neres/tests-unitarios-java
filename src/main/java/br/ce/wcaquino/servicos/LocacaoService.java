package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.utils.DataUtils.adicionarDias;

import java.util.Date;
import java.util.List;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.com.wcaquino.exceptions.FilmeSemEstoqueException;
import br.com.wcaquino.exceptions.LocadoraException;

public class LocacaoService {
	
	
	
	public Locacao alugarFilme(Usuario usuario, List<Filme> filmes) throws LocadoraException, FilmeSemEstoqueException   {
		
		if(usuario == null) {
			throw new LocadoraException("Usuario vazio");
		}
		
		if(filmes == null || filmes.isEmpty()) {
			throw new LocadoraException("Filme vazio");
		}
		
		for(Filme filme: filmes) {
		if(filme.getEstoque() == 0) {
			throw new FilmeSemEstoqueException();
	      	}
		}
		
		Locacao locacao = new Locacao();
		locacao.setFilmes(filmes);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		Double valorTotal = 0d;
		for(Filme filme: filmes) {
			valorTotal += filme.getPrecoLocacao();
		}
		locacao.setValor(valorTotal);

		//Entrega no dia seguinte
		Date dataEntrega = new Date(); // Data Atual
		dataEntrega = adicionarDias(dataEntrega, 1); //acrescenta mais 1 dia
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//TODO adicionar mÃ©todo para salvar
		
		return locacao;
	}
	/*
	 @Test
	public void teste() throws Exception {
		
		// cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 2, 5.0);
		
		// acao
		Locacao locacao = service.alugarFilme(usuario, filme);
		
		// verificacao
		Assert.assertTrue(locacao.getValor() == 5.0); // checando o valor  do filme
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date())); // data alocacao
		 // verificar retorno com diderença de apenas 1 dia
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
		
		
	} */
}