package br.ufs.dcomp.locadora.business.service.impl;

import java.util.Date;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.ufs.dcomp.locadora.business.service.api.IGerarRelatorioLocacaoService;
import br.ufs.dcomp.locadora.entity.Cliente;
import br.ufs.dcomp.locadora.entity.Locacao;
import br.ufs.dcomp.locadora.entity.Periodo;
import br.ufs.dcomp.locadora.entity.Veiculo;

public class GerarRelatorioLocacaoServiceTest {

	@Test
	public void gerarRelatorioLocacaoSemFiltroDeveRetornarTodasLocacoes() {
		// Cenario: criacao de tres locacoes e de uma instancia de
		// IGerarRelatorioLocacaoService
		Locacao locacao1 = new Locacao(new Cliente(), new Veiculo(),
				new Periodo(new Date(), new Date()));
		locacao1.realizarLocacao();

		Locacao locacao2 = new Locacao(new Cliente(), new Veiculo(),
				new Periodo(new Date(), new Date()));
		locacao2.realizarLocacao();

		Locacao locacao3 = new Locacao(new Cliente(), new Veiculo(),
				new Periodo(new Date(), new Date()));
		locacao3.realizarLocacao();

		IGerarRelatorioLocacaoService gerarRelatorioLocacaoService = new GerarRelatorioLocacaoService();
		
		// Execução do método para obter as locações já realizadas até o momento
		List<Locacao> locacoes = gerarRelatorioLocacaoService.obterLocacoes();
		
		// verificação de que as locacoes retornadas pelo metodo obterLocacoes
		// contem todas e apenas as locacoes criadas no cenario do teste.
		Assert.assertEquals(locacoes.size(), 3);
		Assert.assertTrue(locacoes.contains(locacao1));
		Assert.assertTrue(locacoes.contains(locacao2));
		Assert.assertTrue(locacoes.contains(locacao3));
	}

}
