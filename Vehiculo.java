/**
 * Clase abstracta que representa un vehículo producido en la fábrica.
 * Contiene las propiedades comunes: color, número de plazas, tara
 * y peso máximo autorizado, así como los componentes (motor, tapicería, ruedas).
 * 
 * Subclases: BiplazaDeportivo, Turismo, Furgoneta
 * 
 * @author Sergio Cuadrado Hernández

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

    public void setMotor(Motor motor) 
    { 
        this.motor = motor; 
    }

    public void setTapiceria(Tapiceria tapiceria) 
    { 
        this.tapiceria = tapiceria; 
    }

    public void setRuedas(Rueda rueda)
    {
        for (int i = 0; i < 4; i++) {
            this.ruedas[i] = rueda;
        }
    }

    public void setEstado(EstadoVehiculo estado)
    {
        this.estado = estado;
    }

    public void avanzarEstado()
    {
        this.estado = this.estado.siguiente();
    }

    public boolean estaCompletado()
    {
        return this.estado == EstadoVehiculo.COMPLETADO;
    }

    public abstract String getTipo();

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
