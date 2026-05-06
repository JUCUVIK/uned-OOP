/**
 * Vehículo biplaza deportivo. Tiene 2 plazas por defecto.
 * 
 * @author Estudiante UNED
 * @version 1.0
 */
public class BiplazaDeportivo extends Vehiculo
{
    /**
     * Constructor de BiplazaDeportivo.
     * @param color Color del vehículo.
     * @param tara Tara en kg.
     * @param pesoMaxAutorizado PMA en kg.
     */
    public BiplazaDeportivo(String color, double tara, double pesoMaxAutorizado)
    {
        super(color, 2, tara, pesoMaxAutorizado);
    }

    public String getTipo()
    {
        return "Biplaza Deportivo";
    }
}
