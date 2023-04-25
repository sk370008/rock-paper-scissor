package com.Assessment.rockpaperscissor.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@Getter
public class Records {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String playerMove;

    private String computerMove;

    private String winner;
}
