/**
 * Rueda de tipo todoterreno.
 * 
 * @author Estudiante UNED
 * @version 1.0
 */
public class RuedaTodoterreno extends Rueda
{
    public RuedaTodoterreno(int anchoMm, double diametroLlantaPulgadas,
                            int indiceCargaKg, int codigoVelocidadKmh)
    {
        super(anchoMm, diametroLlantaPulgadas, indiceCargaKg, codigoVelocidadKmh);
    }

    public String getTipo()
    {
        return "Todoterreno";
    }
}
