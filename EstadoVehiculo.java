/**
 * Enumeración que representa los estados posibles de un vehículo
 * durante el proceso de montaje en la cadena de montaje.
 * 
 * @author Estudiante UNED
 * @version 1.0
 */
public enum EstadoVehiculo
{
    PENDIENTE("Pendiente de montaje"),
    CHASIS("Chasis montado"),
    MOTOR("Motor montado"),
    TAPICERIA("Tapicería montada"),
    RUEDAS("Ruedas montadas"),
    COMPLETADO("Vehículo completado");

    private String descripcion;

    /**
     * Constructor del enum EstadoVehiculo.
     * @param descripcion Descripción textual del estado.
     */
    EstadoVehiculo(String descripcion)
    {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la descripción del estado.
     * @return Descripción textual del estado.
     */
    public String getDescripcion()
    {
        return descripcion;
    }

    /**
     * Obtiene el siguiente estado en el proceso de montaje.
     * @return El siguiente estado, o COMPLETADO si ya está en el último.
     */
    public EstadoVehiculo siguiente()
    {
        switch (this) {
            case PENDIENTE: return CHASIS;
            case CHASIS: return MOTOR;
            case MOTOR: return TAPICERIA;
            case TAPICERIA: return RUEDAS;
            case RUEDAS: return COMPLETADO;
            default: return COMPLETADO;
        }
    }
}
