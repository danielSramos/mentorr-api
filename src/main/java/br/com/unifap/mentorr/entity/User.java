package br.com.unifap.mentorr.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "\"user\"")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    private String email;
    private String name;
    private String password;

    private String description;
    private boolean verified;

    @Basic(fetch = LAZY)
    @Lob
    @Column(name = "profile_image")
    private byte[] profileImage;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne(cascade = ALL)
    private Nationality nationality;

    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<MentoringPlan> mentoringPlans;

    @OneToMany(mappedBy = "user", cascade = ALL, orphanRemoval = true)
    private List<UserCompany> companies;

    @OneToMany(mappedBy = "user", cascade = ALL, orphanRemoval = true)
    private List<UserKnowledgeArea> userKnowledgeAreas;

    @OneToMany(mappedBy = "user", cascade = ALL, orphanRemoval = true)
    private List<UserPosition> positions;

    @OneToMany(mappedBy = "user", cascade = ALL, orphanRemoval = true)
    private List<UserSkill> skills;
}
