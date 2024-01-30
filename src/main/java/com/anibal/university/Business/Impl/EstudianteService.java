package com.anibal.university.Business.Impl;

import com.anibal.university.Business.EstudianteServiceI;
import com.anibal.university.Entity.Estudiante;
import com.anibal.university.Repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class EstudianteService implements EstudianteServiceI {
    private final EstudianteRepository estudianteRepository;

    @Autowired
    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Estudiante obtenerEstudiantePorId(Integer id) {
        return estudianteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }



    public Estudiante crearEstudiante(Estudiante estudiante) {
        validateNoNull(estudiante);
        return estudianteRepository.save(estudiante);
    }

    public Estudiante actualizarEstudiante(Integer id, Estudiante estudianteActualizado) {
        return estudianteRepository.findById(id)
            .map(estudiante -> {
                estudiante.setNombre(estudianteActualizado.getNombre());
                estudiante.setApellido(estudianteActualizado.getApellido());
                estudiante.setEmail(estudianteActualizado.getEmail());
                estudiante.setCreditos(estudianteActualizado.getCreditos());
                estudiante.setSemestre(estudianteActualizado.getSemestre());
                estudiante.setPromedio(estudianteActualizado.getPromedio());
                return estudianteRepository.save(estudiante);
            })
            .orElse(null);
    }

    public void eliminarEstudiante(Integer id) {
        estudianteRepository.deleteById(id);
    }


    // Funciones Auxiiares
    private void validateNoNull(Estudiante estudiante) {
        String nombre = estudiante.getNombre();
        String apellido = estudiante.getApellido();
        String email = estudiante.getEmail();


            if(Objects.isNull(nombre) || nombre.toString().trim().isEmpty()
                && Objects.isNull(apellido) || apellido.toString().trim().isEmpty()
                && Objects.isNull(email) || email.toString().trim().isEmpty()
                && Objects.isNull(estudiante.getCreditos())
                && Objects.isNull(estudiante.getPromedio())
                && Objects.isNull(estudiante.getSemestre())
            ) {
                throw new IllegalArgumentException("Los campos de estudiante no pueden estar vacios o nulos");
            }
    }

}
