package br.com.unifap.mentorr.repository;

import br.com.unifap.mentorr.entity.Mentoring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentoringRepository extends JpaRepository<Mentoring, Long> {
}
