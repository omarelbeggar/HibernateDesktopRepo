package service;

import java.util.List;

import dto.ClientDTO;

public interface ClientServiceInterface {
 List<ClientDTO> retreive();
 void create(ClientDTO dto);
 void update(ClientDTO dto, int id);
 boolean delete(int id);
 ClientDTO getClientDTO(int id);
}
