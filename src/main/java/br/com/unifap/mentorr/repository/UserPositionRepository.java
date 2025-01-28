package br.com.unifap.mentorr.repository;

import br.com.unifap.mentorr.entity.UserPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPositionRepository extends JpaRepository<UserPosition, Long> {
}
