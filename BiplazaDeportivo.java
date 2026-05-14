/**
 * Vehículo biplaza deportivo. Tiene 2 plazas por defecto.
 * 
 * @author Sergio Cuadrado Hernández

 */
public class BiplazaDeportivo extends Vehiculo
{
    public BiplazaDeportivo(String color, double tara, double pesoMaxAutorizado)
    {
        super(color, 2, tara, pesoMaxAutorizado);
    }

    public String getTipo()
    {
        return "Biplaza Deportivo";
    }
}
