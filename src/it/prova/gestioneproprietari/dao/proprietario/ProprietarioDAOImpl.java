package it.prova.gestioneproprietari.dao.proprietario;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneproprietari.model.Proprietario;

public class ProprietarioDAOImpl implements ProprietarioDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Proprietario> list() throws Exception {
		return entityManager.createQuery("from Proprietario", Proprietario.class).getResultList();
	}

	public Proprietario get(Long id) throws Exception {
		return null;
	}

	public void update(Proprietario o) throws Exception {
	}

	public void insert(Proprietario o) throws Exception {
	}

	public void delete(Proprietario o) throws Exception {
	}

	public int countHowManyProprietariPossiedonoAutomobiliImmatricolateDopoIl(int annoInput) throws Exception {
		return 0;
	}

}
