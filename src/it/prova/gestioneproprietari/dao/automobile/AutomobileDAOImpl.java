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
		return entityManager.find(Automobile.class, id);
	}

	public void update(Automobile automobileInstance) throws Exception {
		if (automobileInstance == null) {
			throw new Exception("Problema valore in input");
		}

		automobileInstance = entityManager.merge(automobileInstance);
	}

	public void insert(Automobile automobileInstance) throws Exception {
		if (automobileInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(automobileInstance);
	}

	public void delete(Automobile automobileInstance) throws Exception {
	}

	public List<Automobile> findAllByCodiceFiscaleIniziaCon(String inizialeInput) throws Exception {
		return null;
	}

	public List<Automobile> findAllAutomobiliConErrori() throws Exception {
		return null;
	}

}
