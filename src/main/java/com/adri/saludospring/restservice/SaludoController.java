package com.adri.saludospring.restservice;

import com.adri.saludospring.Saludo;
import com.adri.saludospring.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SaludoController {
    private static final String plantilla = "Hola, %s!";
    private final AtomicLong contador = new AtomicLong();

    @Autowired
    @Qualifier("listaUsuarios")
    List<User> listaUsuarios;

    @GetMapping("/saludo")
    public Saludo saludo(@RequestParam(value = "nombre", defaultValue = "mundo") String nombre){
        return new Saludo(contador.incrementAndGet(), String.format(plantilla, nombre));
    }

    @PostMapping("/postUser")
    public User addUser(@RequestBody User user){
        return user;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long id){
        return listaUsuarios.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PutMapping("/post")
    public User putUser(
            @RequestParam(value = "id", defaultValue = "0") Long id,
            @RequestParam(value = "nombre", defaultValue = "Sin nombre") String nombre
    ){
        User usuario = User.builder()
                .id(id)
                .nombre(nombre)
                .build();
        listaUsuarios.add(usuario);
        return usuario;
    }

}
