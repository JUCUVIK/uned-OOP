/**
 * Registro de montaje que almacena cada acción realizada
 * durante el proceso de ensamblaje. Permite consultas por fecha
 * y componente.
 * 
 * @author Sergio Cuadrado Hernández

 */
public class RegistroMontaje
{
    private String fecha;
    private int segundo;
    private int numeroCadena;
    private String componente;
    private String descripcion;
    private int vehiculoId;

    public RegistroMontaje(String fecha, int segundo, int numeroCadena,
                            String componente, String descripcion, int vehiculoId)
    {
        this.fecha = fecha;
        this.segundo = segundo;
        this.numeroCadena = numeroCadena;
        this.componente = componente;
        this.descripcion = descripcion;
        this.vehiculoId = vehiculoId;
    }

    // ---- Getters ----
    public String getFecha() { return fecha; }
    public int getSegundo() { return segundo; }
    public int getNumeroCadena() { return numeroCadena; }
    public String getComponente() { return componente; }
    public String getDescripcion() { return descripcion; }
    public int getVehiculoId() { return vehiculoId; }

    public String toString()
    {
        return "[" + fecha + " T=" + segundo + "s] Cadena " + numeroCadena 
               + " - Vehículo #" + vehiculoId + ": " + componente 
               + " - " + descripcion;
    }
}
