import java.util.ArrayList;

/**
 * Interfaz que define el contrato para el almacén de datos del sistema.
 * Diseño desacoplado: permite cambiar la estructura de datos sin
 * modificar el sistema de gestión.
 * 
 * @author Sergio Cuadrado Hernández

 */
public interface IAlmacenDatos
{
    // ---- Gestión de Motores ----
    void addMotor(Motor motor);
    Motor getMotor(int index);
    ArrayList<Motor> getMotores();
    int getStockMotores();
    Motor retirarMotor(String tipo);

    // ---- Gestión de Tapicería ----
    void addTapiceria(Tapiceria tapiceria);
    Tapiceria getTapiceria(int index);
    ArrayList<Tapiceria> getTapicerias();
    int getStockTapicerias();
    Tapiceria retirarTapiceria(String tipo);

    // ---- Gestión de Ruedas ----
    void addRueda(Rueda rueda);
    Rueda getRueda(int index);
    ArrayList<Rueda> getRuedas();
    int getStockRuedas();
    Rueda retirarRueda(String tipo);

    // ---- Gestión de Vehículos completados ----
    void addVehiculo(Vehiculo vehiculo);
    Vehiculo getVehiculo(int index);
    ArrayList<Vehiculo> getVehiculos();
    int getTotalVehiculos();

    // ---- Gestión de Trabajadores ----
    void addTrabajador(Trabajador trabajador);
    Trabajador getTrabajadorPorDni(String dni);
    ArrayList<Trabajador> getTrabajadores();
    ArrayList<Operario> getOperarios();
    ArrayList<MecanicoCinta> getMecanicos();
    void removeTrabajador(String dni);

    // ---- Registros de montaje ----
    void addRegistroMontaje(RegistroMontaje registro);
    ArrayList<RegistroMontaje> getRegistrosPorFecha(String fecha);
    ArrayList<RegistroMontaje> getTodosRegistros();
}
