import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Sistema de Gestión de la Fábrica de Vehículos.
 * Coordina el almacén, las cadenas de montaje, el dashboard
 * y el planificador. Gestiona trabajadores y componentes.
 * 
 * @author Estudiante UNED
 * @version 1.0
 */
public class SistemaGestion
{
    private IAlmacenDatos almacen;
    private CadenaMontaje[] cadenas;
    private Dashboard dashboard;
    private Planificador planificador;

    /**
     * Constructor del Sistema de Gestión.
     * Inicializa todos los subsistemas.
     */
    public SistemaGestion()
    {
        this.almacen = new AlmacenDatos();
        this.cadenas = new CadenaMontaje[3];
        cadenas[0] = new CadenaMontaje(1);
        cadenas[1] = new CadenaMontaje(2);
        cadenas[2] = new CadenaMontaje(3);

        IVisualizador visualizador = new VisualizadorConsola();
        this.dashboard = new Dashboard(visualizador, cadenas, almacen);
        this.planificador = new Planificador(cadenas, almacen, dashboard);
    }

    // ========== GESTIÓN DE ALMACÉN ==========

    public void addMotores(int tipo, int cantidad, double cilindrada,
                           double potencia, int numCilindros)
    {
        for (int i = 0; i < cantidad; i++) {
            Motor motor;
            switch (tipo) {
                case 1: motor = new MotorElectrico(potencia); break;
                case 2: motor = new MotorGasolina(cilindrada, potencia, numCilindros); break;
                case 3: motor = new MotorHibrido(cilindrada, potencia, numCilindros); break;
                default: motor = new MotorGasolina(cilindrada, potencia, numCilindros);
            }
            almacen.addMotor(motor);
        }
    }

    public void addTapicerias(int tipo, int cantidad, String color, double metrosCuadrados)
    {
        for (int i = 0; i < cantidad; i++) {
            Tapiceria tapiceria;
            switch (tipo) {
                case 1: tapiceria = new TapiceriaTela(color, metrosCuadrados); break;
                case 2: tapiceria = new TapiceriaCuero(color, metrosCuadrados); break;
                case 3: tapiceria = new TapiceriaAlcantara(color, metrosCuadrados); break;
                default: tapiceria = new TapiceriaTela(color, metrosCuadrados);
            }
            almacen.addTapiceria(tapiceria);
        }
    }

    public void addRuedas(int tipo, int cantidad, int anchoMm,
                          double diametroPulgadas, int indiceCarga, int codigoVelocidad)
    {
        for (int i = 0; i < cantidad; i++) {
            Rueda rueda;
            switch (tipo) {
                case 1: rueda = new RuedaNormal(anchoMm, diametroPulgadas, indiceCarga, codigoVelocidad); break;
                case 2: rueda = new RuedaDeportiva(anchoMm, diametroPulgadas, indiceCarga, codigoVelocidad); break;
                case 3: rueda = new RuedaTodoterreno(anchoMm, diametroPulgadas, indiceCarga, codigoVelocidad); break;
                default: rueda = new RuedaNormal(anchoMm, diametroPulgadas, indiceCarga, codigoVelocidad);
            }
            almacen.addRueda(rueda);
        }
    }

    // ========== GESTIÓN DE TRABAJADORES ==========

    public void altaOperario(String nombre, String apellidos, String dni,
                              String direccion, String nss, double salario, String fechaIngreso)
    {
        almacen.addTrabajador(new Operario(nombre, apellidos, dni, direccion, nss, salario, fechaIngreso));
    }

    public void altaGestorPlanta(String nombre, String apellidos, String dni,
                                  String direccion, String nss, double salario, String fechaIngreso)
    {
        almacen.addTrabajador(new GestorPlanta(nombre, apellidos, dni, direccion, nss, salario, fechaIngreso));
    }

    public void altaAdministrador(String nombre, String apellidos, String dni,
                                   String direccion, String nss, double salario, String fechaIngreso)
    {
        almacen.addTrabajador(new AdministradorSistema(nombre, apellidos, dni, direccion, nss, salario, fechaIngreso));
    }

    public void altaMecanico(String nombre, String apellidos, String dni,
                              String direccion, String nss, double salario, String fechaIngreso)
    {
        almacen.addTrabajador(new MecanicoCinta(nombre, apellidos, dni, direccion, nss, salario, fechaIngreso));
    }

    // ========== CONFIGURACIÓN DE CADENAS ==========

