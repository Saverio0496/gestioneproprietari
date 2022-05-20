package it.prova.gestioneproprietari.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.prova.gestioneproprietari.dao.EntityManagerUtil;
import it.prova.gestioneproprietari.model.Automobile;
import it.prova.gestioneproprietari.model.Proprietario;
import it.prova.gestioneproprietari.service.MyServiceFactory;
import it.prova.gestioneproprietari.service.automobile.AutomobileService;
import it.prova.gestioneproprietari.service.proprietario.ProprietarioService;

public class TestProprietarioAutomobile {

	public static void main(String[] args) {

		ProprietarioService proprietarioService = MyServiceFactory.getProprietarioServiceInstance();
		AutomobileService automobileService = MyServiceFactory.getAutomobileServiceInstance();

		try {
			System.out.println("In tabella Proprietario ci sono " + proprietarioService.listAllProprietari().size()
					+ " elementi.");

			System.out.println(
					"In tabella Automobile ci sono " + automobileService.listAllAutomobili().size() + " elementi.");

			testCaricaSingoloProprietario(proprietarioService);

			testAggiornaProprietario(proprietarioService);

			testInserisciProprietario(proprietarioService);
			System.out.println("In tabella Proprietario ci sono " + proprietarioService.listAllProprietari().size()
					+ " elementi.");

			testRimuoviProprietario(proprietarioService);
			System.out.println("In tabella Proprietario ci sono " + proprietarioService.listAllProprietari().size()
					+ " elementi.");

			testcontaQuantiProprietariPossiedonoAutomobiliImmatricolateDopoIl(proprietarioService);

			testCaricaSingoloAutomobile(automobileService);

			testAggiornaAutomobile(automobileService);

			testInserisciAutomobile(automobileService);

			testRimuoviAutomobile(automobileService);

			testCercaTutteLeAutomobiliCheHannoProprietarioConCodiceFiscaleCheIniziaCon(automobileService,
					proprietarioService);

			testAutomobiliConErrori(automobileService, proprietarioService);

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			EntityManagerUtil.shutdown();
		}
	}

	private static void testCaricaSingoloProprietario(ProprietarioService proprietarioService) throws Exception {
		System.out.println("Inizio testCaricaSingoloProprietario");
		Proprietario proprietarioDaRicercare = proprietarioService.caricaSingoloProprietario(1L);
		System.out.println(proprietarioDaRicercare);
		System.out.println("Fine testCaricaSingoloProprietario");
	}

	private static void testAggiornaProprietario(ProprietarioService proprietarioService) throws Exception {
		System.out.println("Inizio testAggiornaProprietario");
		List<Proprietario> elencoProprietariPresenti = proprietarioService.listAllProprietari();
		if (elencoProprietariPresenti.isEmpty())
			throw new RuntimeException("testAggiornaProprietario fallito: non ci sono proprietari a cui collegarci!");
		Proprietario proprietarioDaAggiornare = elencoProprietariPresenti.get(0);
		proprietarioDaAggiornare.setNome("Saverio");
		System.out.println(proprietarioDaAggiornare);
		System.out.println("Fine testAggiornareProprietario");
	}

	public static void testInserisciProprietario(ProprietarioService proprietarioService) throws Exception {
		System.out.println("Inizio testInserisciProprietario");
		Date dataPerTest = new SimpleDateFormat("dd-MM-yyyy").parse("04-05-1996");
		Proprietario nuovoProprietario = new Proprietario("Saverio", "Carelli", "CRLSVR96E04A323C", dataPerTest);
		if (nuovoProprietario.getId() != null)
			throw new RuntimeException("testInserisciProprietario fallito: record già presente!");
		proprietarioService.inserisciNuovo(nuovoProprietario);
		if (nuovoProprietario.getId() == null)
			throw new RuntimeException("testInserisciProprietario fallito!");
		System.out.println("Fine testInserisciProprietario!");
	}

	public static void testRimuoviProprietario(ProprietarioService proprietarioService) throws Exception {
		System.out.println("Inizio testRimuoviProprietario");
		List<Proprietario> elencoProprietariPresenti = proprietarioService.listAllProprietari();
		if (elencoProprietariPresenti.isEmpty())
			throw new RuntimeException("testRimuoviProprietario fallito: non ci sono proprietari a cui collegarci!");
		proprietarioService.rimuovi(22L);
		System.out.println("Fine testRimuoviProprietario!");

	}

