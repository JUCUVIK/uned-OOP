/**
 * Rueda de tipo todoterreno.
 * 
 * @author Sergio Cuadrado Hernández

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
