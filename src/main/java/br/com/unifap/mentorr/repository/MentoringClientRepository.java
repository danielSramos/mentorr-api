package br.com.unifap.mentorr.repository;

import br.com.unifap.mentorr.entity.MentoringClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentoringClientRepository extends JpaRepository<MentoringClient, Long> {
}
