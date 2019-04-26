package co.esampio.bussines.service.usecurity.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.esampio.bussines.service.usecurity.IUsuarioService;
import co.esampio.repo.entity.usecurity.UsuarioEntity;
import co.esampio.repo.repository.usecurity.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {
	
	@Autowired
	IUsuarioRepository usuarioRepository;

	@Override
	public UsuarioEntity save(UsuarioEntity usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public List<UsuarioEntity> getAll() {
		return usuarioRepository.getAllUsers();
	}

	@Override
	public Boolean validateAuth(String usuario, String contra) {
		return usuarioRepository.authenticateUser(usuario, contra).isPresent();
	}
}
