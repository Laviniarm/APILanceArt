package br.edu.lanceArt.api.repository;
import br.edu.lanceArt.api.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
