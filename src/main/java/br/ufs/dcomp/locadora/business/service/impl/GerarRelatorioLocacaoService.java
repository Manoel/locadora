package br.ufs.dcomp.locadora.business.service.impl;

import java.util.List;

import br.ufs.dcomp.locadora.business.service.api.IGerarRelatorioLocacaoService;
import br.ufs.dcomp.locadora.entity.Locacao;

public class GerarRelatorioLocacaoService implements
		IGerarRelatorioLocacaoService {

	@Override
	public List<Locacao> obterLocacoes() {
		return Locacao.getLocacoes();
	}

}
