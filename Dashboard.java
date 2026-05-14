/**
 * Dashboard (cuadro de mandos) de la fábrica.
 * Muestra el balance de componentes en el almacén y el estado
 * de los vehículos en las cadenas de montaje.
 * 
 * Diseño desacoplado: usa IVisualizador para permitir cambiar
 * el subsistema de visualización sin modificar esta clase.
 * 
 * @author Sergio Cuadrado Hernández

 */
public class Dashboard
{
    private IVisualizador visualizador;
    private CadenaMontaje[] cadenas;
    private IAlmacenDatos almacen;

    public Dashboard(IVisualizador visualizador, CadenaMontaje[] cadenas, 
                     IAlmacenDatos almacen)
    {
        this.visualizador = visualizador;
        this.cadenas = cadenas;
        this.almacen = almacen;
    }

    public void actualizar()
    {
        visualizador.mostrarDashboard(cadenas, almacen);
    }

    public void mostrarCadenas()
    {
        visualizador.mostrarEstadoCadenas(cadenas);
    }

    public void mostrarAlmacen()
    {
        visualizador.mostrarEstadoAlmacen(almacen);
    }

    public void notificar(String mensaje)
    {
        visualizador.mostrarMensaje(mensaje);
    }

    public void notificarError(String error)
    {
        visualizador.mostrarError(error);
    }

    public void setVisualizador(IVisualizador nuevoVisualizador)
    {
        this.visualizador = nuevoVisualizador;
    }

    public IVisualizador getVisualizador()
    {
        return visualizador;
    }
}
