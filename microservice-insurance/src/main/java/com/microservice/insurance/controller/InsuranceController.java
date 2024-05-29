package com.microservice.insurance.controller;

import com.microservice.insurance.model.dto.InsuranceDto;
import com.microservice.insurance.model.entity.Insurance;
import com.microservice.insurance.model.payload.MensajeResponse;
import com.microservice.insurance.service.Impl.InsuranceImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class InsuranceController {
    @Autowired
    private InsuranceImplService insuranceService;

    // Implementation of the method to show all insurances
    @GetMapping("insurances")
    public ResponseEntity<?> showAll() {
        List<Insurance> getList = insuranceService.findAll();
        if (getList == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .message("No hay registros")
                            .object(null)
                            .build()
                    , HttpStatus.OK);
        }

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .message("")
                        .object(getList)
                        .build()
                , HttpStatus.OK);
    }

    @GetMapping("insurance/{id}")
    public ResponseEntity<?> showById(@PathVariable Integer id) {
        Insurance insurance = insuranceService.findById(id);

        if (insurance == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .message("El registro que intenta buscar, no existe!")
                            .object(null)
                            .build()
                    , HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .message("")
                        .object(InsuranceDto.builder()
                                .id_insurance(insurance.getId_insurance())
                                .date_start(insurance.getDate_start())
                                .price(insurance.getPrice())
                                .status(insurance.isStatus())
                                .num_quotes((insurance.getNum_quotes()))
                                .payment_type(insurance.getPayment_type())
                                .id_policy(insurance.getId_policy())
                                .id_client(insurance.getId_client())
                                .build())
                        .build()
                , HttpStatus.OK);
    }

    // Implementation of the method to save an insurance
    @PostMapping("insurance")
    public ResponseEntity<?> create(@RequestBody InsuranceDto insuranceDto) {
        // Intentamos guardar la póliza
        Insurance insuranceSave = insuranceService.save(insuranceDto);
        if (insuranceSave == null) {
            // El cliente o la póliza no existen, o hubo un problema al guardar la póliza
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .message("El cliente o la póliza no existen, o hubo un problema al guardar la póliza")
                            .object(null)
                            .build()
                    , HttpStatus.NOT_FOUND);
        }

        // Si todo salió bien, devolvemos la póliza guardada
        return new ResponseEntity<>(MensajeResponse.builder()
                .message("Guardado correctamente")
                .object(InsuranceDto.builder()
                        .id_insurance(insuranceSave.getId_insurance())
                        .date_start(insuranceSave.getDate_start())
                        .price(insuranceSave.getPrice())
                        .status(insuranceSave.isStatus())
                        .num_quotes(insuranceSave.getNum_quotes())
                        .payment_type(insuranceSave.getPayment_type())
                        .id_policy(insuranceSave.getId_policy())
                        .id_client(insuranceSave.getId_client())
                        .build())
                .build()
                , HttpStatus.CREATED);
    }

    @DeleteMapping("insurance/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            Insurance insuranceDelete = insuranceService.findById(id);
            insuranceService.delete(insuranceDelete);
            return new ResponseEntity<>(insuranceDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .message(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @GetMapping("insurances/client/{id}")
    public ResponseEntity<?> showInsurancesByClientId(@PathVariable Integer id) {
        List<Insurance> insurances = insuranceService.findInsurancesByClientId(id);

        if (insurances == null || insurances.isEmpty()) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .message("No se encontraron seguros para el cliente con ID: " + id)
                            .object(null)
                            .build()
                    , HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .message("")
                        .object(insurances)
                        .build()
                , HttpStatus.OK);
    }

}
