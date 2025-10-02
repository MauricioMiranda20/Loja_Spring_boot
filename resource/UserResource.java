package com.example.curse.resource;

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

import com.example.curse.entities.User;
import com.example.curse.service.UserService;

//@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> lista = userService.buscarContato();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> useFindbyId(@PathVariable Long id) {
		return userService.buscarContatoId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public User inserirUser(@RequestBody User detalheUser) {
//		User dadosContato = new User();
		return userService.salvarUsuario(detalheUser);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<User> deletarByUser(@PathVariable Long id,@RequestBody User detalheUser) {
		User obj = userService.UpdateUsuario(id, detalheUser);
		return ResponseEntity.ok(obj);
		
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<User> DeletarUsuario(@PathVariable Long id) {
		if (userService.buscarContatoId(id).isPresent()) {
			userService.deletarUsuario(id);
		}
		return ResponseEntity.noContent().build();

	}
}
