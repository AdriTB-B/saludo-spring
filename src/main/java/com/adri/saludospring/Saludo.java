package com.adri.saludospring;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Saludo {
    private long id;
    private String mensaje;
}
