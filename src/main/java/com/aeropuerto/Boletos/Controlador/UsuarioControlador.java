package com.aeropuerto.Boletos.Controlador;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.aeropuerto.Boletos.Modelos.Usuario;
import com.aeropuerto.Boletos.Repositorios.UsuarioRep;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioControlador {

    @Autowired
    private UsuarioRep repositorioUsuario;

    // Listar todos los usuarios
    @GetMapping("/listar")
    public List<Usuario> listarUsuarios() {
        return repositorioUsuario.findAll();
    }

    // Insertar un nuevo usuario
    @PostMapping("/crear")
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    // Actualizar un usuario
    @PutMapping("/actualizar/{id}")
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado) {
        return repositorioUsuario.findById(id)
                .map(usuario -> {
                    usuario.setUsername(usuarioActualizado.getUsername());
                    usuario.setPassword(usuarioActualizado.getPassword());
                    return repositorioUsuario.save(usuario);
                })
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el usuario con el ID proporcionado: " + id));
    }

    // Eliminar un usuario
    @DeleteMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        Usuario usuario = repositorioUsuario.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el usuario con el ID proporcionado: " + id));

        repositorioUsuario.delete(usuario);

        return "Usuario eliminado con éxito";
    }

    //validar
    @PostMapping("/validar")
    public ResponseEntity<String> validarUsuario(@RequestBody Usuario usuario) {
    Usuario usuarioExistente = repositorioUsuario.findByUsername(usuario.getUsername());
    
    if (usuarioExistente != null && usuarioExistente.getPassword().equals(usuario.getPassword())) {
        return new ResponseEntity<>("Credenciales correctas", HttpStatus.OK);
    } else {
        return new ResponseEntity<>("Credenciales incorrectas", HttpStatus.UNAUTHORIZED);
    }
}



}

    
