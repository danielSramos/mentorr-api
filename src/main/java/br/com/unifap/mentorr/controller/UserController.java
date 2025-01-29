package br.com.unifap.mentorr.controller;

import br.com.unifap.mentorr.dto.MentorListDto;
import br.com.unifap.mentorr.dto.MentorProfileDto;
import br.com.unifap.mentorr.dto.UserCreateRequest;
import br.com.unifap.mentorr.dto.UserDto;
import br.com.unifap.mentorr.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> index() {
        return ResponseEntity.ok(userService.listAllUsers());
    }

    @PostMapping
    public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserCreateRequest request) {
        return ResponseEntity.ok(userService.addUser(request));
    }

    @GetMapping("/mentor")
    public ResponseEntity<List<MentorListDto>> listMentor() throws IOException {
        return ResponseEntity.ok(userService.listAllMentors());
    }

    @GetMapping("/mentor/{id}")
    public ResponseEntity<MentorProfileDto> getMentor(@PathVariable Long id) throws IOException {
        return ResponseEntity.ok(userService.getMentorProfile(id));
    }
}
