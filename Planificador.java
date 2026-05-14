import java.util.ArrayList;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Planificador (Scheduler) que simula el funcionamiento de las cadenas de montaje.
 * Actúa como un reloj donde cada segundo ejecuta una acción.
 * 
 * Tres tipos de simulación:
 * - Simple: sin problemas, sólo operarios aleatorios.
 * - Compleja: mecánicos reparan al menos 2 problemas por cinta.
 * - Muy compleja: operarios, mecánicos y administrador; 2-3 problemas
 *   por cadena y al menos 1 caída de luz.
 * 
 * @author Sergio Cuadrado Hernández

 */
public class Planificador
{
    private CadenaMontaje[] cadenas;
    private IAlmacenDatos almacen;
    private Dashboard dashboard;
    private int segundoActual;
    private Random random;
    private String fechaActual;
    private boolean[] esperandoMontaje;

    public Planificador(CadenaMontaje[] cadenas, IAlmacenDatos almacen, 
                        Dashboard dashboard)
    {
        this.cadenas = cadenas;
        this.almacen = almacen;
        this.dashboard = dashboard;
        this.segundoActual = 0;
        this.random = new Random();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.fechaActual = sdf.format(new Date());
        this.esperandoMontaje = new boolean[3];
    }

    public void ejecutarSimulacion(TipoSimulacion tipo)
    {
        segundoActual = 0;
        System.out.println("\n  *** INICIANDO SIMULACIÓN " + tipo.getDescripcion().toUpperCase() + " ***\n");
        
        // Asignar operarios aleatorios a las cadenas
        asignarOperariosAleatorios();

        // Mostrar estado inicial
        dashboard.actualizar();

        // Preparar problemas según tipo de simulación
        int[][] problemasProgramados = null;
        boolean caidaLuzProgramada = false;
        int segundoCaidaLuz = -1;

        if (tipo == TipoSimulacion.COMPLEJA) {
            problemasProgramados = generarProblemasComplejos();
        } else if (tipo == TipoSimulacion.MUY_COMPLEJA) {
            problemasProgramados = generarProblemasMuyComplejos();
            caidaLuzProgramada = true;
            // La caída de luz ocurre en un segundo aleatorio
            segundoCaidaLuz = 3 + random.nextInt(5);
        }

        // Bucle principal de simulación
        boolean hayTrabajo = true;
        while (hayTrabajo) {
            segundoActual++;
            System.out.println("\n  ─── SEGUNDO " + segundoActual + " ───");

            // Comprobar caída de luz (simulación muy compleja)
            if (caidaLuzProgramada && segundoActual == segundoCaidaLuz) {
                System.out.println("  ⚡ ¡¡CAÍDA DE LUZ!! Todas las cadenas se detienen.");
                AdministradorSistema admin = ((AlmacenDatos) almacen).getAdministrador();
                if (admin != null) {
                    int tiempoRecuperacion = admin.restaurarTodo();
                    // Parar todas las cadenas durante el tiempo de recuperación
                    for (CadenaMontaje cadena : cadenas) {
                        cadena.setTiempoParada(tiempoRecuperacion);
                        cadena.setAveriada(true);
                    }
                    dashboard.notificar("Sistema restaurado por " + admin.getNombreCompleto()
                                       + ". Tiempo total: " + tiempoRecuperacion + "s");
                    registrar(0, "Sistema", "Caída de luz - Restauración: " + tiempoRecuperacion + "s", 0);
                }
                caidaLuzProgramada = false; // Solo una caída de luz
            }

            // Comprobar problemas programados (simulaciones compleja y muy compleja)
            if (problemasProgramados != null) {
                for (int c = 0; c < 3; c++) {
                    if (problemasProgramados[c] != null) {
                        for (int p = 0; p < problemasProgramados[c].length; p++) {
                            if (problemasProgramados[c][p] == segundoActual) {
                                provocarAveria(cadenas[c]);
                            }
                        }
                    }
                }
            }

            // Procesar cada cadena de montaje
            for (CadenaMontaje cadena : cadenas) {
                procesarCadena(cadena);
            }

            // Mostrar dashboard actualizado
            dashboard.actualizar();

            // Comprobar si queda trabajo
            hayTrabajo = false;
            for (CadenaMontaje cadena : cadenas) {
                if (cadena.tieneTrabajoPendiente() || cadena.isAveriada()) {
                    hayTrabajo = true;
                    break;
                }
            }

            // Límite de seguridad para evitar bucle infinito
            if (segundoActual > 200) {
                System.out.println("  [AVISO] Límite de simulación alcanzado (200s).");
                break;
            }
        }

        System.out.println("\n  *** SIMULACIÓN " + tipo.getDescripcion().toUpperCase() + " FINALIZADA ***");
        System.out.println("  Tiempo total: " + segundoActual + " segundos");
        for (CadenaMontaje cadena : cadenas) {
            System.out.println("  Cadena " + cadena.getNumero() + ": " 
                               + cadena.getUnidadesCompletadas() + " vehículos completados");
        }
    }

