package it.prova.gestioneproprietari.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.prova.gestioneproprietari.dao.EntityManagerUtil;
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
			throw new RuntimeException("testAggiornaProprietario fallito: non ci sono proprietari a cui collegarci ");
		Proprietario proprietarioDaAggiornare = elencoProprietariPresenti.get(0);
		proprietarioDaAggiornare.setNome("Saverio");
		System.out.println(proprietarioDaAggiornare);
		System.out.println("Fine testAggiornareProprietario");
	}

}
