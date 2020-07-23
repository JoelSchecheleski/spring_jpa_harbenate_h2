package com.uppertools.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.uppertools.curso.entities.User;
import com.uppertools.curso.repositories.UserRepository;
import com.uppertools.curso.services.exceptions.DatabaseException;
import com.uppertools.curso.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	/**
	 * Busca todos os usuários cadatrados no sistema
	 * 
	 * @return Retorna um array de objetos Users
	 */
	public List<User> findAll() {
		return repository.findAll();
	}

	/**
	 * Busca um usuário pelo ID
	 * 
	 * @param id Código do usuário a ser localizado
	 * @return Retorna um usuário pelo id
	 */
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	/**
	 * Salva no banco de dados um novo objeto do tipo User.
	 * 
	 * @param obj Objeto recebido no contexto.
	 * @return Retorna o objeto inserido.
	 */
	public User insert(User obj) {
		return repository.save(obj);
	}

	/**
	 * Deleta um objeto pelo id
	 * 
	 * @param id Código do usuário a ser eliminado
	 */
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	/**
	 * Atualiza um objeto
	 * 
	 * @param id  Código do usuário a ser localizado
	 * @param obj Objeto recebido no contexto
	 * @return Objeto usuário atualizado
	 */
	public User update(Long id, User obj) {
		User entity = repository.getOne(id);
		update(entity, obj);
		return repository.save(entity);
	}

	/**
	 * Método privado para atualização de entidade e objeto
	 * 
	 * @param entity Entidade a ser atualizada
	 * @param obj    Objeto recebido por contexto
	 */
	private void update(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

}
