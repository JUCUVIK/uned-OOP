/**
 * Tapicería de tela.
 * 
 * @author Estudiante UNED
 * @version 1.0
 */
public class TapiceriaTela extends Tapiceria
{
    public TapiceriaTela(String color, double metrosCuadrados)
    {
        super(color, metrosCuadrados);
    }

    public String getTipo()
    {
        return "Tela";
    }
}
