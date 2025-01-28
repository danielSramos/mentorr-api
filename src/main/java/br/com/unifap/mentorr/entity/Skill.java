package br.com.unifap.mentorr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class Skill {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "knowledge_area_id")
    private KnowledgeArea knowledgeArea;

    @OneToMany(mappedBy = "skill")
    private List<UserSkill> userSkills;

}
