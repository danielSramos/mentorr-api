package br.com.unifap.mentorr.mapper;

import br.com.unifap.mentorr.dto.MentorListDto;
import br.com.unifap.mentorr.dto.MentorProfileDto;
import br.com.unifap.mentorr.dto.UserDto;
import br.com.unifap.mentorr.entity.Nationality;
import br.com.unifap.mentorr.entity.Role;
import br.com.unifap.mentorr.entity.Skill;
import br.com.unifap.mentorr.entity.User;
import br.com.unifap.mentorr.entity.UserSkill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "role", target = "role")
    UserDto userToUserDto(User user);
    List<UserDto> userListToUserDtoList(List<User> userList);

    @Mapping(target = "skills", source = "skills", qualifiedByName = "mapSkills")
    MentorListDto userToMentorListDto(User user);

    @Mapping(target = "skills", source = "skills", qualifiedByName = "mapSkills")
    @Mapping(target = "nationality", source = "nationality", qualifiedByName = "mapNationality")
    MentorProfileDto userToMentorProfileDto(User user);

    User userDtoToUser(UserDto userDto);

    @Named("mapSkills")
    default List<String> mapSkills(List<UserSkill> userSkills) {
        return userSkills.stream()
                .map(userSkill -> userSkill.getSkill().getName())
                .collect(Collectors.toList());
    }

    @Named("mapNationality")
    default String mapNationality(Nationality nationality) {
        return nationality != null ? nationality.getNationality() : null;
    }

    default String mapRole(Role role) {
        return role != null ? role.getName() : null;
    }

    default Role mapRole(String roleName) {
        if (roleName == null) { return null; }

        Role role = new Role();
        role.setName(roleName);
        return role;
    }
}
