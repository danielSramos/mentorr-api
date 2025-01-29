package br.com.unifap.mentorr.service;

import br.com.unifap.mentorr.dto.MentorListDto;
import br.com.unifap.mentorr.dto.MentorProfileDto;
import br.com.unifap.mentorr.dto.UserCreateRequest;
import br.com.unifap.mentorr.dto.UserDto;
import br.com.unifap.mentorr.entity.Nationality;
import br.com.unifap.mentorr.entity.Role;
import br.com.unifap.mentorr.entity.User;
import br.com.unifap.mentorr.exception.ResourceNotFoundException;
import br.com.unifap.mentorr.mapper.UserMapper;
import br.com.unifap.mentorr.repository.UserRepository;
import br.com.unifap.mentorr.util.ImageConverterService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ImageConverterService imageConverterService;
    private final RoleService roleService;
    private final NationalityService nationalityService;
    private final PasswordEncoder passwordEncoder;

    public UserService(
            UserRepository userRepository,
            ImageConverterService imageConverterService,
            RoleService roleService,
            NationalityService nationalityService,
            PasswordEncoder passwordEncoder
            ) {
        this.userRepository = userRepository;
        this.imageConverterService = imageConverterService;
        this.roleService = roleService;
        this.nationalityService = nationalityService;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto addUser(UserCreateRequest request) {
        Role role = roleService.getRole(request.getRoleId());
        Nationality nationality = nationalityService.getNationality(request.getNationalityId());
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        User user = User.builder()
                .email(request.getEmail())
                .username(request.getUsername())
                .password(encodedPassword)
                .name(request.getName())
                .nationality(nationality)
                .role(role)
                .verified(false)
                .profileImage(null)
                .description(null)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        userRepository.save(user);

        UserDto userDto = UserMapper.INSTANCE.userToUserDto(user);

        return userDto;
    }

    public List<UserDto> listAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userList = UserMapper.INSTANCE.userListToUserDtoList(users);

        return userList;
    }

    @Transactional
    public List<MentorListDto> listAllMentors() throws IOException {
        Role role = new Role(2L);
        List<User> users = userRepository.findByRole(role);

        List<MentorListDto> mentorList = users.stream()
                .map(user -> {
                    MentorListDto mentorListDto = UserMapper.INSTANCE.userToMentorListDto(user);
                    byte[] profileImageBytes = user.getProfileImage();

                    if (profileImageBytes != null) {
                        String base64Image = Base64.getEncoder().encodeToString(profileImageBytes);
                        mentorListDto.setProfileImageBase64(base64Image);
                    }

                    return mentorListDto;
                })
                .collect(Collectors.toList());

        return mentorList;
    }

    @Transactional
    public MentorProfileDto getMentorProfile(Long id) throws IOException {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Mentor not found"));
        MentorProfileDto mentorProfile = UserMapper.INSTANCE.userToMentorProfileDto(user);
        byte[] profileImageBytes = user.getProfileImage();

        if (profileImageBytes != null) {
            String base64Image = Base64.getEncoder().encodeToString(profileImageBytes);
            mentorProfile.setProfileImageBase64(base64Image);
        }

        return mentorProfile;
    }
}