    public boolean configurarCadena(int numCadena, int tipoVehiculo, int tipoMotor,
                                     int tipoTapiceria, int tipoRueda, int unidades)
    {
        if (numCadena < 1 || numCadena > 3) {
            System.out.println("  Error: Número de cadena inválido (1-3).");
            return false;
        }

        String[] nombresMotor = {"", "Eléctrico", "Gasolina", "Híbrido"};
        String[] nombresTapiceria = {"", "Tela", "Cuero", "Alcántara"};
        String[] nombresRueda = {"", "Normal", "Deportiva", "Todoterreno"};

        int stockMotor = ((AlmacenDatos) almacen).contarMotoresPorTipo(nombresMotor[tipoMotor]);
        int stockTap = ((AlmacenDatos) almacen).contarTapiceriasPorTipo(nombresTapiceria[tipoTapiceria]);
        int stockRue = ((AlmacenDatos) almacen).contarRuedasPorTipo(nombresRueda[tipoRueda]);

        if (stockMotor < unidades) {
            System.out.println("  Error: Stock insuficiente de motores " + nombresMotor[tipoMotor]
                               + " (disponibles: " + stockMotor + ", necesarios: " + unidades + ")");
            return false;
        }
        if (stockTap < unidades) {
            System.out.println("  Error: Stock insuficiente de tapicería " + nombresTapiceria[tipoTapiceria]
                               + " (disponibles: " + stockTap + ", necesarios: " + unidades + ")");
            return false;
        }
        if (stockRue < unidades) {
            System.out.println("  Error: Stock insuficiente de ruedas " + nombresRueda[tipoRueda]
                               + " (disponibles: " + stockRue + ", necesarios: " + unidades + ")");
            return false;
        }

        cadenas[numCadena - 1].configurar(tipoVehiculo, tipoMotor, tipoTapiceria, tipoRueda, unidades);
        System.out.println("  Cadena " + numCadena + " configurada correctamente.");
        return true;
    }

    // ========== PLANIFICADOR ==========

    public void iniciarSimulacion(TipoSimulacion tipo)
    {
        planificador.ejecutarSimulacion(tipo);
    }

    // ========== CONSULTAS Y LISTADOS ==========

    public void listarTrabajadores()
    {
        ArrayList<Trabajador> trabajadores = almacen.getTrabajadores();
        System.out.println("\n  === LISTADO DE TRABAJADORES (" + trabajadores.size() + ") ===");
        for (Trabajador t : trabajadores) {
            System.out.println("  " + t.toString());
        }
    }

    public void listarOperarios(boolean soloEficientes, boolean ordenAlfabetico)
    {
        ArrayList<Operario> operarios = almacen.getOperarios();
        ArrayList<Operario> filtrados = new ArrayList<Operario>();
        for (Operario op : operarios) {
            if (!soloEficientes || op.isEficiente()) {
                filtrados.add(op);
            }
        }
        if (ordenAlfabetico) {
            Collections.sort(filtrados, new Comparator<Operario>() {
                public int compare(Operario a, Operario b) {
                    return a.getApellidos().compareTo(b.getApellidos());
                }
            });
        }
        String filtro = soloEficientes ? "EFICIENTES" : "TODOS";
        System.out.println("\n  === OPERARIOS (" + filtro + ") - Total: " + filtrados.size() + " ===");
        for (Operario op : filtrados) {
            System.out.println("  " + op.toString());
        }
    }

    public void listarVehiculos(String filtroComponente, boolean ordenAlfabetico)
    {
        ArrayList<Vehiculo> vehiculos = almacen.getVehiculos();
        ArrayList<Vehiculo> filtrados = new ArrayList<Vehiculo>();
        for (Vehiculo v : vehiculos) {
            if (filtroComponente == null || filtroComponente.isEmpty()) {
                filtrados.add(v);
            } else {
                if ((v.getMotor() != null && v.getMotor().getTipo().equalsIgnoreCase(filtroComponente)) ||
                    (v.getTapiceria() != null && v.getTapiceria().getTipo().equalsIgnoreCase(filtroComponente)) ||
                    (v.getRuedas()[0] != null && v.getRuedas()[0].getTipo().equalsIgnoreCase(filtroComponente))) {
                    filtrados.add(v);
                }
            }
        }
        if (ordenAlfabetico) {
            Collections.sort(filtrados, new Comparator<Vehiculo>() {
                public int compare(Vehiculo a, Vehiculo b) {
                    return a.getTipo().compareTo(b.getTipo());
                }
            });
        }
        System.out.println("\n  === VEHÍCULOS ENSAMBLADOS - Total: " + filtrados.size() + " ===");
        for (Vehiculo v : filtrados) {
            System.out.println("  " + v.toString());
        }
    }

    public void consultarStock()
    {
        dashboard.mostrarAlmacen();
    }

    public void buscarTrabajadores(String texto)
    {
        ArrayList<Trabajador> resultados = ((AlmacenDatos) almacen).buscarTrabajadores(texto);
        System.out.println("\n  === BÚSQUEDA '" + texto + "' (" + resultados.size() + " encontrados) ===");
        for (Trabajador t : resultados) {
            System.out.println("  " + t.toString());
        }
    }

    public void consultarRegistros(String fecha)
    {
        ArrayList<RegistroMontaje> registros = almacen.getRegistrosPorFecha(fecha);
        System.out.println("\n  === REGISTROS [" + fecha + "] - Total: " + registros.size() + " ===");
        for (RegistroMontaje r : registros) {
            System.out.println("  " + r.toString());
        }
    }

    public void mostrarDashboard()
    {
        dashboard.actualizar();
    }

    // ---- Getters ----
    public IAlmacenDatos getAlmacen() { return almacen; }
    public CadenaMontaje[] getCadenas() { return cadenas; }
    public Dashboard getDashboard() { return dashboard; }
    public Planificador getPlanificador() { return planificador; }
}
