package br.edu.lanceArt.api.service;

import br.edu.lanceArt.api.dto.LoginRequestDTO;
import br.edu.lanceArt.api.dto.LoginResponseDTO;
import br.edu.lanceArt.api.entity.User;
import br.edu.lanceArt.api.exceptions.InvalidCredentialsException;
import br.edu.lanceArt.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginResponseDTO login(LoginRequestDTO dto) {
        User user = userRepository.findByEmail(dto.email())
                .orElseThrow(InvalidCredentialsException::new);

        if (!passwordEncoder.matches(dto.senha(), user.getSenha())) {
            throw new InvalidCredentialsException();
        }

        String token = jwtService.generateToken(user.getId(), user.getEmail());

        return new LoginResponseDTO(
                token,
                "Bearer",
                jwtService.getExpirationMs(),
                user.getId(),
                user.getNome(),
                user.getEmail()
        );
    }
}
