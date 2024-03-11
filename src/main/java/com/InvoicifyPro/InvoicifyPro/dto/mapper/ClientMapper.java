package com.InvoicifyPro.InvoicifyPro.dto.mapper;

import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.ClientDTO;
import com.InvoicifyPro.InvoicifyPro.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {


    public ClientDTO clientToClientDto(Client client);

    public Client clientDtoToClient(ClientDTO dto);



}
