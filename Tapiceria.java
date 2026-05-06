/**
 * Clase abstracta que representa la tapicería de un vehículo.
 * Almacena las características comunes: color y metros cuadrados de tela.
 * 
 * Subclases: TapiceriaTela, TapiceriaCuero, TapiceriaAlcantara
 * 
 * @author Estudiante UNED
 * @version 1.0
 */
public abstract class Tapiceria
{
    private String color;
    private double metrosCuadrados;

    /**
     * Constructor de Tapiceria.
     * @param color Color de la tapicería.
     * @param metrosCuadrados Metros cuadrados de material.
     */
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

    /**
     * Método abstracto que devuelve el tipo de tapicería.
     * @return Tipo de tapicería.
     */
    public abstract String getTipo();

    public String toString()
    {
        return getTipo() + " [Color=" + color + ", M2=" + metrosCuadrados + "]";
    }
}
