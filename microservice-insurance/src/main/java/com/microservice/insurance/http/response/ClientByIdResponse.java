package com.microservice.insurance.http.response;

// Vamos a mapear la respuesta del microservicio cliente

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientByIdResponse {
    private Integer id;
}
