/**
 * Mecánico de cinta: repara las cintas de las cadenas de montaje.
 * Dos perfiles: eficiente (>20 reparaciones, 1s) y estándar (2-5s).
 * 
 * @author Estudiante UNED
 * @version 1.0
 */
public class MecanicoCinta extends Trabajador
{
    private int reparacionesRealizadas;

    /**
     * Constructor de MecanicoCinta.
     */
    public MecanicoCinta(String nombre, String apellidos, String dni,
                          String direccion, String numSeguridadSocial,
                          double salario, String fechaIngreso)
    {
        super(nombre, apellidos, dni, direccion, numSeguridadSocial,
              "Mecánico de Cinta", salario, fechaIngreso);
        this.reparacionesRealizadas = 0;
    }

    /**
     * Comprueba si el mecánico es eficiente (más de 20 reparaciones).
     * @return true si es eficiente, false si es estándar.
     */
    public boolean isEficiente()
    {
        return reparacionesRealizadas > 20;
    }

    /**
     * Obtiene el tiempo de reparación.
     * Eficiente: 1 segundo. Estándar: entre 2 y 5 segundos (aleatorio).
     * @return Tiempo de reparación en segundos.
     */
    public int getTiempoReparacion()
    {
        if (isEficiente()) {
            return 1;
        } else {
            return 2 + (int)(Math.random() * 4); // entre 2 y 5
        }
    }

    /**
     * Repara la cinta de una cadena de montaje.
     * @param cadena Cadena a reparar.
     * @return Tiempo empleado en la reparación.
     */
    public int repararCinta(CadenaMontaje cadena)
    {
        int tiempo = getTiempoReparacion();
        reparacionesRealizadas++;
        cadena.setAveriada(false);
        System.out.println("  [MECÁNICO] " + getNombreCompleto() 
                           + " reparó cadena " + cadena.getNumero() 
                           + " en " + tiempo + "s (Reparaciones totales: " 
                           + reparacionesRealizadas + ")");
        return tiempo;
    }

    public int getReparacionesRealizadas()
    {
        return reparacionesRealizadas;
    }

    public void setReparacionesRealizadas(int reparaciones)
    {
        this.reparacionesRealizadas = reparaciones;
    }

    /**
     * Incrementa el contador de reparaciones.
     */
    public void incrementarReparaciones()
    {
        reparacionesRealizadas++;
    }

    public String getPerfil()
    {
        return isEficiente() ? "Mecánico Eficiente" : "Mecánico Estándar";
    }

    public String toString()
    {
        return super.toString() + " [Reparaciones=" + reparacionesRealizadas 
               + ", Tiempo=" + getTiempoReparacion() + "s]";
    }
}
