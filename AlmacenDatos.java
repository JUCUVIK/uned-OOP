import java.util.ArrayList;

/**
 * Implementación del almacén de datos en memoria.
 * Implementa la interfaz IAlmacenDatos para mantener el diseño desacoplado.
 * Se puede sustituir por otra implementación (ficheros, BBDD, etc.)
 * sin modificar el resto del sistema.
 * 
 * @author Estudiante UNED
 * @version 1.0
 */
public class AlmacenDatos implements IAlmacenDatos
{
    private ArrayList<Motor> motores;
    private ArrayList<Tapiceria> tapicerias;
    private ArrayList<Rueda> ruedas;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Trabajador> trabajadores;
    private ArrayList<RegistroMontaje> registros;

    /**
     * Constructor que inicializa todas las colecciones.
     */
    public AlmacenDatos()
    {
        motores = new ArrayList<Motor>();
        tapicerias = new ArrayList<Tapiceria>();
        ruedas = new ArrayList<Rueda>();
        vehiculos = new ArrayList<Vehiculo>();
        trabajadores = new ArrayList<Trabajador>();
        registros = new ArrayList<RegistroMontaje>();
    }

    // ========== GESTIÓN DE MOTORES ==========

    public void addMotor(Motor motor)
    {
        motores.add(motor);
    }

    public Motor getMotor(int index)
    {
        if (index >= 0 && index < motores.size()) {
            return motores.get(index);
        }
        return null;
    }

    public ArrayList<Motor> getMotores()
    {
        return motores;
    }

    public int getStockMotores()
    {
        return motores.size();
    }

    /**
     * Retira un motor del almacén por tipo.
     * @param tipo Tipo de motor ("Eléctrico", "Gasolina", "Híbrido").
     * @return Motor retirado, o null si no hay stock.
     */
    public Motor retirarMotor(String tipo)
    {
        for (int i = 0; i < motores.size(); i++) {
            if (motores.get(i).getTipo().equals(tipo)) {
                return motores.remove(i);
            }
        }
        return null;
    }

    // ========== GESTIÓN DE TAPICERÍA ==========

    public void addTapiceria(Tapiceria tapiceria)
    {
        tapicerias.add(tapiceria);
    }

    public Tapiceria getTapiceria(int index)
    {
        if (index >= 0 && index < tapicerias.size()) {
            return tapicerias.get(index);
        }
        return null;
    }

    public ArrayList<Tapiceria> getTapicerias()
    {
        return tapicerias;
    }

    public int getStockTapicerias()
    {
        return tapicerias.size();
    }

    public Tapiceria retirarTapiceria(String tipo)
    {
        for (int i = 0; i < tapicerias.size(); i++) {
            if (tapicerias.get(i).getTipo().equals(tipo)) {
                return tapicerias.remove(i);
            }
        }
        return null;
    }

    // ========== GESTIÓN DE RUEDAS ==========

    public void addRueda(Rueda rueda)
    {
        ruedas.add(rueda);
    }

    public Rueda getRueda(int index)
    {
        if (index >= 0 && index < ruedas.size()) {
            return ruedas.get(index);
        }
        return null;
    }

    public ArrayList<Rueda> getRuedas()
    {
        return ruedas;
    }

    public int getStockRuedas()
    {
        return ruedas.size();
    }

    public Rueda retirarRueda(String tipo)
    {
        for (int i = 0; i < ruedas.size(); i++) {
            if (ruedas.get(i).getTipo().equals(tipo)) {
                return ruedas.remove(i);
            }
        }
        return null;
    }

