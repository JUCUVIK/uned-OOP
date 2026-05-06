/**
 * Clase que representa un operario de la cadena de montaje.
 * Existen dos perfiles: eficiente (>10 montajes) y estándar.
 * El operario eficiente tarda 1 segundo en su tarea;
 * el estándar tarda el triple (3 segundos).
 * 
 * @author Estudiante UNED
 * @version 1.0
 */
public class Operario extends Trabajador
{
    private int montajesRealizados;

    /**
     * Constructor de Operario.
     */
    public Operario(String nombre, String apellidos, String dni,
                    String direccion, String numSeguridadSocial,
                    double salario, String fechaIngreso)
    {
        super(nombre, apellidos, dni, direccion, numSeguridadSocial,
              "Operario", salario, fechaIngreso);
        this.montajesRealizados = 0;
    }

    /**
     * Comprueba si el operario es eficiente (más de 10 montajes).
     * @return true si es eficiente, false si es estándar.
     */
    public boolean isEficiente()
    {
        return montajesRealizados > 10;
    }

    /**
     * Obtiene el tiempo que tarda el operario en realizar un montaje.
     * Eficiente: 1 segundo. Estándar: 3 segundos.
     * @return Tiempo de montaje en segundos.
     */
    public int getTiempoMontaje()
    {
        return isEficiente() ? 1 : 3;
    }

    /**
     * Incrementa el contador de montajes realizados.
     */
    public void incrementarMontajes()
    {
        montajesRealizados++;
    }

    public int getMontajesRealizados()
    {
        return montajesRealizados;
    }

    public void setMontajesRealizados(int montajes)
    {
        this.montajesRealizados = montajes;
    }

    public String getPerfil()
    {
        return isEficiente() ? "Operario Eficiente" : "Operario Estándar";
    }

    public String toString()
    {
        return super.toString() + " [Montajes=" + montajesRealizados 
               + ", Tiempo=" + getTiempoMontaje() + "s]";
    }
}
