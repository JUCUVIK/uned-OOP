/**
 * Clase abstracta que representa una rueda de vehículo.
 * Almacena las características: ancho, diámetro de llanta,
 * índice de carga y código de velocidad.
 * 
 * Subclases: RuedaNormal, RuedaDeportiva, RuedaTodoterreno
 * 
 * @author Estudiante UNED
 * @version 1.0
 */
public abstract class Rueda
{
    private int anchoMm;                  // ancho en milímetros
    private double diametroLlantaPulgadas; // diámetro de la llanta en pulgadas
    private int indiceCargaKg;            // índice de carga en kilogramos
    private int codigoVelocidadKmh;       // código de velocidad en km/h

    /**
     * Constructor de Rueda.
     * @param anchoMm Ancho en milímetros.
     * @param diametroLlantaPulgadas Diámetro de la llanta en pulgadas.
     * @param indiceCargaKg Índice de carga en kilogramos.
     * @param codigoVelocidadKmh Código de velocidad en km/h.
     */
    public Rueda(int anchoMm, double diametroLlantaPulgadas, 
                 int indiceCargaKg, int codigoVelocidadKmh)
    {
        this.anchoMm = anchoMm;
        this.diametroLlantaPulgadas = diametroLlantaPulgadas;
        this.indiceCargaKg = indiceCargaKg;
        this.codigoVelocidadKmh = codigoVelocidadKmh;
    }

    // ---- Getters ----
    public int getAnchoMm() { return anchoMm; }
    public double getDiametroLlantaPulgadas() { return diametroLlantaPulgadas; }
    public int getIndiceCargaKg() { return indiceCargaKg; }
    public int getCodigoVelocidadKmh() { return codigoVelocidadKmh; }

    // ---- Setters ----
    public void setAnchoMm(int anchoMm) { this.anchoMm = anchoMm; }
    public void setDiametroLlantaPulgadas(double d) { this.diametroLlantaPulgadas = d; }
    public void setIndiceCargaKg(int indiceCargaKg) { this.indiceCargaKg = indiceCargaKg; }
    public void setCodigoVelocidadKmh(int c) { this.codigoVelocidadKmh = c; }

    /**
     * Método abstracto que devuelve el tipo de rueda.
     * @return Tipo de rueda.
     */
    public abstract String getTipo();

    public String toString()
    {
        return getTipo() + " [Ancho=" + anchoMm + "mm, Llanta=" 
               + diametroLlantaPulgadas + "\", Carga=" + indiceCargaKg 
               + "kg, Velocidad=" + codigoVelocidadKmh + "km/h]";
    }
}
