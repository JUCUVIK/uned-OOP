/**
 * Implementación de consola del visualizador.
 * Implementa IVisualizador para mostrar información por la terminal.
 * Diseño desacoplado: se puede sustituir por una interfaz gráfica
 * sin modificar el dashboard.
 * 
 * @author Sergio Cuadrado Hernández

 */
public class VisualizadorConsola implements IVisualizador
{
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

    public void mostrarMensaje(String mensaje)
    {
        System.out.println("  [INFO] " + mensaje);
    }

    public void mostrarError(String error)
    {
        System.out.println("  [ERROR] " + error);
    }

    public void mostrarDashboard(CadenaMontaje[] cadenas, IAlmacenDatos almacen)
    {
        System.out.println();
        System.out.println("  ※╔══════════════════════════════════════════════════╗※");
        System.out.println("  ※║        DASHBOARD - FÁBRICA DE VEHÍCULOS          ║※");
        System.out.println("  ※╚══════════════════════════════════════════════════╝※");
        mostrarEstadoCadenas(cadenas);
        mostrarEstadoAlmacen(almacen);
    }

    public void mostrarSeparador()
    {
        System.out.println("  --------------------------------------------------");
    }
}
