package br.com.unifap.mentorr.repository;

import br.com.unifap.mentorr.entity.KnowledgeArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnowledgeAreaRepository extends JpaRepository<KnowledgeArea, Long> {
}
