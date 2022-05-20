package it.prova.gestioneproprietari.service.automobile;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneproprietari.dao.EntityManagerUtil;
import it.prova.gestioneproprietari.dao.automobile.AutomobileDAO;
import it.prova.gestioneproprietari.model.Automobile;

public class AutomobileServiceImpl implements AutomobileService {

	private AutomobileDAO automobileDAO;

	public void setAutomobileDAO(AutomobileDAO automobileDAO) {
		this.automobileDAO = automobileDAO;
	}

	public List<Automobile> listAllAutomobili() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			automobileDAO.setEntityManager(entityManager);

			return automobileDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	public Automobile caricaSingoloAbitante(Long id) throws Exception {
		return null;
	}

	public void aggiorna(Automobile automobileInstance) throws Exception {
	}

	public void inserisciNuovo(Automobile automobileInstance) throws Exception {
	}

	public void rimuovi(Long idAutomobileInstance) throws Exception {
	}

	public List<Automobile> cercaTutteLeAutomobiliCheHannoProprietarioConCodiceFiscaleCheIniziaCon(String inizialeInput)
			throws Exception {
		return null;
	}

	public List<Automobile> automobiliConErrori() throws Exception {
		return null;
	}

}
