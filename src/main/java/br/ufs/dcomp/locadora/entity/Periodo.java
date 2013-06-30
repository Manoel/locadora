package br.ufs.dcomp.locadora.entity;

import java.util.Date;

public class Periodo implements Comparable<Periodo> {
	
	private Date dataInicial;
	private Date dataFinal;
	
	public Periodo(Date dataInicial, Date dataFinal) {
		super();
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	@Override
	public int compareTo(Periodo outroPeriodo) {
		if ( getDataFinal().before(outroPeriodo.getDataInicial()) ) {
			return -1;
		}
		
		if ( getDataInicial().after(outroPeriodo.getDataFinal()) ) {
			return 1;
		}
		
		// períodos conflitantes
		return 0;
	}
	
}