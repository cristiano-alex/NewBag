package br.edu.positivo.sistemaweb.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.positivo.sistemaweb.entity.Cliente;
import br.edu.positivo.sistemaweb.service.ClienteService;

@SuppressWarnings("deprecation")
@ManagedBean(name = "mbeanCliente")
@RequestScoped
public class MbeanCliente {

	@EJB
	ClienteService clienteService;
	
	private List<Cliente> clientes;
	private String nome;
	private String login;
	
	@PostConstruct
	public void listar() {
		clientes = clienteService.listar();
	}
	
	public void salvar() {
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setLogin(login);

		clienteService.salvar(cliente);
		listar();
	}
	
	public String excluir(Cliente cliente) {
		clientes.remove(cliente);
		return "";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