    /**
     * Cuenta las ruedas disponibles de un tipo específico.
     * @param tipo Tipo de rueda.
     * @return Cantidad de ruedas disponibles de ese tipo.
     */
    public int contarRuedasPorTipo(String tipo)
    {
        int count = 0;
        for (Rueda r : ruedas) {
            if (r.getTipo().equals(tipo)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Cuenta los motores disponibles de un tipo específico.
     * @param tipo Tipo de motor.
     * @return Cantidad de motores disponibles de ese tipo.
     */
    public int contarMotoresPorTipo(String tipo)
    {
        int count = 0;
        for (Motor m : motores) {
            if (m.getTipo().equals(tipo)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Cuenta las tapicerías disponibles de un tipo específico.
     * @param tipo Tipo de tapicería.
     * @return Cantidad disponible de ese tipo.
     */
    public int contarTapiceriasPorTipo(String tipo)
    {
        int count = 0;
        for (Tapiceria t : tapicerias) {
            if (t.getTipo().equals(tipo)) {
                count++;
            }
        }
        return count;
    }

    // ========== GESTIÓN DE VEHÍCULOS ==========

    public void addVehiculo(Vehiculo vehiculo)
    {
        vehiculos.add(vehiculo);
    }

    public Vehiculo getVehiculo(int index)
    {
        if (index >= 0 && index < vehiculos.size()) {
            return vehiculos.get(index);
        }
        return null;
    }

    public ArrayList<Vehiculo> getVehiculos()
    {
        return vehiculos;
    }

    public int getTotalVehiculos()
    {
        return vehiculos.size();
    }

    // ========== GESTIÓN DE TRABAJADORES ==========

    public void addTrabajador(Trabajador trabajador)
    {
        trabajadores.add(trabajador);
    }

    public Trabajador getTrabajadorPorDni(String dni)
    {
        for (Trabajador t : trabajadores) {
            if (t.getDni().equals(dni)) {
                return t;
            }
        }
        return null;
    }

    public ArrayList<Trabajador> getTrabajadores()
    {
        return trabajadores;
    }

    /**
     * Obtiene todos los operarios del almacén.
     * @return Lista de operarios.
     */
    public ArrayList<Operario> getOperarios()
    {
        ArrayList<Operario> ops = new ArrayList<Operario>();
        for (Trabajador t : trabajadores) {
            if (t instanceof Operario) {
                ops.add((Operario) t);
            }
        }
        return ops;
    }

    /**
     * Obtiene todos los mecánicos del almacén.
     * @return Lista de mecánicos de cinta.
     */
    public ArrayList<MecanicoCinta> getMecanicos()
    {
        ArrayList<MecanicoCinta> mecs = new ArrayList<MecanicoCinta>();
        for (Trabajador t : trabajadores) {
            if (t instanceof MecanicoCinta) {
                mecs.add((MecanicoCinta) t);
            }
        }
        return mecs;
    }

    /**
     * Obtiene el primer administrador del sistema disponible.
     * @return Administrador del sistema, o null si no hay.
     */
    public AdministradorSistema getAdministrador()
    {
        for (Trabajador t : trabajadores) {
            if (t instanceof AdministradorSistema) {
                return (AdministradorSistema) t;
            }
        }
        return null;
    }

    /**
     * Obtiene el primer gestor de planta disponible.
     * @return Gestor de planta, o null si no hay.
     */
    public GestorPlanta getGestorPlanta()
    {
        for (Trabajador t : trabajadores) {
            if (t instanceof GestorPlanta) {
                return (GestorPlanta) t;
            }
        }
        return null;
    }

    public void removeTrabajador(String dni)
    {
        for (int i = 0; i < trabajadores.size(); i++) {
            if (trabajadores.get(i).getDni().equals(dni)) {
                trabajadores.remove(i);
                return;
            }
        }
    }

    /**
     * Busca trabajadores por nombre (búsqueda parcial, no sensible a mayúsculas).
     * @param texto Texto a buscar en nombre o apellidos.
     * @return Lista de trabajadores que coinciden.
     */
    public ArrayList<Trabajador> buscarTrabajadores(String texto)
    {
        ArrayList<Trabajador> resultado = new ArrayList<Trabajador>();
        String textoBusqueda = texto.toLowerCase();
        for (Trabajador t : trabajadores) {
            if (t.getNombre().toLowerCase().contains(textoBusqueda) ||
                t.getApellidos().toLowerCase().contains(textoBusqueda) ||
                t.getDni().toLowerCase().contains(textoBusqueda)) {
                resultado.add(t);
            }
        }
        return resultado;
    }

    // ========== REGISTROS DE MONTAJE ==========

    public void addRegistroMontaje(RegistroMontaje registro)
    {
        registros.add(registro);
    }

    public ArrayList<RegistroMontaje> getRegistrosPorFecha(String fecha)
    {
        ArrayList<RegistroMontaje> resultado = new ArrayList<RegistroMontaje>();
        for (RegistroMontaje r : registros) {
            if (r.getFecha().equals(fecha)) {
                resultado.add(r);
            }
        }
        return resultado;
    }

    public ArrayList<RegistroMontaje> getTodosRegistros()
    {
        return registros;
    }
}
