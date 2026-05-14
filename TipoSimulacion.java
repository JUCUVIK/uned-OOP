/**
 * Enumeración que representa los tipos de simulación del planificador.
 * 
 * @author Sergio Cuadrado Hernández

 */
public enum TipoSimulacion
{
    SIMPLE("Simple"),
    COMPLEJA("Compleja"),
    MUY_COMPLEJA("Muy Compleja");

    private String descripcion;

    TipoSimulacion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getDescripcion()
    {
        return descripcion;
    }
}
