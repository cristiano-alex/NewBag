package br.edu.positivo.sistemaweb.service;

import java.util.List;

import javax.ejb.Local;

import br.edu.positivo.sistemaweb.entity.Usuario;

@Local
public interface UsuarioService {

	public void salvar(Usuario usuario);
	public List<Usuario> listar();
	
	
}
