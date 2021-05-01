package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Usuario;
import br.com.fiap.utils.EntityManagerFacade;

public class UsuarioDAO {

	public void save(Usuario usuario) {
		EntityManager manager = EntityManagerFacade.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();

		manager.close();

	}

	public List<Usuario> getAll() {
		EntityManager manager = EntityManagerFacade.getEntityManager();
		String jpql = "SELECT u FROM Usuario u";
		TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
		return query.getResultList();

	}
}
