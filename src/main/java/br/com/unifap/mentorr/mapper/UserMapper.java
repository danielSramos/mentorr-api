package br.com.unifap.mentorr.mapper;

import br.com.unifap.mentorr.dto.MentorListDto;
import br.com.unifap.mentorr.dto.UserDto;
import br.com.unifap.mentorr.entity.Role;
import br.com.unifap.mentorr.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "role", target = "role")
    UserDto userToUserDto(User user);
    List<UserDto> userListToUserDtoList(List<User> userList);

    MentorListDto userToMentorListDto(User user);

    User userDtoToUser(UserDto userDto);

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
