package com.birdapp.birdapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.birdapp.birdapi.entity.Bird;
import org.springframework.stereotype.Repository;

public interface BirdRepository extends JpaRepository<Bird,Long> {
}

