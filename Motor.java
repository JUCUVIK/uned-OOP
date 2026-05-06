/**
 * Clase abstracta que representa un motor de vehículo.
 * Almacena las características técnicas comunes a todos los tipos de motor.
 * 
 * Subclases: MotorElectrico, MotorGasolina, MotorHibrido
 * 
 * @author Estudiante UNED
 * @version 1.0
 */
public abstract class Motor
{
    private double cilindrada;    // en cc
    private double potencia;      // en CV
    private int numCilindros;

    /**
     * Constructor de Motor.
     * @param cilindrada Cilindrada en centímetros cúbicos.
     * @param potencia Potencia en caballos de vapor.
     * @param numCilindros Número de cilindros del motor.
     */
    public Motor(double cilindrada, double potencia, int numCilindros)
    {
        this.cilindrada = cilindrada;
        this.potencia = potencia;
        this.numCilindros = numCilindros;
    }

    // ---- Getters ----
    public double getCilindrada() { return cilindrada; }
    public double getPotencia() { return potencia; }
    public int getNumCilindros() { return numCilindros; }

    // ---- Setters ----
    public void setCilindrada(double cilindrada) { this.cilindrada = cilindrada; }
    public void setPotencia(double potencia) { this.potencia = potencia; }
    public void setNumCilindros(int numCilindros) { this.numCilindros = numCilindros; }

    /**
     * Método abstracto que devuelve el tipo de motor como cadena.
     * @return Tipo de motor.
     */
    public abstract String getTipo();

    /**
     * Representación textual del motor.
     * @return Cadena con los datos del motor.
     */
    public String toString()
    {
        return getTipo() + " [Cilindrada=" + cilindrada + "cc, Potencia=" 
               + potencia + "CV, Cilindros=" + numCilindros + "]";
    }
}
