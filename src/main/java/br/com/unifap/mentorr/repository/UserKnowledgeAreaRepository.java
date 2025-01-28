package br.com.unifap.mentorr.repository;

import br.com.unifap.mentorr.entity.UserKnowledgeArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserKnowledgeAreaRepository extends JpaRepository<UserKnowledgeArea, Long> {
}
