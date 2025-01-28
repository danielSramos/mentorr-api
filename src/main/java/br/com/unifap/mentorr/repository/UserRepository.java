package br.com.unifap.mentorr.repository;

import br.com.unifap.mentorr.entity.Role;
import br.com.unifap.mentorr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByRole(Role role);
    User findByUsername(String username);
}
