/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesador;

/**
 *
 * @author INTEL-COREi7
 */
public class ProcesadorTest {

    MemoriaTest memoria = new MemoriaTest();
    InstruccionTest instruccion = new InstruccionTest();

    UnidadControl ucontrol = new UnidadControl();

    BusControl busc = new BusControl();
    BusDatos busd = new BusDatos();
    BusDirecciones busdi = new BusDirecciones();

    Reloj reloj = new Reloj();

    UnidadTratamiento utratamiento = new UnidadTratamiento();

    public void opcion(String cop) {
        switch (cop) {
            case "1010":

            case "102A":

            case "345F":

            case "202B":

            case "202C":

        }
    }
    
    public void fetchCycle(){
        ucontrol.PC = gestion.;
        utratamiento.AR = ucontrol.PC;
        
    }
    
    public void executionCycle(){
    
    }
    
    public void load(){
        
    }
    
    public void call(){
    
    }
    
    public void push(){
    
    }
    
    public void pop(){
    
    }
    
    public void add(){
    
    }
    
    public void jump(){
    
    }
}
