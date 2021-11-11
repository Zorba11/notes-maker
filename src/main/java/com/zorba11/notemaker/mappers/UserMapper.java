package com.zorba11.notemaker.mappers;

import com.zorba11.notemaker.dtos.UserDTO;
import com.zorba11.notemaker.models.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public  UserDTO convertEntityToDTO(User user) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        UserDTO userDTO = new UserDTO();

        userDTO = modelMapper.map(user, UserDTO.class);

        return userDTO;
    }

    public User convertDtoToEntity(UserDTO userDTO) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        User user = new User();

        user = modelMapper.map(userDTO, User.class);

        return user;
    }


}
