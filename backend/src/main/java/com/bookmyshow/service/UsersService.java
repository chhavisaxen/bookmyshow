package com.bookmyshow.service;

import com.bookmyshow.dto.request.CreateUserDto;
import com.bookmyshow.dto.request.UpdateUsersDto;
import com.bookmyshow.entity.Users;
import com.bookmyshow.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service


public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public List<Users> createUsers(List<CreateUserDto> createUserDtos) {
        List<Users> usersResult = new ArrayList<>();
        for (CreateUserDto createUserDto : createUserDtos) {

            Users user = buildUserObject(createUserDto);

            usersResult.add(user);
        }
        return  usersRepository.saveAll(usersResult);
    }

    public Users createUser(CreateUserDto createUserDto) {
        Users user = buildUserObject(createUserDto);
        return usersRepository.save(user);
    }

    public Users buildUserObject(CreateUserDto createUserDto) {
        Users user = new Users();
        user.setFirstName(createUserDto.getFirstName());
        user.setLastName(createUserDto.getLastName());
        user.setEmail(createUserDto.getEmail());
        user.setAge(createUserDto.getAge());
        user.setGender(createUserDto.getGender());
        user.setPassword(BCrypt.hashpw(createUserDto.getPassword(), BCrypt.gensalt(10)));
        user.setPhone(createUserDto.getPhone());
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return user;
    }

    public Users updateUsers(Long id, UpdateUsersDto updateUsersDto) {
        Users user = usersRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        if (updateUsersDto.getFirstName() != null) {
            user.setFirstName(updateUsersDto.getFirstName());
        }
        if (updateUsersDto.getLastName() != null) {
            user.setLastName(updateUsersDto.getLastName());
        }
        if (updateUsersDto.getEmail() != null) {
            user.setEmail(updateUsersDto.getEmail());
        }
        if (updateUsersDto.getPhone() != null) {
            user.setPhone(updateUsersDto.getPhone());
        }
        return usersRepository.save(user);
    }

}
