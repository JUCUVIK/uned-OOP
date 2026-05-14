/**
 * Vehículo de tipo turismo. Típicamente tiene 5 plazas.
 * 
 * @author Sergio Cuadrado Hernández

 */
public class Turismo extends Vehiculo
{
    public Turismo(String color, int numPlazas, double tara, double pesoMaxAutorizado)
    {
        super(color, numPlazas, tara, pesoMaxAutorizado);
    }

    public String getTipo()
    {
        return "Turismo";
    }
}
