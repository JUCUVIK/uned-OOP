import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase principal de la aplicación Fábrica de Vehículos.
 * Interfaz textual de menús para la gestión completa del sistema.
 * 
 * @author Sergio Cuadrado Hernández

 */
public class factory_main
{
    private static SistemaGestion sistema;
    private static Scanner scanner;

    public static void main(String[] args)
    {
        sistema = new SistemaGestion();
        scanner = new Scanner(System.in);
        cargarDatosIniciales();
        menuPrincipal();
        scanner.close();
    }

    private static void cargarDatosIniciales()
    {
        // Operarios
        sistema.altaOperario("Carlos", "García López", "12345678A", "Calle Mayor 1", "281234567890", 1800.0, "01/01/2024");
        sistema.altaOperario("María", "Fernández Ruiz", "23456789B", "Calle Sol 2", "282345678901", 1800.0, "15/03/2024");
        sistema.altaOperario("Pedro", "Martínez Díaz", "34567890C", "Calle Luna 3", "283456789012", 1800.0, "20/06/2024");
        sistema.altaOperario("Ana", "López Sánchez", "45678901D", "Calle Río 4", "284567890123", 1800.0, "01/09/2024");
        sistema.altaOperario("Luis", "Rodríguez Gil", "56789012E", "Calle Mar 5", "285678901234", 1800.0, "10/01/2025");
        sistema.altaOperario("Laura", "Sánchez Pérez", "67890123F", "Calle Pino 6", "286789012345", 1800.0, "01/02/2025");
        sistema.altaOperario("Juan", "Gómez Navarro", "78901234G", "Calle Olmo 7", "287890123456", 1800.0, "15/04/2025");
        sistema.altaOperario("Elena", "Díaz Torres", "89012345H", "Calle Fresno 8", "288901234567", 1800.0, "01/06/2025");
        sistema.altaOperario("Pablo", "Ruiz Castro", "90123456I", "Calle Sauce 9", "289012345678", 1800.0, "10/07/2025");
        sistema.altaOperario("Sara", "Torres Vega", "01234567J", "Calle Roble 10", "280123456789", 1800.0, "01/08/2025");
        sistema.altaOperario("Diego", "Navarro Blanco", "11223344K", "Calle Haya 11", "281122334455", 1800.0, "15/09/2025");
        sistema.altaOperario("Clara", "Moreno Ruiz", "22334455L", "Calle Tilo 12", "282233445566", 1800.0, "01/10/2025");

        // Gestor de planta
        sistema.altaGestorPlanta("Roberto", "Hernández Mora", "33445566M", "Av. Principal 1", "283344556677", 2800.0, "01/01/2023");

        // Administrador del sistema
        sistema.altaAdministrador("Isabel", "Jiménez Ortega", "44556677N", "Av. Central 2", "284455667788", 3200.0, "01/01/2022");

        // Mecánicos
        sistema.altaMecanico("Andrés", "Molina Serrano", "55667788O", "Calle Taller 1", "285566778899", 2200.0, "01/03/2023");
        sistema.altaMecanico("Lucía", "Romero Gil", "66778899P", "Calle Taller 2", "286677889900", 2200.0, "15/05/2023");
        sistema.altaMecanico("Fernando", "Álvarez Ruiz", "77889900Q", "Calle Taller 3", "287788990011", 2200.0, "01/08/2024");

        // Motores
        sistema.addMotores(1, 10, 0, 150, 0);        // 10 eléctricos
        sistema.addMotores(2, 15, 1600, 120, 4);      // 15 gasolina
        sistema.addMotores(3, 10, 1400, 140, 4);       // 10 híbridos

        // Tapicerías
        sistema.addTapicerias(1, 15, "Gris", 5.0);     // 15 tela
        sistema.addTapicerias(2, 10, "Negro", 5.5);     // 10 cuero
        sistema.addTapicerias(3, 10, "Beige", 5.2);     // 10 alcántara

        // Ruedas (se almacenan individualmente, 4 por vehículo)
        sistema.addRuedas(1, 20, 205, 16, 710, 210);     // 20 normales
        sistema.addRuedas(2, 15, 225, 18, 750, 270);     // 15 deportivas
        sistema.addRuedas(3, 15, 235, 17, 900, 190);     // 15 todoterreno

        System.out.println("  Datos iniciales cargados correctamente.\n");
    }

