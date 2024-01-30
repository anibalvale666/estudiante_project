package com.anibal.university.Controller;

import com.anibal.university.Business.EstudianteServiceI;
import com.anibal.university.Entity.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
    private final EstudianteServiceI estudianteService;

    @Autowired
    public EstudianteController(EstudianteServiceI estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return estudianteService.obtenerTodosLosEstudiantes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerEstudiante(@PathVariable Integer id) {
        try {
            Estudiante estudiante = estudianteService.obtenerEstudiantePorId(id);
            // Lógica para devolver el estudiante
            return ResponseEntity.ok(estudiante);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body( e.getMessage() );
        }
    }

    @PostMapping
    public Estudiante crearEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteService.crearEstudiante(estudiante);
    }

    @PutMapping("/{id}")
    public Estudiante actualizarEstudiante(@PathVariable Integer id, @RequestBody Estudiante estudianteActualizado) {
        return estudianteService.actualizarEstudiante(id, estudianteActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarEstudiante(@PathVariable Integer id) {
        estudianteService.eliminarEstudiante(id);
    }
}
