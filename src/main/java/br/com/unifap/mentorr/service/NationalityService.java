package br.com.unifap.mentorr.service;

import br.com.unifap.mentorr.entity.Nationality;
import br.com.unifap.mentorr.repository.NationalityRepository;
import org.springframework.stereotype.Service;

@Service
public class NationalityService {

    private final NationalityRepository nationalityRepository;

    public NationalityService(NationalityRepository nationalityRepository) {
        this.nationalityRepository = nationalityRepository;
    }

    public Nationality getNationality(Long id) {
        Nationality nationality = nationalityRepository.findById(id).orElse(null);

        return nationality;
    }
}
