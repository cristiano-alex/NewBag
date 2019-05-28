package br.edu.positivo.sistemaweb.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.positivo.sistemaweb.entity.Usuario;
import br.edu.positivo.sistemaweb.service.UsuarioService;

@SuppressWarnings("deprecation")
@ManagedBean(name = "mbeanUsuario")
@RequestScoped
public class MbeanUsuario {
	
	@EJB
	UsuarioService usuarioService;
	
	private List<Usuario> usuarios;
	private String nome;
	private String lastName;
	private String email;
	private String password;
	
	@PostConstruct
	public void listar() {
		usuarios = usuarioService.listar();
	}
	
	public void salvar() {
		Usuario usuario = new Usuario();
		usuario.setName(nome);
		usuario.setLastName(lastName);
		usuario.setEmail(email);
		usuario.setPassword(password);

		usuarioService.salvar(usuario);
	}

	public String excluir(Usuario usuario) {
		usuarios.remove(usuario);
		return "";
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
