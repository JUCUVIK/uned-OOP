/**
 * Clase que representa un operario de la cadena de montaje.
 * Existen dos perfiles: eficiente (>10 montajes) y estándar.
 * El operario eficiente tarda 1 segundo en su tarea;
 * el estándar tarda el triple (3 segundos).
 * 
 * @author Sergio Cuadrado Hernández

 */
public class Operario extends Trabajador
{
    private int montajesRealizados;

    public Operario(String nombre, String apellidos, String dni,
                    String direccion, String numSeguridadSocial,
                    double salario, String fechaIngreso)
    {
        super(nombre, apellidos, dni, direccion, numSeguridadSocial,
              "Operario", salario, fechaIngreso);
        this.montajesRealizados = 0;
    }

    public boolean isEficiente()
    {
        return montajesRealizados > 10;
    }

    public int getTiempoMontaje()
    {
        return isEficiente() ? 1 : 3;
    }

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
