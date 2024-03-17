package com.InvoicifyPro.InvoicifyPro.service.client;

import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.ClientDTO;

import java.util.List;

public interface ClientService {

    public List<ClientDTO> findAll();

    public ClientDTO findById(Long id);

    public ClientDTO save (ClientDTO clientDTO);

    public void deleteById(Long id);


}
