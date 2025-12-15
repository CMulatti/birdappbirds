package com.birdapp.birdapi.controller;

import com.birdapp.birdapi.entity.Bird;
import com.birdapp.birdapi.service.BirdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173") // Allow React frontend,this is the port when we run the app in npm run dev
@RestController
@RequestMapping("/api/birds")
public class BirdController {

    private final BirdService birdService;

    //Constructor injection
    public BirdController(BirdService birdService) {
        this.birdService = birdService;
    }

    //GET all birds
    @GetMapping
    public List<Bird> getAll() {
        return birdService.findAll();
    }

    //GET one bird by ID
    @GetMapping("/{id}")
    public ResponseEntity<Bird> getOne(@PathVariable Long id) {
        return birdService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // CREATE (POST) new bird
    @PostMapping
    public ResponseEntity<Bird> create(@RequestBody Bird bird) {
        Bird saved = birdService.save(bird);
        return ResponseEntity
                .created(URI.create("/api/birds/" + saved.getBirdId()))
                .body(saved);
    }

    //UPDATE bird
    @PutMapping("/{id}")
    public ResponseEntity<Bird> update(@PathVariable Long id, @RequestBody Bird bird) {
        return birdService.findById(id)
                .map(existing -> {
                    existing.setName(bird.getName());
                    existing.setScientificname(bird.getScientificname());
                    existing.setDescription(bird.getDescription());
                    existing.setImage(bird.getImage());
                    Bird updated = birdService.save(existing);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }


    // DELETE bird
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        birdService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
