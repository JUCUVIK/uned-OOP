/**
 * Gestor de planta: encargado de monitorizar la planta,
 * configurar componentes de las cadenas de montaje y
 * vigilar el dashboard para detectar errores.
 * 
 * @author Estudiante UNED
 * @version 1.0
 */
public class GestorPlanta extends Trabajador
{
    /**
     * Constructor de GestorPlanta.
     */
    public GestorPlanta(String nombre, String apellidos, String dni,
                        String direccion, String numSeguridadSocial,
                        double salario, String fechaIngreso)
    {
        super(nombre, apellidos, dni, direccion, numSeguridadSocial,
              "Gestor de Planta", salario, fechaIngreso);
    }

    /**
     * Configura una cadena de montaje con los componentes seleccionados.
     * @param cadena Cadena de montaje a configurar.
     * @param tipoVehiculo Tipo de vehículo a producir (1=Biplaza, 2=Turismo, 3=Furgoneta).
     * @param tipoMotor Tipo de motor (1=Eléctrico, 2=Gasolina, 3=Híbrido).
     * @param tipoTapiceria Tipo de tapicería (1=Tela, 2=Cuero, 3=Alcántara).
     * @param tipoRueda Tipo de rueda (1=Normal, 2=Deportiva, 3=Todoterreno).
     * @param unidades Número de unidades a producir.
     */
    public void configurarCadena(CadenaMontaje cadena, int tipoVehiculo,
                                  int tipoMotor, int tipoTapiceria,
                                  int tipoRueda, int unidades)
    {
        cadena.configurar(tipoVehiculo, tipoMotor, tipoTapiceria, tipoRueda, unidades);
    }

    /**
     * Llama a un mecánico para reparar una avería en la cadena.
     * @param mecanico Mecánico asignado.
     * @param cadena Cadena de montaje averiada.
     * @return Tiempo de reparación en segundos.
     */
    public int llamarMecanico(MecanicoCinta mecanico, CadenaMontaje cadena)
    {
        return mecanico.repararCinta(cadena);
    }

    public String getPerfil()
    {
        return "Gestor de Planta";
    }
}
