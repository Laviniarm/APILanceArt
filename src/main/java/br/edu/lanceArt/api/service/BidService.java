package br.edu.lanceArt.api.service;

import br.edu.lanceArt.api.dto.BidCreateDTO;
import br.edu.lanceArt.api.dto.BidResponseDTO;
import br.edu.lanceArt.api.entity.Bid;
import br.edu.lanceArt.api.entity.User;
import br.edu.lanceArt.api.entity.WorkOfArt;
import br.edu.lanceArt.api.exceptions.BidNotFoundException;
import br.edu.lanceArt.api.exceptions.UserNotFoundException;
import br.edu.lanceArt.api.exceptions.ObraDeArteNotFoundException;
import br.edu.lanceArt.api.repository.BidRepository;
import br.edu.lanceArt.api.repository.UserRepository;
import br.edu.lanceArt.api.repository.WorkOfArtRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidService {

    @Autowired
    private BidRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WorkOfArtRepositorio workOfArtRepositorio;

    public List<BidResponseDTO> list() {
        return repository.findAll()
                .stream()
                .map(BidResponseDTO::new)
                .toList();
    }

    public BidResponseDTO findById(Long id) {
        Bid bid = repository.findById(id)
                .orElseThrow(() -> new BidNotFoundException(id));
        return new BidResponseDTO(bid);
    }

    public BidResponseDTO create(BidCreateDTO dto) {
        User user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new UserNotFoundException(dto.userId()));
        WorkOfArt workOfArt = workOfArtRepositorio.findById(dto.workOfArtId())
                .orElseThrow(() -> new ObraDeArteNotFoundException(dto.workOfArtId()));

        Bid bid = new Bid();
        bid.setValor(dto.valor());
        bid.setData(dto.data());
        bid.setUser(user);
        bid.setWorkOfArt(workOfArt);

        Bid saved = repository.save(bid);
        return new BidResponseDTO(saved);
    }

    @Transactional
    public BidResponseDTO update(Long id, BidCreateDTO dto) {
        Bid bid = repository.findById(id)
                .orElseThrow(() -> new BidNotFoundException(id));
        User user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new UserNotFoundException(dto.userId()));
        WorkOfArt workOfArt = workOfArtRepositorio.findById(dto.workOfArtId())
                .orElseThrow(() -> new ObraDeArteNotFoundException(dto.workOfArtId()));

        bid.setValor(dto.valor());
        bid.setData(dto.data());
        bid.setUser(user);
        bid.setWorkOfArt(workOfArt);

        return new BidResponseDTO(bid);
    }

    @Transactional
    public void delete(Long id) {
        Bid bid = repository.findById(id)
                .orElseThrow(() -> new BidNotFoundException(id));
        repository.delete(bid);
    }
}
