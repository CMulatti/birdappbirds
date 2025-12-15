package com.birdapp.birdapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BIRD")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bird {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bird_id")
    private Long birdId;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "scientificname", length = 50, nullable = false)
    private String scientificname;

    @Column(name = "description", length = 2000, nullable = false)
    private String description;

    @Column(name = "image", length = 500, nullable = false)
    private String image;
}
