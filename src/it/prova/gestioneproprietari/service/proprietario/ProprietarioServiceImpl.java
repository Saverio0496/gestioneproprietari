package it.prova.gestioneproprietari.service.proprietario;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneproprietari.dao.EntityManagerUtil;
import it.prova.gestioneproprietari.dao.proprietario.ProprietarioDAO;
import it.prova.gestioneproprietari.model.Proprietario;

public class ProprietarioServiceImpl implements ProprietarioService {

	private ProprietarioDAO proprietarioDAO;

	public void setProprietarioDAO(ProprietarioDAO proprietarioDAO) {
		this.proprietarioDAO = proprietarioDAO;
	}

	@Override
	public List<Proprietario> listAllProprietari() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			proprietarioDAO.setEntityManager(entityManager);

			return proprietarioDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	public Proprietario caricaSingoloAbitante(Long id) throws Exception {
		return null;
	}

	public void aggiorna(Proprietario proprietarioInstance) throws Exception {
	}

	public void inserisciNuovo(Proprietario proprietarioInstance) throws Exception {
	}

	public void rimuovi(Long idProprietarioInstance) throws Exception {
	}

	public int contaQuantiProprietariPossiedonoAutomobiliImmatricolateDopoIl(int annoInput) throws Exception {
		return 0;
	}

}
