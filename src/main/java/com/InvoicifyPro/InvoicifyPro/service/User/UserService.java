package com.InvoicifyPro.InvoicifyPro.service.User;

import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.UserDTO;

import java.util.List;

public interface UserService {

    public List<UserDTO> findAll();

    public UserDTO findById(Long id);

    public UserDTO save(UserDTO UserDTO);

    public void deleteById(Long id);
}
