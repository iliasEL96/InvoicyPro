package com.InvoicifyPro.InvoicifyPro.dto.mapper;

import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.UserDTO;
import com.InvoicifyPro.InvoicifyPro.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    public UserDTO userToUserDTO(User user);

    public User userDTOToUser(UserDTO dto);


}
