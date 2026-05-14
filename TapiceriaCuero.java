/**
 * Tapicería de cuero.
 * 
 * @author Sergio Cuadrado Hernández

 */
public class TapiceriaCuero extends Tapiceria
{
    public TapiceriaCuero(String color, double metrosCuadrados)
    {
        super(color, metrosCuadrados);
    }

    public String getTipo()
    {
        return "Cuero";
    }
}
