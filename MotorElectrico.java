/**
 * Motor eléctrico. No tiene cilindros ni cilindrada convencional.
 * 
 * @author Sergio Cuadrado Hernández

 */
public class MotorElectrico extends Motor
{
    public MotorElectrico(double potencia)
    {
        super(0, potencia, 0);
    }

    public String getTipo()
    {
        return "Eléctrico";
    }
}
