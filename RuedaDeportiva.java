/**
 * Rueda de tipo deportivo.
 * 
 * @author Estudiante UNED
 * @version 1.0
 */
public class RuedaDeportiva extends Rueda
{
    public RuedaDeportiva(int anchoMm, double diametroLlantaPulgadas,
                          int indiceCargaKg, int codigoVelocidadKmh)
    {
        super(anchoMm, diametroLlantaPulgadas, indiceCargaKg, codigoVelocidadKmh);
    }

    public String getTipo()
    {
        return "Deportiva";
    }
}
