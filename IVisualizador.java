/**
 * Interfaz que define el contrato para el subsistema de visualización.
 * Diseño desacoplado: permite cambiar el subsistema de visualización
 * sin modificar el dashboard.
 * 
 * @author Sergio Cuadrado Hernández

 */
public interface IVisualizador
{
    void mostrarEstadoCadenas(CadenaMontaje[] cadenas);

    void mostrarEstadoAlmacen(IAlmacenDatos almacen);

    void mostrarMensaje(String mensaje);

    void mostrarError(String error);

    void mostrarDashboard(CadenaMontaje[] cadenas, IAlmacenDatos almacen);

    void mostrarSeparador();
}
