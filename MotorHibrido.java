/**
 * Motor híbrido que combina gasolina y electricidad.
 * 
 * @author Estudiante UNED
 * @version 1.0
 */
public class MotorHibrido extends Motor
{
    /**
     * Constructor de MotorHibrido.
     * @param cilindrada Cilindrada en cc.
     * @param potencia Potencia en CV.
     * @param numCilindros Número de cilindros.
     */
    public MotorHibrido(double cilindrada, double potencia, int numCilindros)
    {
        super(cilindrada, potencia, numCilindros);
    }

    public String getTipo()
    {
        return "Híbrido";
    }
}
