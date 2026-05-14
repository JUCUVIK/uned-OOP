/**
 * Vehículo de tipo furgoneta.
 * 
 * @author Sergio Cuadrado Hernández

 */
public class Furgoneta extends Vehiculo
{
    public Furgoneta(String color, int numPlazas, double tara, double pesoMaxAutorizado)
    {
        super(color, numPlazas, tara, pesoMaxAutorizado);
    }

    public String getTipo()
    {
        return "Furgoneta";
    }
}
