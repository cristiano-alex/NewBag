package br.edu.positivo.sistemaweb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.TransactionScoped;

import br.edu.positivo.sistemaweb.entity.Usuario;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED) 
public class UsuarioServiceImpl implements UsuarioService {
	
	@PersistenceContext(unitName = "sistemaweb")
	EntityManager em;
	
	@Override
	@TransactionScoped()
	public void salvar(Usuario usuario) {
		em.persist(usuario);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listar() {
		Query query = em.createQuery("select u from Usuario u");
		return query.getResultList();
	}

}
