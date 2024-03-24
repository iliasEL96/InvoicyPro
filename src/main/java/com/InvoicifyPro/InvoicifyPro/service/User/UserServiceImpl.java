package com.InvoicifyPro.InvoicifyPro.service.User;


import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.UserDTO;
import com.InvoicifyPro.InvoicifyPro.dto.mapper.UserMapper;
import com.InvoicifyPro.InvoicifyPro.entity.User;
import com.InvoicifyPro.InvoicifyPro.exception.ResourceNotFoundException;
import com.InvoicifyPro.InvoicifyPro.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository ;

    private final UserMapper userMapper ;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(userMapper::userToUserDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(Long id) {
      User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", id));
        return userMapper.userToUserDTO(user);
    }

    @Override
    @Transactional
    public UserDTO save(UserDTO UserDTO) {
        User user = userMapper.userDTOToUser(UserDTO);
        userRepository.save(user);
        return userMapper.userToUserDTO(user);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if(!userRepository.existsById(id)){
            throw new ResourceNotFoundException("User",id );
        }
        userRepository.deleteById(id);

    }
}
