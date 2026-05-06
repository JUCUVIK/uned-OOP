/**
 * Administrador del sistema: vela por el correcto funcionamiento
 * del software de la fábrica. Cuando se produce un apagón,
 * necesita 2 segundos para restaurar el sistema de gestión
 * y 3 segundos para restaurar las cadenas de montaje.
 * 
 * @author Estudiante UNED
 * @version 1.0
 */
public class AdministradorSistema extends Trabajador
{
    private static final int TIEMPO_RESTAURAR_GESTION = 2;
    private static final int TIEMPO_RESTAURAR_CADENAS = 3;

    /**
     * Constructor de AdministradorSistema.
     */
    public AdministradorSistema(String nombre, String apellidos, String dni,
                                 String direccion, String numSeguridadSocial,
                                 double salario, String fechaIngreso)
    {
        super(nombre, apellidos, dni, direccion, numSeguridadSocial,
              "Administrador del Sistema", salario, fechaIngreso);
    }

    /**
     * Restaura el sistema de gestión tras una caída.
     * @return Tiempo empleado en la restauración (2 segundos).
     */
    public int restaurarSistemaGestion()
    {
        System.out.println("  [ADMIN] Restaurando sistema de gestión... (" 
                           + TIEMPO_RESTAURAR_GESTION + "s)");
        return TIEMPO_RESTAURAR_GESTION;
    }

    /**
     * Restaura las cadenas de montaje tras una caída.
     * @return Tiempo empleado en la restauración (3 segundos).
     */
    public int restaurarCadenasMontaje()
    {
        System.out.println("  [ADMIN] Restaurando cadenas de montaje... (" 
                           + TIEMPO_RESTAURAR_CADENAS + "s)");
        return TIEMPO_RESTAURAR_CADENAS;
    }

    /**
     * Restaura todo el sistema (gestión + cadenas).
     * @return Tiempo total de restauración (5 segundos).
     */
    public int restaurarTodo()
    {
        return restaurarSistemaGestion() + restaurarCadenasMontaje();
    }

    public String getPerfil()
    {
        return "Administrador del Sistema";
    }
}
