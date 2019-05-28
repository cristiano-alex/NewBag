package br.edu.positivo.sistemaweb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.TransactionScoped;

import br.edu.positivo.sistemaweb.entity.Cliente;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED) 
public class ClienteServiceImpl implements ClienteService {

	@PersistenceContext(unitName = "sistemaweb")
	EntityManager em;
	
	@Override
	@TransactionScoped()
	public void salvar(Cliente cliente) {
		em.persist(cliente);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listar() {
		Query query = em.createQuery("select c from Cliente c");
		return query.getResultList();
	}

	
	
}
