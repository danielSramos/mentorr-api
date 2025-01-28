package br.com.unifap.mentorr.service;

import br.com.unifap.mentorr.entity.Role;
import br.com.unifap.mentorr.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getRole(Long id) {
        Role role = roleRepository.findById(id).orElse(null);

        return role;
    }
}
