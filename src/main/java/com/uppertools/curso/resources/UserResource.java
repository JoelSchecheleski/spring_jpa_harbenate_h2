package com.uppertools.curso.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.uppertools.curso.entities.User;
import com.uppertools.curso.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	/**
	 * Busca todos os usuários
	 * 
	 * @return Retorna um array de objetos do tipo usuário
	 */
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	/**
	 * Busca um usuário pelo id
	 * 
	 * @param id Código do usuário da requisição path
	 * @return Retorna o usuário localizado pelo id
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}

	/**
	 * Cria um novo usuário
	 * 
	 * @param obj Objeto da requisição
	 * @return Objeto user inserido
	 */
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	/**
	 * Elimina um usuário pelo id
	 * @param id Código do registro de usuário a ser eliminado
	 * @return Retorna 204 como resposta
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	/**
	 * Atualiza um objeto
	 * @param id Código do resgistro de usuário a ser atualizado
	 * @param obj Objeto do tipo User a ser atualizado
	 * @return Objeto User atualizado
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
