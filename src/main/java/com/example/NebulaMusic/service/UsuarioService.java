package com.example.NebulaMusic.service;

import com.example.NebulaMusic.model.Usuario;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Service
public class UsuarioService {

    private final Map<String, Usuario> usuarios = new ConcurrentHashMap<>();

    public void registrar(Usuario usuario) {
        //Aqui van todas las reglas de negocio para registrar usuario
        usuarios.put(usuario.getCorreo(), usuario);
    }

    public boolean existeCorreo(String correo){
        return usuarios.containsKey(correo);
    }

    public boolean autenticar(String correo, String password){
        Usuario usuario = usuarios.get(correo);
        return usuario != null && usuario.getPassword().equals(password);
    }
}
