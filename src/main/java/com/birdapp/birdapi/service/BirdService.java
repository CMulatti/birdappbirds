package com.birdapp.birdapi.service;

import com.birdapp.birdapi.entity.Bird;
import com.birdapp.birdapi.repository.BirdRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BirdService {

    private final BirdRepository birdRepository;

    public BirdService(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    public List<Bird> findAll() {
        return birdRepository.findAll();
    }

    public Optional<Bird> findById(Long id) {
        return birdRepository.findById(id);
    }

    public Bird save(Bird bird) {
        return birdRepository.save(bird);
    }

    public void delete(Long id) {
        birdRepository.deleteById(id);
    }
}
