/**
 * Clase abstracta que representa la tapicería de un vehículo.
 * Almacena las características comunes: color y metros cuadrados de tela.
 * 
 * Subclases: TapiceriaTela, TapiceriaCuero, TapiceriaAlcantara
 * 
 * @author Sergio Cuadrado Hernández

 */
public abstract class Tapiceria
{
    private String color;
    private double metrosCuadrados;

    public Tapiceria(String color, double metrosCuadrados)
    {
        this.color = color;
        this.metrosCuadrados = metrosCuadrados;
    }

    // ---- Getters ----
    public String getColor() { return color; }
    public double getMetrosCuadrados() { return metrosCuadrados; }

    // ---- Setters ----
    public void setColor(String color) { this.color = color; }
    public void setMetrosCuadrados(double m2) { this.metrosCuadrados = m2; }

    public abstract String getTipo();

    public String toString()
    {
        return getTipo() + " [Color=" + color + ", M2=" + metrosCuadrados + "]";
    }
}
