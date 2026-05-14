/**
 * Motor de gasolina convencional.
 * 
 * @author Sergio Cuadrado Hernández

 */
public class MotorGasolina extends Motor
{
    public MotorGasolina(double cilindrada, double potencia, int numCilindros)
    {
        super(cilindrada, potencia, numCilindros);
    }

    public String getTipo()
    {
        return "Gasolina";
    }
}
