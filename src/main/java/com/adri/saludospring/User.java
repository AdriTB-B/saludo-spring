package com.adri.saludospring;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private long id;
    private String nombre;
}
