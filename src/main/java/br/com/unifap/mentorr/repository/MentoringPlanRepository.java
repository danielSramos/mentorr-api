package br.com.unifap.mentorr.repository;

import br.com.unifap.mentorr.entity.MentoringPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentoringPlanRepository extends JpaRepository<MentoringPlan, Long> {
}