	public static void testcontaQuantiProprietariPossiedonoAutomobiliImmatricolateDopoIl(
			ProprietarioService proprietarioService) throws Exception {
		System.out.println("Inizio testContaQuantiProprietariPossiedonoAutomobiliImmatricolateDopoIl");
		List<Proprietario> elencoProprietariPresenti = proprietarioService.listAllProprietari();
		if (elencoProprietariPresenti.isEmpty())
			throw new RuntimeException(
					"testContaQuantiProprietariPossiedonoAutomobiliImmatricolateDopoIl fallito: non ci sono proprietari a cui collegarci!");
		System.out.println(proprietarioService.contaQuantiProprietariPossiedonoAutomobiliImmatricolateDopoIl(2018));
		System.out.println("Fine testContaQuantiProprietariPossiedonoAutomobiliImmatricolateDopoIl!");

	}

	private static void testCaricaSingoloAutomobile(AutomobileService automobileService) throws Exception {
		System.out.println("Inizio testCaricaSingoloProprietario");
		Automobile automobileDaRicercare = automobileService.caricaSingoloAutomobile(3L);
		System.out.println(automobileDaRicercare);
		System.out.println("Fine testCaricaSingoloProprietario");
	}

	private static void testAggiornaAutomobile(AutomobileService automobileService) throws Exception {
		System.out.println("Inizio testAggiornaAutomobile");
		List<Automobile> elencoAutomobiliPresenti = automobileService.listAllAutomobili();
		if (elencoAutomobiliPresenti.isEmpty())
			throw new RuntimeException("testAggiornaAutomobile fallito: non ci sono proprietari a cui collegarci!");
		Automobile automobileDaAggiornare = elencoAutomobiliPresenti.get(0);
		automobileDaAggiornare.setMarca("Lamborghini");
		System.out.println(automobileDaAggiornare);
		System.out.println("Fine testAggiornareAutomobile!");
	}

	public static void testInserisciAutomobile(AutomobileService automobileService) throws Exception {
		System.out.println("Inizio testInserisciAutomobile");
		Automobile nuovoAutomobile = new Automobile("Fiat", "Punto", "RH609LH", 2010);
		if (nuovoAutomobile.getId() != null)
			throw new RuntimeException("testInserisciAutomobile fallito: record già presente!");
		automobileService.inserisciNuovo(nuovoAutomobile);
		if (nuovoAutomobile.getId() == null)
			throw new RuntimeException("testInserisciAutomobile fallito!");
		System.out.println("Fine testInserisciAutomobile!");
	}

	public static void testRimuoviAutomobile(AutomobileService automobileService) throws Exception {
		System.out.println("Inizio testRimuoviAutomobile");
		List<Automobile> elencoAutomobiliPresenti = automobileService.listAllAutomobili();
		if (elencoAutomobiliPresenti.isEmpty())
			throw new RuntimeException("testRimuoviAutomobile fallito: non ci sono proprietari a cui collegarci!");
		automobileService.rimuovi(13L);
		System.out.println("Fine testRimuoviAutomobile!");
	}

	private static void testCercaTutteLeAutomobiliCheHannoProprietarioConCodiceFiscaleCheIniziaCon(
			AutomobileService abitanteService, ProprietarioService proprietarioService) throws Exception {
		System.out.println("Inizio testCercaTutteLeAutomobiliCheHannoProprietarioConCodiceFiscaleCheIniziaCon");
		List<Proprietario> listaProprietariPresenti = proprietarioService.listAllProprietari();
		if (listaProprietariPresenti.isEmpty())
			throw new RuntimeException(
					"testCercaTutteLeAutomobiliCheHannoProprietarioConCodiceFiscaleCheIniziaCon fallito: non ci sono proprietari a cui collegarci ");
		System.out
				.println(abitanteService.cercaTutteLeAutomobiliCheHannoProprietarioConCodiceFiscaleCheIniziaCon("CR"));
		System.out.println("Fine testCercaTutteLeAutomobiliCheHannoProprietarioConCodiceFiscaleCheIniziaCon!");
	}

	private static void testAutomobiliConErrori(AutomobileService abitanteService,
			ProprietarioService proprietarioService) throws Exception {
		System.out.println("Inizio testCercaTutteLeAutomobiliCheHannoProprietarioConCodiceFiscaleCheIniziaCon");
		List<Proprietario> listaProprietariPresenti = proprietarioService.listAllProprietari();
		if (listaProprietariPresenti.isEmpty())
			throw new RuntimeException("testAutomobiliConErrori fallito: non ci sono proprietari a cui collegarci ");
		System.out.println(abitanteService.automobiliConErrori());
		System.out.println("Fine testAutomobiliConErrori!");
	}

}
