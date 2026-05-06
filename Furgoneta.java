/**
 * Vehículo de tipo furgoneta.
 * 
 * @author Estudiante UNED
 * @version 1.0
 */
public class Furgoneta extends Vehiculo
{
    /**
     * Constructor de Furgoneta.
     * @param color Color del vehículo.
     * @param numPlazas Número de plazas.
     * @param tara Tara en kg.
     * @param pesoMaxAutorizado PMA en kg.
     */
    public Furgoneta(String color, int numPlazas, double tara, double pesoMaxAutorizado)
    {
        super(color, numPlazas, tara, pesoMaxAutorizado);
    }

    public String getTipo()
    {
        return "Furgoneta";
    }
}
