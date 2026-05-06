/**
 * Dashboard (cuadro de mandos) de la fábrica.
 * Muestra el balance de componentes en el almacén y el estado
 * de los vehículos en las cadenas de montaje.
 * 
 * Diseño desacoplado: usa IVisualizador para permitir cambiar
 * el subsistema de visualización sin modificar esta clase.
 * 
 * @author Estudiante UNED
 * @version 1.0
 */
public class Dashboard
{
    private IVisualizador visualizador;
    private CadenaMontaje[] cadenas;
    private IAlmacenDatos almacen;

    /**
     * Constructor del Dashboard.
     * @param visualizador Subsistema de visualización (desacoplado).
     * @param cadenas Array de cadenas de montaje.
     * @param almacen Almacén de datos.
     */
    public Dashboard(IVisualizador visualizador, CadenaMontaje[] cadenas, 
                     IAlmacenDatos almacen)
    {
        this.visualizador = visualizador;
        this.cadenas = cadenas;
        this.almacen = almacen;
    }

    /**
     * Actualiza y muestra el dashboard completo.
     */
    public void actualizar()
    {
        visualizador.mostrarDashboard(cadenas, almacen);
    }

    /**
     * Muestra solo el estado de las cadenas de montaje.
     */
    public void mostrarCadenas()
    {
        visualizador.mostrarEstadoCadenas(cadenas);
    }

    /**
     * Muestra solo el estado del almacén.
     */
    public void mostrarAlmacen()
    {
        visualizador.mostrarEstadoAlmacen(almacen);
    }

    /**
     * Muestra un mensaje informativo en el dashboard.
     * @param mensaje Texto del mensaje.
     */
    public void notificar(String mensaje)
    {
        visualizador.mostrarMensaje(mensaje);
    }

    /**
     * Muestra un error en el dashboard.
     * @param error Texto del error.
     */
    public void notificarError(String error)
    {
        visualizador.mostrarError(error);
    }

    /**
     * Permite cambiar el subsistema de visualización en tiempo de ejecución.
     * @param nuevoVisualizador Nueva implementación de IVisualizador.
     */
    public void setVisualizador(IVisualizador nuevoVisualizador)
    {
        this.visualizador = nuevoVisualizador;
    }

    public IVisualizador getVisualizador()
    {
        return visualizador;
    }
}
