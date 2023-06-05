package com.aeropuerto.Boletos.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aeropuerto.Boletos.Modelos.persona;
import com.aeropuerto.Boletos.Repositorios.PersonaRep;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "*")

public class PersonaControlador {

	@Autowired
	private PersonaRep repositorio;

	// este metodo sirve para listar todos los empleados
	@GetMapping("/listarpersona")
	public List<persona> listartodaslaspersonas() {
		return repositorio.findAll();
	}

	// este metodo sirve para guardar la persona
	@PostMapping("/ingresarpersona")
	public persona ingresarPersona(@RequestBody persona persona) {
		return repositorio.save(persona);
	}


	//Metodo para actualizar persona
	/**
	 * @param id
	 * @param personaActualizada
	 * @return
	 */
	@PutMapping("/actualizarpersona/{id}")
	public persona actualizarPersona(@PathVariable int id, @RequestBody persona personaActualizada) {
		return repositorio.findById(id)
				.map(persona -> {
					persona.setNombre(personaActualizada.getNombre());
					persona.setGenero(personaActualizada.getGenero());
					persona.setFecha_nacimiento(personaActualizada.getFecha_nacimiento());
					persona.setTelefono(personaActualizada.getTelefono());
					persona.setDireccion(personaActualizada.getDireccion());
					persona.setNum_identificacion(personaActualizada.getNum_identificacion());
					persona.setNacionalidad(personaActualizada.getNacionalidad());
					return repositorio.save(persona);
				})
				.orElseThrow(() -> new IllegalArgumentException("No se encontró la persona con el ID proporcionado: " + id));

		
	
}
	//Metodo para eliminar persona
	@DeleteMapping("/eliminarpersona/{id}")
	public void eliminarPersona(@PathVariable int id) {
		repositorio.findById(id)
				.map(persona -> {
					repositorio.delete(persona);
					return ResponseEntity.ok().build();
				})
				.orElseThrow(
						() -> new IllegalArgumentException("No se encontró la persona con el ID proporcionado: " + id));
}


}
