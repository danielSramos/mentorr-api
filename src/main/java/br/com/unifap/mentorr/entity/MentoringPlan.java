package br.com.unifap.mentorr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "mentoring_plan")
public class MentoringPlan {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Long cost;
    private LocalTime duration;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
