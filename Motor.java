/**
 * Clase abstracta que representa un motor de vehículo.
 * Almacena las características técnicas comunes a todos los tipos de motor.
 * 
 * Subclases: MotorElectrico, MotorGasolina, MotorHibrido
 * 
 * @author Sergio Cuadrado Hernández

 */
public abstract class Motor
{
    private double cilindrada;    // en cc
    private double potencia;      // en CV
    private int numCilindros;

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

    public abstract String getTipo();

    public String toString()
    {
        return getTipo() + " [Cilindrada=" + cilindrada + "cc, Potencia=" 
               + potencia + "CV, Cilindros=" + numCilindros + "]";
    }
}
