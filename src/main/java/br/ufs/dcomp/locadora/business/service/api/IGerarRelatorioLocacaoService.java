package br.ufs.dcomp.locadora.business.service.api;

import java.util.List;

import br.ufs.dcomp.locadora.entity.Locacao;

public interface IGerarRelatorioLocacaoService {

	List<Locacao> obterLocacoes();

}
