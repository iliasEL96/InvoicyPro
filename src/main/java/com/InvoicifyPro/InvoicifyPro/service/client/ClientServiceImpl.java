package com.InvoicifyPro.InvoicifyPro.service.client;
import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.ClientDTO;
import com.InvoicifyPro.InvoicifyPro.dto.mapper.ClientMapper;
import com.InvoicifyPro.InvoicifyPro.entity.Client;
import com.InvoicifyPro.InvoicifyPro.exception.ResourceNotFoundException;
import com.InvoicifyPro.InvoicifyPro.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService{

    private final ClientMapper clientMapper;

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientMapper clientMapper, ClientRepository clientRepository) {
        this.clientMapper = clientMapper;
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientDTO> findAll() {
        return clientRepository.findAll().stream().map(clientMapper::clientToClientDto).collect(Collectors.toList());
    }

    @Override
    public ClientDTO findByAll(Long id) {
    Client client = clientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Client", id));

        return clientMapper.clientToClientDto(client);
    }

    @Override
    public ClientDTO save(ClientDTO clientDTO) {
        Client client = clientMapper.clientDtoToClient(clientDTO);
        clientRepository.save(client);
        return clientMapper.clientToClientDto(client);
    }

    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }
}