    private static void menuPrincipal()
    {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n  ※╔══════════════════════════════════════════════════╗※");
            System.out.println("  ※║    SISTEMA DE GESTIÓN - FÁBRICA DE VEHÍCULOS     ║※");
            System.out.println("  ※╠══════════════════════════════════════════════════╣※");
            System.out.println("  ※║  1. Gestión de Almacén                           ║※");
            System.out.println("  ※║  2. Gestión de Trabajadores                      ║※");
            System.out.println("  ※║  3. Configurar Cadenas de Montaje                ║※");
            System.out.println("  ※║  4. Iniciar Simulación                           ║※");
            System.out.println("  ※║  5. Dashboard                                    ║※");
            System.out.println("  ※║  6. Consultas y Listados                         ║※");
            System.out.println("  ※║  0. Salir                                        ║※");
            System.out.println("  ※╚══════════════════════════════════════════════════╝※");
            System.out.print("  Seleccione una opción: ");

            opcion = leerEntero();
            switch (opcion) {
                case 1: menuAlmacen(); break;
                case 2: menuTrabajadores(); break;
                case 3: menuCadenas(); break;
                case 4: menuSimulacion(); break;
                case 5: sistema.mostrarDashboard(); break;
                case 6: menuConsultas(); break;
                case 0: System.out.println("  ¡Hasta luego!"); break;
                default: System.out.println("  Opción no válida.");
            }
        }
    }

    private static void menuAlmacen()
    {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n  --- GESTIÓN DE ALMACÉN ---");
            System.out.println("  1. Añadir motores");
            System.out.println("  2. Añadir tapicería");
            System.out.println("  3. Añadir ruedas");
            System.out.println("  4. Consultar stock");
            System.out.println("  0. Volver");
            System.out.print("  Opción: ");

            opcion = leerEntero();
            switch (opcion) {
                case 1:
                    System.out.println("  Tipo (1=Eléctrico, 2=Gasolina, 3=Híbrido): ");
                    int tipoMotor = leerEntero();
                    System.out.print("  Cantidad: "); int cantM = leerEntero();
                    System.out.print("  Cilindrada (cc): "); double cil = leerDouble();
                    System.out.print("  Potencia (CV): "); double pot = leerDouble();
                    System.out.print("  Nº cilindros: "); int nCil = leerEntero();
                    sistema.addMotores(tipoMotor, cantM, cil, pot, nCil);
                    System.out.println("  Motores añadidos.");
                    break;
                case 2:
                    System.out.println("  Tipo (1=Tela, 2=Cuero, 3=Alcántara): ");
                    int tipoTap = leerEntero();
                    System.out.print("  Cantidad: "); int cantT = leerEntero();
                    System.out.print("  Color: "); String colorT = scanner.nextLine();
                    System.out.print("  Metros cuadrados: "); double m2 = leerDouble();
                    sistema.addTapicerias(tipoTap, cantT, colorT, m2);
                    System.out.println("  Tapicerías añadidas.");
                    break;
                case 3:
                    System.out.println("  Tipo (1=Normal, 2=Deportiva, 3=Todoterreno): ");
                    int tipoRueda = leerEntero();
                    System.out.print("  Cantidad: "); int cantR = leerEntero();
                    System.out.print("  Ancho (mm): "); int ancho = leerEntero();
                    System.out.print("  Diámetro llanta (pulgadas): "); double diam = leerDouble();
                    System.out.print("  Índice carga (kg): "); int carga = leerEntero();
                    System.out.print("  Código velocidad (km/h): "); int vel = leerEntero();
                    sistema.addRuedas(tipoRueda, cantR, ancho, diam, carga, vel);
                    System.out.println("  Ruedas añadidas.");
                    break;
                case 4:
                    sistema.consultarStock();
                    break;
                case 0: break;
                default: System.out.println("  Opción no válida.");
            }
        }
    }

    private static void menuTrabajadores()
    {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n  --- GESTIÓN DE TRABAJADORES ---");
            System.out.println("  1. Alta operario");
            System.out.println("  2. Alta gestor de planta");
            System.out.println("  3. Alta administrador del sistema");
            System.out.println("  4. Alta mecánico de cinta");
            System.out.println("  5. Listar todos los trabajadores");
            System.out.println("  6. Buscar trabajador");
            System.out.println("  0. Volver");
            System.out.print("  Opción: ");

            opcion = leerEntero();
            if (opcion >= 1 && opcion <= 4) {
                System.out.print("  Nombre: "); String nom = scanner.nextLine();
                System.out.print("  Apellidos: "); String ape = scanner.nextLine();
                System.out.print("  DNI: "); String dni = scanner.nextLine();
                System.out.print("  Dirección: "); String dir = scanner.nextLine();
                System.out.print("  Nº Seg. Social: "); String nss = scanner.nextLine();
                System.out.print("  Salario: "); double sal = leerDouble();
                System.out.print("  Fecha ingreso (dd/mm/yyyy): "); String fecha = scanner.nextLine();

                switch (opcion) {
                    case 1: sistema.altaOperario(nom, ape, dni, dir, nss, sal, fecha); break;
                    case 2: sistema.altaGestorPlanta(nom, ape, dni, dir, nss, sal, fecha); break;
                    case 3: sistema.altaAdministrador(nom, ape, dni, dir, nss, sal, fecha); break;
                    case 4: sistema.altaMecanico(nom, ape, dni, dir, nss, sal, fecha); break;
                }
                System.out.println("  Trabajador dado de alta correctamente.");
            } else if (opcion == 5) {
                sistema.listarTrabajadores();
            } else if (opcion == 6) {
                System.out.print("  Texto de búsqueda: ");
                String busqueda = scanner.nextLine();
                sistema.buscarTrabajadores(busqueda);
            }
        }
    }

    private static void menuCadenas()
    {
        System.out.println("\n  --- CONFIGURAR CADENAS DE MONTAJE ---");
        for (int i = 1; i <= 3; i++) {
            System.out.println("\n  Cadena " + i + ":");
            System.out.println("  Tipo vehículo (1=Biplaza, 2=Turismo, 3=Furgoneta): ");
            int tv = leerEntero();
            System.out.println("  Tipo motor (1=Eléctrico, 2=Gasolina, 3=Híbrido): ");
            int tm = leerEntero();
            System.out.println("  Tipo tapicería (1=Tela, 2=Cuero, 3=Alcántara): ");
            int tt = leerEntero();
            System.out.println("  Tipo rueda (1=Normal, 2=Deportiva, 3=Todoterreno): ");
            int tr = leerEntero();
            System.out.print("  Unidades a producir: ");
            int un = leerEntero();
            sistema.configurarCadena(i, tv, tm, tt, tr, un);
        }
    }

    private static void menuSimulacion()
    {
        System.out.println("\n  --- TIPO DE SIMULACIÓN ---");
        System.out.println("  1. Simple (sin problemas)");
        System.out.println("  2. Compleja (con mecánicos)");
        System.out.println("  3. Muy Compleja (mecánicos + caída de luz)");
        System.out.print("  Opción: ");
        int op = leerEntero();
        switch (op) {
            case 1: sistema.iniciarSimulacion(TipoSimulacion.SIMPLE); break;
            case 2: sistema.iniciarSimulacion(TipoSimulacion.COMPLEJA); break;
            case 3: sistema.iniciarSimulacion(TipoSimulacion.MUY_COMPLEJA); break;
            default: System.out.println("  Opción no válida.");
        }
    }

    private static void menuConsultas()
    {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n  --- CONSULTAS Y LISTADOS ---");
            System.out.println("  1. Listar operarios (todos)");
            System.out.println("  2. Listar operarios eficientes");
            System.out.println("  3. Listar operarios (orden alfabético)");
            System.out.println("  4. Listar vehículos ensamblados");
            System.out.println("  5. Listar vehículos por componente");
            System.out.println("  6. Consultar registros de montaje por fecha");
            System.out.println("  7. Stock de componentes");
            System.out.println("  0. Volver");
            System.out.print("  Opción: ");

            opcion = leerEntero();
            switch (opcion) {
                case 1: sistema.listarOperarios(false, false); break;
                case 2: sistema.listarOperarios(true, false); break;
                case 3: sistema.listarOperarios(false, true); break;
                case 4: sistema.listarVehiculos(null, true); break;
                case 5:
                    System.out.print("  Componente a filtrar: ");
                    String comp = scanner.nextLine();
                    sistema.listarVehiculos(comp, true);
                    break;
                case 6:
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String hoy = sdf.format(new Date());
                    System.out.print("  Fecha (dd/mm/yyyy) [" + hoy + "]: ");
                    String f = scanner.nextLine();
                    if (f.isEmpty()) f = hoy;
                    sistema.consultarRegistros(f);
                    break;
                case 7: sistema.consultarStock(); break;
                case 0: break;
                default: System.out.println("  Opción no válida.");
            }
        }
    }

    private static int leerEntero()
    {
        try {
            String linea = scanner.nextLine().trim();
            return Integer.parseInt(linea);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static double leerDouble()
    {
        try {
            String linea = scanner.nextLine().trim();
            return Double.parseDouble(linea);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
