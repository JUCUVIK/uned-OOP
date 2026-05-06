/**
 * Motor eléctrico. No tiene cilindros ni cilindrada convencional.
 * 
 * @author Estudiante UNED
 * @version 1.0
 */
public class MotorElectrico extends Motor
{
    /**
     * Constructor de MotorElectrico.
     * @param potencia Potencia en CV.
     */
    public MotorElectrico(double potencia)
    {
        super(0, potencia, 0);
    }

    public String getTipo()
    {
        return "Eléctrico";
    }
}
