using System;
public abstract class Habitacion
{
    protected string nombre;

    protected double metrosCuadrados;
    
    public double getMetrosCuadrados(){
        return metrosCuadrados;
    }
    public void setMetrosCuadrados(double MetrosCuadrados){
        this.metrosCuadrados = metrosCuadrados;
    }
    public string getNombre(){
        return nombre;
    }

    public abstract void DetallesHabitacion();
    public abstract void ProbarHabitacion();    
}