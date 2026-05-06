/**
 * Tapicería de cuero.
 * 
 * @author Estudiante UNED
 * @version 1.0
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
