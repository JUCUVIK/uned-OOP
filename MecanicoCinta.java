/**
 * Mecánico de cinta: repara las cintas de las cadenas de montaje.
 * Dos perfiles: eficiente (>20 reparaciones, 1s) y estándar (2-5s).
 * 
 * @author Sergio Cuadrado Hernández

 */
public class MecanicoCinta extends Trabajador
{
    private int reparacionesRealizadas;

    public MecanicoCinta(String nombre, String apellidos, String dni,
                          String direccion, String numSeguridadSocial,
                          double salario, String fechaIngreso)
    {
        super(nombre, apellidos, dni, direccion, numSeguridadSocial,
              "Mecánico de Cinta", salario, fechaIngreso);
        this.reparacionesRealizadas = 0;
    }

    public boolean isEficiente()
    {
        return reparacionesRealizadas > 20;
    }

    public int getTiempoReparacion()
    {
        if (isEficiente()) {
            return 1;
        } else {
            return 2 + (int)(Math.random() * 4); // entre 2 y 5
        }
    }

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
