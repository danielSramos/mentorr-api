package br.com.unifap.mentorr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class Mentoring {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "mentor_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "mentoring", cascade = ALL)
    private List<MentoringClient> clients = new ArrayList<>();

    @OneToMany(mappedBy = "mentoringStatus")
    private List<MentoringStatus> mentoringStatus = new ArrayList<>();

}
