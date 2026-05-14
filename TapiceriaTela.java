/**
 * Tapicería de tela.
 * 
 * @author Sergio Cuadrado Hernández

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
