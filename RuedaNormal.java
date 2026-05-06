/**
 * Rueda de tipo normal.
 * 
 * @author Estudiante UNED
 * @version 1.0
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
