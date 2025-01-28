package br.com.unifap.mentorr.repository;

import br.com.unifap.mentorr.entity.MentoringStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentoringStatusRepository extends JpaRepository<MentoringStatus, Long> {
}
