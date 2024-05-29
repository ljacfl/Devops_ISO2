package com.microservice.client.controller;

import com.microservice.client.model.dto.ClientDto;
import com.microservice.client.model.entity.Client;
import com.microservice.client.model.payload.MensajeResponse;
import com.microservice.client.service.Impl.ClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ClientController {

    @Autowired
    private ClientImpl clientService;

    @GetMapping("clients")
    public ResponseEntity<?> showAll() {
        List<Client> getList = clientService.findAll();
        if (getList == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("No hay registros")
                            .object(null)
                            .build()
                    , HttpStatus.OK);
        }

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("")
                        .object(getList)
                        .build()
                , HttpStatus.OK);
    }

    @GetMapping("client/{id}")
    public ResponseEntity<?> showById(@PathVariable Integer id) {
        Client client = clientService.findById(id);

        if (client == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("El registro que intenta buscar, no existe!")
                            .object(null)
                            .build()
                    , HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("")
                        .object(ClientDto.builder()
                                .id_client(client.getId_client())
                                .name(client.getName())
                                .lastname(client.getLastname())
                                .email(client.getEmail())
                                .phone(client.getPhone())
                                .address(client.getAddress())
                                .TRMid(client.getTRMid())
                                .build())
                        .build()
                , HttpStatus.OK);
    }

    @PostMapping("client")
    public ResponseEntity<?> create(@RequestBody ClientDto clientDto) {
        Client clientSave = null;
        try {
            clientSave = clientService.save(clientDto);
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Guardado correctamente")
                    .object(ClientDto.builder()
                            .id_client(clientSave.getId_client())
                            .name(clientSave.getName())
                            .lastname(clientSave.getLastname())
                            .email(clientSave.getEmail())
                            .phone(clientSave.getPhone())
                            .address(clientSave.getAddress())
                            .TRMid(clientSave.getTRMid())
                            .build())
                    .build()
                    , HttpStatus.CREATED);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @PutMapping("client/{id}")
    public ResponseEntity<?> update(@RequestBody ClientDto clientDto, @PathVariable Integer id) {
        Client clientUpdate = null;
        try {
            if (clientService.existsById(id)) {
                clientDto.setId_client(id);
                clientUpdate = clientService.save(clientDto);
                return new ResponseEntity<>(MensajeResponse.builder()
                        .mensaje("Actualizado correctamente")
                        .object(ClientDto.builder()
                                .id_client(clientUpdate.getId_client())
                                .name(clientUpdate.getName())
                                .lastname(clientUpdate.getLastname())
                                .email(clientUpdate.getEmail())
                                .phone(clientUpdate.getPhone())
                                .address(clientUpdate.getAddress())
                                .TRMid(clientUpdate.getTRMid())
                                .build())
                        .build()
                        , HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(
                        MensajeResponse.builder()
                                .mensaje("El registro que intenta actualizar no se encuentra en la base de datos.")
                                .object(null)
                                .build()
                        , HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @DeleteMapping("client/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            Client clientDelete = clientService.findById(id);
            clientService.delete(clientDelete);
            return new ResponseEntity<>(clientDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }
}