    private void procesarCadena(CadenaMontaje cadena)
    {
        // Si está averiada, decrementar tiempo de parada
        if (cadena.isAveriada()) {
            System.out.println("  Cadena " + cadena.getNumero() + ": AVERIADA (parada " 
                               + cadena.getTiempoParada() + "s restantes)");
            cadena.decrementarParada();
            return;
        }

        // Si tiene tiempo de parada pendiente, esperar
        if (cadena.getTiempoParada() > 0) {
            cadena.decrementarParada();
            System.out.println("  Cadena " + cadena.getNumero() + ": En pausa (" 
                               + cadena.getTiempoParada() + "s restantes)");
            return;
        }

        // Si no hay vehículo actual y hay unidades pendientes, crear uno nuevo
        if (cadena.getVehiculoActual() == null && cadena.getUnidadesPendientes() > 0) {
            Vehiculo nuevoVehiculo = cadena.crearNuevoVehiculo();
            cadena.setVehiculoActual(nuevoVehiculo);
            cadena.setUnidadesPendientes(cadena.getUnidadesPendientes() - 1);
            nuevoVehiculo.setEstado(EstadoVehiculo.PENDIENTE);
            System.out.println("  Cadena " + cadena.getNumero() 
                               + ": Nuevo vehículo #" + nuevoVehiculo.getId() 
                               + " (" + nuevoVehiculo.getTipo() + ") iniciado");
        }

        Vehiculo vehiculo = cadena.getVehiculoActual();
        if (vehiculo == null) return;

        // Determinar qué estación procesar según el estado actual
        EstadoVehiculo estadoActual = vehiculo.getEstado();
        int estacion = -1;

        switch (estadoActual) {
            case PENDIENTE: estacion = 0; break; // Montar chasis
            case CHASIS:    estacion = 1; break; // Montar motor
            case MOTOR:     estacion = 2; break; // Montar tapicería
            case TAPICERIA: estacion = 3; break; // Montar ruedas
            default: break;
        }

        if (estacion >= 0 && estacion < 4) {
            Operario operario = cadena.getOperarios()[estacion];
            if (operario != null) {
                int tiempoNecesario = operario.getTiempoMontaje();

                // Si el operario es estándar, necesita más segundos (usar parada)
                if (tiempoNecesario > 1 && !esperandoMontaje[cadena.getNumero() - 1]) {
                    // Primer segundo del montaje estándar: poner en espera
                    cadena.setTiempoParada(tiempoNecesario - 1);
                    esperandoMontaje[cadena.getNumero() - 1] = true;
                    System.out.println("  Cadena " + cadena.getNumero() + ": Operario " 
                                       + operario.getNombreCompleto() + " (" + operario.getPerfil() 
                                       + ") trabajando en " + getEtiquetaEstacion(estacion) 
                                       + " (" + tiempoNecesario + "s)");
                    return;
                }

                // Reiniciar flag
                esperandoMontaje[cadena.getNumero() - 1] = false;

                // Realizar el montaje
                realizarMontaje(cadena, vehiculo, estacion, operario);
            }
        }

        // Si el vehículo está completado, moverlo al almacén
        if (vehiculo.getEstado() == EstadoVehiculo.COMPLETADO) {
            almacen.addVehiculo(vehiculo);
            cadena.setUnidadesCompletadas(cadena.getUnidadesCompletadas() + 1);
            cadena.setVehiculoActual(null);
            System.out.println("  ✓ Cadena " + cadena.getNumero() 
                               + ": Vehículo #" + vehiculo.getId() + " COMPLETADO y almacenado.");
        }
    }

