/**
 * Motor híbrido que combina gasolina y electricidad.
 * 
 * @author Sergio Cuadrado Hernández

 */
public class MotorHibrido extends Motor
{
    public MotorHibrido(double cilindrada, double potencia, int numCilindros)
    {
        super(cilindrada, potencia, numCilindros);
    }

    public String getTipo()
    {
        return "Híbrido";
    }
}
