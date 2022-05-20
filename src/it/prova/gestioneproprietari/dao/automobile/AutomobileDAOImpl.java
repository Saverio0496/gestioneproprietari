package it.prova.gestioneproprietari.dao.automobile;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneproprietari.model.Automobile;

public class AutomobileDAOImpl implements AutomobileDAO {
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Automobile> list() throws Exception {
		return entityManager.createQuery("from Automobile", Automobile.class).getResultList();
	}

	public Automobile get(Long id) throws Exception {
		return null;
	}

	public void update(Automobile o) throws Exception {
	}

	public void insert(Automobile o) throws Exception {
	}

	public void delete(Automobile o) throws Exception {
	}

	public List<Automobile> findAllByCodiceFiscaleIniziaCon(String inizialeInput) throws Exception {
		return null;
	}

	public List<Automobile> findAllAutomobiliConErrori() throws Exception {
		return null;
	}

}
