package br.ufs.dcomp.locadora.entity;

import static org.testng.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class PeriodoTest {
	
	private Periodo periodoBase;
	private Periodo periodoAnteriorAoBase;
	private Periodo periodoConflitanteComBase;
	
	@BeforeClass
	public void inicializarPeriodos() {
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		Date dataInicial = gregorianCalendar.getTime();
		
		gregorianCalendar.add(Calendar.MONTH, 1);
		Date dataFinal = gregorianCalendar.getTime();
		
		periodoBase = new Periodo(dataInicial, dataFinal);
		
		gregorianCalendar.add(Calendar.MONTH, -2);
		Date dataFinalPeriodoAnterior = gregorianCalendar.getTime();
		
		gregorianCalendar.add(Calendar.MONTH, -1);
		Date dataInicialPeriodoAnterior = gregorianCalendar.getTime();
		
		periodoAnteriorAoBase = new Periodo(dataInicialPeriodoAnterior, dataFinalPeriodoAnterior);
		
		periodoConflitanteComBase = periodoBase;
		
	}
	
	@Test
	public void testCompararUmPeriodoComPeriodoAnteriorDeveRetornarUm() {
		int comparacao = periodoBase.compareTo(periodoAnteriorAoBase);
		
		assertEquals(comparacao, 1);
	}
	
	@Test
	public void testCompararUmPeriodoComPeriodoPosteriorDeveRetornarMenosUm() {
		int comparacao = periodoAnteriorAoBase.compareTo(periodoBase);
		
		assertEquals(comparacao, -1);
	
	}
	
	@Test
	public void testCompararUmPeriodoComPeriodoConflitanteDeveRetornarZero() {
		int comparacao = periodoBase.compareTo(periodoConflitanteComBase);
		
		assertEquals(comparacao, 0);
	}
	
	

}
