/**
 * Enumeración que representa los estados posibles de un vehículo
 * durante el proceso de montaje en la cadena de montaje.
 * 
 * @author Sergio Cuadrado Hernández

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

    EstadoVehiculo(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

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
