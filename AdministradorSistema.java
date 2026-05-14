/**
 * Administrador del sistema: vela por el correcto funcionamiento
 * del software de la fábrica. Cuando se produce un apagón,
 * necesita 2 segundos para restaurar el sistema de gestión
 * y 3 segundos para restaurar las cadenas de montaje.
 * 
 * @author Sergio Cuadrado Hernández

 */
public class AdministradorSistema extends Trabajador
{
    private static final int TIEMPO_RESTAURAR_GESTION = 2;
    private static final int TIEMPO_RESTAURAR_CADENAS = 3;

    public AdministradorSistema(String nombre, String apellidos, String dni,
                                 String direccion, String numSeguridadSocial,
                                 double salario, String fechaIngreso)
    {
        super(nombre, apellidos, dni, direccion, numSeguridadSocial,
              "Administrador del Sistema", salario, fechaIngreso);
    }

    public int restaurarSistemaGestion()
    {
        System.out.println("  [ADMIN] Restaurando sistema de gestión... (" 
                           + TIEMPO_RESTAURAR_GESTION + "s)");
        return TIEMPO_RESTAURAR_GESTION;
    }

    public int restaurarCadenasMontaje()
    {
        System.out.println("  [ADMIN] Restaurando cadenas de montaje... (" 
                           + TIEMPO_RESTAURAR_CADENAS + "s)");
        return TIEMPO_RESTAURAR_CADENAS;
    }

    public int restaurarTodo()
    {
        return restaurarSistemaGestion() + restaurarCadenasMontaje();
    }

    public String getPerfil()
    {
        return "Administrador del Sistema";
    }
}

