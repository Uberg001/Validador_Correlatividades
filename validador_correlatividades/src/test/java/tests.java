import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class tests {
    Materia algoritmos=new Materia("Algoritmos", new ArrayList<Materia>());
    Materia syo=new Materia("SyO", new ArrayList<Materia>());
    Materia adc=new Materia("AdC", new ArrayList<Materia>());
    Materia discreta=new Materia("Discreta", new ArrayList<Materia>());
    Materia os=new Materia("OS", Arrays.asList(adc,discreta));
    Materia ads=new Materia("AdS", Arrays.asList(syo,algoritmos));
    
    Alumno alumno1=new Alumno("Miguel Borja", 91218,new ArrayList<Materia>());
    Alumno alumno2=new Alumno("Juan Carlos", 12345,Arrays.asList(adc,discreta));
    @Test
    public void materiaSinCorrelativasApruebaInscripcion(){
        //Hago una inscripcion. El alumno1 se anota solo a la materia os
        Inscripcion inscripcion=new Inscripcion(alumno1, Arrays.asList(adc)); 

        //Como alumno1 solo se anota a adc, la inscripcion deberia ser aprobada ya que no hay conflictos de correlativas
        Assert.assertTrue(inscripcion.Aprobada());
    }

    @Test
    public void inscripcionFallidaPorFaltaDeCorrelativas(){
        //Inscribo a alumno1 a ads
        Inscripcion inscripcion=new Inscripcion(alumno1, Arrays.asList(ads));
        
        //Como alumno1 no tiene las correlativas para anotarse a ads, la inscripcion no se produce
        Assert.assertFalse(inscripcion.Aprobada());
    }

    @Test
    public void materiaConCorrelativasSinCumplirDesapruebaInscripcion(){
        //Quiero anotar al alumno2 a os y a ads
        Inscripcion inscripcion=new Inscripcion(alumno2, Arrays.asList(ads,os));

        //Con os no tendria conflictos, pero si con ads. la inscripcion no se aprueba
        Assert.assertFalse(inscripcion.Aprobada());
    }

    @Test
    public void inscripcionExitosa(){
        //Quiero anotar al alumno2 a os y a ads
        Inscripcion inscripcion=new Inscripcion(alumno2, Arrays.asList(algoritmos,os));
        
        //os no tiene conflictos, algoritmos tampoco (por no tener correlativas). Deberia aprobar
        Assert.assertTrue(inscripcion.Aprobada());
    }
}
