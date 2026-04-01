package br.edu.lanceArt.api.service;

import br.edu.lanceArt.api.dto.UserCreateDTO;
import br.edu.lanceArt.api.dto.UserResponseDTO;
import br.edu.lanceArt.api.entity.User;
import br.edu.lanceArt.api.exceptions.UserNotFoundException;
import br.edu.lanceArt.api.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UserResponseDTO> list() {
        return repository.findAll()
                .stream()
                .map(UserResponseDTO::new)
                .toList();
    }

    public UserResponseDTO findById(Long id) {
        Long userId = Objects.requireNonNull(id, "id nao pode ser nulo");
        User user = repository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        return new UserResponseDTO(user);
    }

    public UserResponseDTO create(UserCreateDTO dto) {
        User user = new User();
        user.setNome(dto.nome());
        user.setEmail(dto.email());
        user.setSenha(passwordEncoder.encode(dto.senha()));

        User saved = repository.save(user);
        return new UserResponseDTO(saved);
    }

    @Transactional
    public UserResponseDTO update(Long id, UserCreateDTO dto) {
        Long userId = Objects.requireNonNull(id, "id nao pode ser nulo");
        User user = repository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        user.setNome(dto.nome());
        user.setEmail(dto.email());
        user.setSenha(passwordEncoder.encode(dto.senha()));

        return new UserResponseDTO(user);
    }

    @Transactional
    public void delete(Long id) {
        Long userId = Objects.requireNonNull(id, "id nao pode ser nulo");
        User user = repository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        repository.delete(Objects.requireNonNull(user));
    }
}
