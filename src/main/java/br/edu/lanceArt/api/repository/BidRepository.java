package br.edu.lanceArt.api.repository;

import br.edu.lanceArt.api.entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<Bid, Long> {
}
