package br.com.unifap.mentorr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class Nationality {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nationality;

}
