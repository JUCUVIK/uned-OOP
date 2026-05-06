/**
 * Vehículo de tipo turismo. Típicamente tiene 5 plazas.
 * 
 * @author Estudiante UNED
 * @version 1.0
 */
public class Turismo extends Vehiculo
{
    /**
     * Constructor de Turismo.
     * @param color Color del vehículo.
     * @param numPlazas Número de plazas (normalmente 5).
     * @param tara Tara en kg.
     * @param pesoMaxAutorizado PMA en kg.
     */
    public Turismo(String color, int numPlazas, double tara, double pesoMaxAutorizado)
    {
        super(color, numPlazas, tara, pesoMaxAutorizado);
    }

    public String getTipo()
    {
        return "Turismo";
    }
}
