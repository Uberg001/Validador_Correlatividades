package domain;

import java.util.List;

public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materias;
    
    public Inscripcion(Alumno alumno, List<Materia> materias) {
        this.alumno = alumno;
        this.materias = materias;
    }

    public boolean Aprobada(){
        for (Materia materia : materias) {
            if (materia.tieneCorrelativas()) {
                for (Materia correlativa : materia.getCorrelativas()) {
                    if (!alumno.aprobada(correlativa)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
}