    private void realizarMontaje(CadenaMontaje cadena, Vehiculo vehiculo, 
                                  int estacion, Operario operario)
    {
        String componente = getEtiquetaEstacion(estacion);

        switch (estacion) {
            case 0: // Chasis
                vehiculo.setEstado(EstadoVehiculo.CHASIS);
                break;
            case 1: // Motor
                Motor motor = almacen.retirarMotor(cadena.getNombreTipoMotor());
                if (motor != null) {
                    vehiculo.setMotor(motor);
                    vehiculo.setEstado(EstadoVehiculo.MOTOR);
                } else {
                    dashboard.notificarError("Sin stock de motor " 
                                             + cadena.getNombreTipoMotor() 
                                             + " para cadena " + cadena.getNumero());
                    return;
                }
                break;
            case 2: // Tapicería
                Tapiceria tapiceria = almacen.retirarTapiceria(cadena.getNombreTipoTapiceria());
                if (tapiceria != null) {
                    vehiculo.setTapiceria(tapiceria);
                    vehiculo.setEstado(EstadoVehiculo.TAPICERIA);
                } else {
                    dashboard.notificarError("Sin stock de tapicería " 
                                             + cadena.getNombreTipoTapiceria() 
                                             + " para cadena " + cadena.getNumero());
                    return;
                }
                break;
            case 3: // Ruedas
                Rueda rueda = almacen.retirarRueda(cadena.getNombreTipoRueda());
                if (rueda != null) {
                    vehiculo.setRuedas(rueda);
                    vehiculo.setEstado(EstadoVehiculo.RUEDAS);
                    // Avanzar a COMPLETADO
                    vehiculo.setEstado(EstadoVehiculo.COMPLETADO);
                } else {
                    dashboard.notificarError("Sin stock de ruedas " 
                                             + cadena.getNombreTipoRueda() 
                                             + " para cadena " + cadena.getNumero());
                    return;
                }
                break;
        }

        operario.incrementarMontajes();
        System.out.println("  Cadena " + cadena.getNumero() + ": " + componente 
                           + " montado por " + operario.getNombreCompleto() 
                           + " en vehículo #" + vehiculo.getId());
        
        registrar(cadena.getNumero(), componente, 
                  "Montaje completado por " + operario.getNombreCompleto(), vehiculo.getId());
    }

    private void provocarAveria(CadenaMontaje cadena)
    {
        cadena.setAveriada(true);
        System.out.println("  ⚠ ¡AVERÍA en cadena " + cadena.getNumero() + "!");
        
        // Buscar un mecánico disponible
        ArrayList<MecanicoCinta> mecanicos = ((AlmacenDatos) almacen).getMecanicos();
        if (!mecanicos.isEmpty()) {
            MecanicoCinta mecanico = mecanicos.get(random.nextInt(mecanicos.size()));
            int tiempoReparacion = mecanico.repararCinta(cadena);
            cadena.setTiempoParada(tiempoReparacion);
            cadena.incrementarProblemas();
            registrar(cadena.getNumero(), "Avería", 
                      "Reparada por " + mecanico.getNombreCompleto() 
                      + " en " + tiempoReparacion + "s", 0);
        } else {
            cadena.setTiempoParada(5);
            dashboard.notificarError("No hay mecánicos disponibles para cadena " 
                                     + cadena.getNumero());
        }
    }

    private void asignarOperariosAleatorios()
    {
        ArrayList<Operario> operariosDisponibles = ((AlmacenDatos) almacen).getOperarios();
        
        for (CadenaMontaje cadena : cadenas) {
            Operario[] asignados = new Operario[4];
            for (int i = 0; i < 4; i++) {
                if (!operariosDisponibles.isEmpty()) {
                    int idx = random.nextInt(operariosDisponibles.size());
                    asignados[i] = operariosDisponibles.get(idx);
                }
            }
            cadena.asignarOperarios(asignados);
        }
    }

    private int[][] generarProblemasComplejos()
    {
        int[][] problemas = new int[3][];
        for (int c = 0; c < 3; c++) {
            int numProblemas = 2 + random.nextInt(2); // 2 o 3 problemas
            problemas[c] = new int[numProblemas];
            for (int p = 0; p < numProblemas; p++) {
                problemas[c][p] = 2 + random.nextInt(8); // entre segundo 2 y 9
            }
        }
        return problemas;
    }

    private int[][] generarProblemasMuyComplejos()
    {
        int[][] problemas = new int[3][];
        for (int c = 0; c < 3; c++) {
            int numProblemas = 2 + random.nextInt(2); // 2 o 3 problemas
            problemas[c] = new int[numProblemas];
            for (int p = 0; p < numProblemas; p++) {
                problemas[c][p] = 2 + random.nextInt(10); // entre segundo 2 y 11
            }
        }
        return problemas;
    }

    private String getEtiquetaEstacion(int estacion)
    {
        switch (estacion) {
            case 0: return "Chasis";
            case 1: return "Motor";
            case 2: return "Tapicería";
            case 3: return "Ruedas";
            default: return "Desconocida";
        }
    }

    private void registrar(int numCadena, String componente, String descripcion, int vehiculoId)
    {
        RegistroMontaje reg = new RegistroMontaje(fechaActual, segundoActual, 
                                                   numCadena, componente, descripcion, vehiculoId);
        almacen.addRegistroMontaje(reg);
    }

    public int getSegundoActual()
    {
        return segundoActual;
    }
}
