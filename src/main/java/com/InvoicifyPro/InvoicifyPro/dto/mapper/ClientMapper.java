package com.InvoicifyPro.InvoicifyPro.dto.mapper;

import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.ClientDTO;
import com.InvoicifyPro.InvoicifyPro.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ClientMapper {


    public ClientDTO ClientToDto(Client client);

    public Client clientDtoToClient(ClientDTO dto);



}
