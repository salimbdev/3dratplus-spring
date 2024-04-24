package fr.eql.ai115.three.d.rat.plus.spring.service;

import fr.eql.ai115.three.d.rat.plus.spring.entity.UserEntity;
import fr.eql.ai115.three.d.rat.plus.spring.entity.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserEntityToUserDtoService {

    public UserEntityToUserDtoService() {
    }

    public UserDto convertUserEntityToUserDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setFirstName(userEntity.getFirstName());
        userDto.setLastName(userEntity.getLastName());
        userDto.setAddress(userEntity.getAddress());
        userDto.setCity(userEntity.getCity());
        userDto.setPostalCode(userEntity.getPostalCode());
        userDto.setPhoneNumber(userEntity.getPhoneNumber());
        userDto.setUsername(userEntity.getUsername());

        return userDto;
    }
}
