package com.example.curse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curse.entities.User;
import com.example.curse.repository.CurseRepository;
import com.example.curse.service.exceptions.DatabaseExeption;
import com.example.curse.service.exceptions.ResourceNotFoundException;

@Service
//@RequiredArgsConstructor
public class UserService {

	@Autowired
	private CurseRepository curseRepository;

	// esse aqui e feito para o @GetMapping
	public List<User> buscarContato() {
		return curseRepository.findAll();
	}

	// ess aqui vai procurar com o id no banco de dado @GetMapping("{id}")
	public Optional<User> buscarContatoId(Long Id) {
		return curseRepository.findById(Id);
	}

	// esse ele vai adicionar o valor no banco de dado @PostMapping
	public User salvarUsuario(User user) {
		try {

			Optional<User> usex = curseRepository.findByEmail(user.getEmail());
			//se ja exite e for igual ao que veio, nao precisa salvar de novo
			if (!usex.isPresent()) {
				return curseRepository.save(user);//retorna o mesmo usuario
			} else {
				throw new DatabaseExeption("Ja exite esse Email");
			}
			
		} catch (DatabaseExeption x) {
			throw new DatabaseExeption(x.getMessage());
		}
	}

	// esse ele vai deletar o usuario pelo id
	public void deletarUsuario(Long id) {
		curseRepository.deleteById(id);

	}

	// atualizar o usuario usando o @PutMapping
	public User UpdateUsuario(Long id, User obj) {
		try {
			// caso nao encontre o id
			User request = curseRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Usuario nao encontrado" + id));
			request.setName(obj.getName());
			request.setEmail(obj.getEmail());
			request.setPhone(obj.getPhone());
			request.setPassword(obj.getPassword());
			return curseRepository.save(request);

		} catch (DatabaseExeption x) {
			throw new DatabaseExeption(x.getMessage());
		}
	}
}
