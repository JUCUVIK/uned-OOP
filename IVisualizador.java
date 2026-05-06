/**
 * Interfaz que define el contrato para el subsistema de visualización.
 * Diseño desacoplado: permite cambiar el subsistema de visualización
 * sin modificar el dashboard.
 * 
 * @author Estudiante UNED
 * @version 1.0
 */
public interface IVisualizador
{
    /**
     * Muestra el estado actual de las cadenas de montaje.
     * @param cadenas Array de cadenas de montaje.
     */
    void mostrarEstadoCadenas(CadenaMontaje[] cadenas);

    /**
     * Muestra el estado actual del almacén de componentes.
     * @param almacen Almacén de datos del sistema.
     */
    void mostrarEstadoAlmacen(IAlmacenDatos almacen);

    /**
     * Muestra un mensaje informativo.
     * @param mensaje Texto del mensaje.
     */
    void mostrarMensaje(String mensaje);

    /**
     * Muestra un mensaje de error.
     * @param error Texto del error.
     */
    void mostrarError(String error);

    /**
     * Muestra el dashboard completo con cadenas y almacén.
     * @param cadenas Array de cadenas de montaje.
     * @param almacen Almacén de datos.
     */
    void mostrarDashboard(CadenaMontaje[] cadenas, IAlmacenDatos almacen);

    /**
     * Muestra una línea separadora.
     */
    void mostrarSeparador();
}
