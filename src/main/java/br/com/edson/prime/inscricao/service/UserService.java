package br.com.edson.prime.inscricao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.edson.prime.inscricao.model.Usuario;
import br.com.edson.prime.inscricao.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<Usuario> getAll() {

		List<Usuario> list = userRepository.findAll();

		return list;

	}

	public Usuario getById(Integer id) {

		Optional<Usuario> Omot = userRepository.findById(id);

		if (Omot.isPresent()) {
			return Omot.get();
		} else {
			return new Usuario();
		}
	}

	@Transactional
	public boolean delete(Integer id) {

		Optional<Usuario> Omot = userRepository.findById(id);

		if (Omot.isPresent()) {
			userRepository.delete(Omot.get());
			return true;
		} else {
			return false;
		}
	}

	@Transactional
	public Usuario update(Usuario dto) {

		Optional<Usuario> Omot = userRepository.findById(dto.getId());

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String senhaCript = encoder.encode(dto.getPassword());

		if (Omot.isPresent()) {
			Usuario mot = Omot.get();

			mot.setEmail(dto.getEmail());
			mot.setPassword(senhaCript);
			userRepository.save(mot);
			return mot;
		} else {
			return new Usuario();
		}
	}

	@Transactional
	public Usuario save(Usuario dto) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String senhaCript = encoder.encode(dto.getPassword());

		dto.setPassword(senhaCript);

		Usuario UsuarioSaved = userRepository.save(dto);

		return UsuarioSaved;

	}

}
