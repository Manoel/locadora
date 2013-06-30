package br.ufs.dcomp.locadora.entity;

import static org.testng.Assert.*;

import java.util.Date;

import org.testng.annotations.Test;

public class LocacaoTest {

	@Test
	public void testLocacaoVeiculoDisponivel() {
		Cliente cliente = new Cliente();
		Veiculo veiculo = new Veiculo();
		Periodo periodo = new Periodo(new Date(), new Date());
		Locacao locacao = new Locacao(cliente, veiculo, periodo);

		boolean locacaoRealizada = locacao.realizarLocacao();

		assertTrue(locacaoRealizada);
	}

	@Test
	public void testLocacaoVeiculoJaAlugado() {
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		Veiculo veiculo = new Veiculo();
		Periodo periodo = new Periodo(new Date(), new Date());
		Locacao locacao1 = new Locacao(cliente1, veiculo, periodo);
		Locacao locacao2 = new Locacao(cliente2, veiculo, periodo);

		boolean locacaoRealizada = locacao1.realizarLocacao();

		assertTrue(locacaoRealizada);

		locacaoRealizada = locacao2.realizarLocacao();

		assertFalse(locacaoRealizada);
	}
	
	@Test
	public void testDevolucaoDeVeiculoComSucesso() {
		Cliente cliente = new Cliente();
		Veiculo veiculo = new Veiculo();
		Periodo periodo = new Periodo(new Date(), new Date());
		Locacao locacao = new Locacao(cliente, veiculo, periodo);
		
		boolean locacaoRealizada = locacao.realizarLocacao();

		assertTrue(locacaoRealizada);

		boolean locacaoFinalizada = locacao.finalizarLocacao();

		assertTrue(locacaoFinalizada);
	}

}
