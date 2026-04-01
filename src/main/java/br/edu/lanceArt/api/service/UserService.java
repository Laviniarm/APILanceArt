package br.edu.lanceArt.api.service;

import br.edu.lanceArt.api.dto.UserCreateDTO;
import br.edu.lanceArt.api.dto.UserResponseDTO;
import br.edu.lanceArt.api.entity.User;
import br.edu.lanceArt.api.exceptions.UserNotFoundException;
import br.edu.lanceArt.api.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserResponseDTO> list() {
        return repository.findAll()
                .stream()
                .map(UserResponseDTO::new)
                .toList();
    }

    public UserResponseDTO findById(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return new UserResponseDTO(user);
    }

    public UserResponseDTO create(UserCreateDTO dto) {
        User user = new User();
        user.setNome(dto.nome());
        user.setEmail(dto.email());
        user.setSenha(dto.senha());

        User saved = repository.save(user);
        return new UserResponseDTO(saved);
    }

    @Transactional
    public UserResponseDTO update(Long id, UserCreateDTO dto) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        user.setNome(dto.nome());
        user.setEmail(dto.email());
        user.setSenha(dto.senha());

        return new UserResponseDTO(user);
    }

    @Transactional
    public void delete(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        repository.delete(user);
    }
}
