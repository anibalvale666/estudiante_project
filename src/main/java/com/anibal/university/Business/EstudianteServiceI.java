package com.anibal.university.Business;

import com.anibal.university.Entity.Estudiante;

import java.util.List;

public interface EstudianteServiceI {

    public List<Estudiante> obtenerTodosLosEstudiantes();

    public Estudiante obtenerEstudiantePorId(Integer id);

    public Estudiante crearEstudiante(Estudiante estudiante) ;

    public Estudiante actualizarEstudiante(Integer id, Estudiante estudianteActualizado);

    public void eliminarEstudiante(Integer id);
}
