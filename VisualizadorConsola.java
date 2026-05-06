/**
 * Implementación de consola del visualizador.
 * Implementa IVisualizador para mostrar información por la terminal.
 * Diseño desacoplado: se puede sustituir por una interfaz gráfica
 * sin modificar el dashboard.
 * 
 * @author Estudiante UNED
 * @version 1.0
 */
public class VisualizadorConsola implements IVisualizador
{
    /**
     * Muestra el estado de todas las cadenas de montaje.
     * @param cadenas Array de cadenas de montaje.
     */
    public void mostrarEstadoCadenas(CadenaMontaje[] cadenas)
    {
        mostrarSeparador();
        System.out.println("  === ESTADO DE LAS CADENAS DE MONTAJE ===");
        mostrarSeparador();
        for (CadenaMontaje cadena : cadenas) {
            if (cadena != null) {
                System.out.println("  " + cadena.toString());
                if (cadena.getVehiculoActual() != null) {
                    System.out.println("    -> Vehículo en curso: " 
                                       + cadena.getVehiculoActual().toString());
                }
                // Mostrar operarios asignados
                Operario[] ops = cadena.getOperarios();
                for (int i = 0; i < ops.length; i++) {
                    if (ops[i] != null) {
                        String[] estaciones = {"Chasis", "Motor", "Tapicería", "Ruedas"};
                        System.out.println("    Estación " + estaciones[i] + ": " 
                                           + ops[i].getNombreCompleto() 
                                           + " (" + ops[i].getPerfil() + ")");
                    }
                }
            }
        }
        mostrarSeparador();
    }

    /**
     * Muestra el estado del almacén de componentes.
     * @param almacen Almacén de datos.
     */
    public void mostrarEstadoAlmacen(IAlmacenDatos almacen)
    {
        mostrarSeparador();
        System.out.println("  === ESTADO DEL ALMACÉN ===");
        mostrarSeparador();
        System.out.println("  Motores en stock: " + almacen.getStockMotores());
        System.out.println("  Tapicerías en stock: " + almacen.getStockTapicerias());
        System.out.println("  Ruedas en stock: " + almacen.getStockRuedas());
        System.out.println("  Vehículos completados: " + almacen.getTotalVehiculos());
        mostrarSeparador();
    }

    /**
     * Muestra un mensaje informativo.
     * @param mensaje Texto del mensaje.
     */
    public void mostrarMensaje(String mensaje)
    {
        System.out.println("  [INFO] " + mensaje);
    }

    /**
     * Muestra un mensaje de error.
     * @param error Texto del error.
     */
    public void mostrarError(String error)
    {
        System.out.println("  [ERROR] " + error);
    }

    /**
     * Muestra el dashboard completo: cadenas + almacén.
     * @param cadenas Array de cadenas de montaje.
     * @param almacen Almacén de datos.
     */
    public void mostrarDashboard(CadenaMontaje[] cadenas, IAlmacenDatos almacen)
    {
        System.out.println();
        System.out.println("  ╔══════════════════════════════════════════════════╗");
        System.out.println("  ║            DASHBOARD - FÁBRICA DE VEHÍCULOS     ║");
        System.out.println("  ╚══════════════════════════════════════════════════╝");
        mostrarEstadoCadenas(cadenas);
        mostrarEstadoAlmacen(almacen);
    }

    /**
     * Muestra una línea separadora.
     */
    public void mostrarSeparador()
    {
        System.out.println("  --------------------------------------------------");
    }
}
