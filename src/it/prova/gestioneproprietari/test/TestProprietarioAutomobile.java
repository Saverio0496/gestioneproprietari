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

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			EntityManagerUtil.shutdown();
		}
	}

	private static void testCaricaSingoloProprietario(ProprietarioService proprietarioService) throws Exception {
		System.out.println("Inizio testCaricaSingoloProprietario");
		Proprietario ProprietarioDaRicercare = proprietarioService.caricaSingoloProprietario(1L);
		System.out.println(ProprietarioDaRicercare);
		System.out.println("Fine testCaricaSingoloProprietario");
	}

}
