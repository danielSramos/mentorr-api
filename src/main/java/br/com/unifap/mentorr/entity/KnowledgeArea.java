package br.com.unifap.mentorr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "knowledge_area")
public class KnowledgeArea {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "knowledgeArea")
    private List<Skill> skills;

    @OneToMany(mappedBy = "knowledgeArea", cascade = ALL, orphanRemoval = true)
    private List<UserKnowledgeArea> users;
}
