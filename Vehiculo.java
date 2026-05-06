/**
 * Clase abstracta que representa un vehículo producido en la fábrica.
 * Contiene las propiedades comunes: color, número de plazas, tara
 * y peso máximo autorizado, así como los componentes (motor, tapicería, ruedas).
 * 
 * Subclases: BiplazaDeportivo, Turismo, Furgoneta
 * 
 * @author Estudiante UNED
 * @version 1.0
 */
public abstract class Vehiculo
{
    private static int contadorId = 0;
    
    private int id;
    private String color;
    private int numPlazas;
    private double tara;               // peso del vehículo vacío en kg
    private double pesoMaxAutorizado;  // PMA en kg
    private Motor motor;
    private Tapiceria tapiceria;
    private Rueda[] ruedas;
    private EstadoVehiculo estado;

    /**
     * Constructor de Vehiculo.
     * @param color Color del vehículo.
     * @param numPlazas Número de plazas.
     * @param tara Tara del vehículo en kg.
     * @param pesoMaxAutorizado Peso máximo autorizado en kg.
     */
    public Vehiculo(String color, int numPlazas, double tara, double pesoMaxAutorizado)
    {
        this.id = ++contadorId;
        this.color = color;
        this.numPlazas = numPlazas;
        this.tara = tara;
        this.pesoMaxAutorizado = pesoMaxAutorizado;
        this.motor = null;
        this.tapiceria = null;
        this.ruedas = new Rueda[4];
        this.estado = EstadoVehiculo.PENDIENTE;
    }

    // ---- Getters ----
    public int getId() { return id; }
    public String getColor() { return color; }
    public int getNumPlazas() { return numPlazas; }
    public double getTara() { return tara; }
    public double getPesoMaxAutorizado() { return pesoMaxAutorizado; }
    public Motor getMotor() { return motor; }
    public Tapiceria getTapiceria() { return tapiceria; }
    public Rueda[] getRuedas() { return ruedas; }
    public EstadoVehiculo getEstado() { return estado; }

    // ---- Setters ----
    public void setColor(String color) { this.color = color; }
    public void setNumPlazas(int numPlazas) { this.numPlazas = numPlazas; }
    public void setTara(double tara) { this.tara = tara; }
    public void setPesoMaxAutorizado(double pma) { this.pesoMaxAutorizado = pma; }

    /**
     * Instala el motor en el vehículo.
     * @param motor Motor a instalar.
     */
    public void setMotor(Motor motor) 
    { 
        this.motor = motor; 
    }

    /**
     * Instala la tapicería en el vehículo.
     * @param tapiceria Tapicería a instalar.
     */
    public void setTapiceria(Tapiceria tapiceria) 
    { 
        this.tapiceria = tapiceria; 
    }

    /**
     * Instala un juego de 4 ruedas iguales en el vehículo.
     * @param rueda Rueda modelo a replicar en las 4 posiciones.
     */
    public void setRuedas(Rueda rueda)
    {
        for (int i = 0; i < 4; i++) {
            this.ruedas[i] = rueda;
        }
    }

    /**
     * Establece el estado del vehículo en la cadena de montaje.
     * @param estado Nuevo estado.
     */
    public void setEstado(EstadoVehiculo estado)
    {
        this.estado = estado;
    }

    /**
     * Avanza el estado del vehículo al siguiente en la cadena de montaje.
     */
    public void avanzarEstado()
    {
        this.estado = this.estado.siguiente();
    }

    /**
     * Comprueba si el vehículo está completamente ensamblado.
     * @return true si está completado.
     */
    public boolean estaCompletado()
    {
        return this.estado == EstadoVehiculo.COMPLETADO;
    }

    /**
     * Método abstracto que devuelve el tipo de vehículo.
     * @return Tipo de vehículo como cadena.
     */
    public abstract String getTipo();

    /**
     * Reinicia el contador de IDs (útil para pruebas).
     */
    public static void reiniciarContador()
    {
        contadorId = 0;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(getTipo()).append(" #").append(id);
        sb.append(" [Color=").append(color);
        sb.append(", Plazas=").append(numPlazas);
        sb.append(", Tara=").append(tara).append("kg");
        sb.append(", PMA=").append(pesoMaxAutorizado).append("kg");
        sb.append(", Estado=").append(estado.getDescripcion());
        if (motor != null) sb.append(", Motor=").append(motor.getTipo());
        if (tapiceria != null) sb.append(", Tapicería=").append(tapiceria.getTipo());
        if (ruedas[0] != null) sb.append(", Ruedas=").append(ruedas[0].getTipo());
        sb.append("]");
        return sb.toString();
    }
}
