package com.bookmyshow.service;

import com.bookmyshow.dto.request.CreateMovieDto;
import com.bookmyshow.dto.request.CreateUsersDto;
import com.bookmyshow.dto.request.UpdateUsersDto;
import com.bookmyshow.entity.Users;
import com.bookmyshow.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service


public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users createUsers(CreateUsersDto createUsersDto) {
        Users user = new Users();
        user.setFirstName(createUsersDto.getFirstName());
        user.setLastName(createUsersDto.getLastName());
        user.setEmail(createUsersDto.getEmail());
        user.setAge(createUsersDto.getAge());
        user.setPassword(BCrypt.hashpw(createUsersDto.getPassword(), BCrypt.gensalt(10)));
        user.setPhone(createUsersDto.getPhone());

        return usersRepository.save(user);
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
