package com.uppertools.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uppertools.curso.entities.User;
import com.uppertools.curso.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	/**
	 * Busca todos os usuários cadatrados no sistema
	 * @return Retorna um array de objetos Users
	 */
	public List<User> findAll(){
		return repository.findAll();
	}
	
	/**
	 * Busca um usuário pelo ID
	 * @param id Código do usuário a ser localizado
	 * @return Retorna um usuário pelo id
	 */
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	/**
	 * Salva no banco de dados um novo objeto do tipo User.
	 * @param obj Objeto recebido no contexto.
	 * @return Retorna o objeto inserido.
	 */
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	
	/**
	 * Deleta um objeto pelo id
	 * @param id Código do usuário a ser eliminado
	 */
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	
}
