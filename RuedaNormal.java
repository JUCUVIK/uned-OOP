/**
 * Rueda de tipo normal.
 * 
 * @author Sergio Cuadrado Hernández

 */
public class RuedaNormal extends Rueda
{
    public RuedaNormal(int anchoMm, double diametroLlantaPulgadas,
                       int indiceCargaKg, int codigoVelocidadKmh)
    {
        super(anchoMm, diametroLlantaPulgadas, indiceCargaKg, codigoVelocidadKmh);
    }

    public String getTipo()
    {
        return "Normal";
    }
}
