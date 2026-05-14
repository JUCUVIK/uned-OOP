/**
 * Gestor de planta: encargado de monitorizar la planta,
 * configurar componentes de las cadenas de montaje y
 * vigilar el dashboard para detectar errores.
 * 
 * @author Sergio Cuadrado Hernández

 */
public class GestorPlanta extends Trabajador
{
    public GestorPlanta(String nombre, String apellidos, String dni,
                        String direccion, String numSeguridadSocial,
                        double salario, String fechaIngreso)
    {
        super(nombre, apellidos, dni, direccion, numSeguridadSocial,
              "Gestor de Planta", salario, fechaIngreso);
    }

    public void configurarCadena(CadenaMontaje cadena, int tipoVehiculo,
                                  int tipoMotor, int tipoTapiceria,
                                  int tipoRueda, int unidades)
    {
        cadena.configurar(tipoVehiculo, tipoMotor, tipoTapiceria, tipoRueda, unidades);
    }

    public int llamarMecanico(MecanicoCinta mecanico, CadenaMontaje cadena)
    {
        return mecanico.repararCinta(cadena);
    }

    public String getPerfil()
    {
        return "Gestor de Planta";
    }
}
