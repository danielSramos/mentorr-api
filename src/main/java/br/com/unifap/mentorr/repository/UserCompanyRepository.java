package br.com.unifap.mentorr.repository;

import br.com.unifap.mentorr.entity.UserCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCompanyRepository extends JpaRepository<UserCompany, Long> {
}
