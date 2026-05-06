import java.util.ArrayList;

/**
 * Cadena de montaje que ensambla vehículos paso a paso.
 * Cada cadena tiene 4 estaciones: Chasis, Motor, Tapicería, Ruedas.
 * Cada estación tiene un robot controlado por un operario.
 * 
 * @author Estudiante UNED
 * @version 1.0
 */
public class CadenaMontaje
{
    private int numero;                  // número de cadena (1, 2 o 3)
    private boolean activa;
    private boolean averiada;
    private int tiempoParada;            // segundos restantes de parada
    
    // Configuración de producción
    private int tipoVehiculo;            // 1=Biplaza, 2=Turismo, 3=Furgoneta
    private int tipoMotor;               // 1=Eléctrico, 2=Gasolina, 3=Híbrido
    private int tipoTapiceria;           // 1=Tela, 2=Cuero, 3=Alcántara
    private int tipoRueda;               // 1=Normal, 2=Deportiva, 3=Todoterreno
    private int unidadesPendientes;
    private int unidadesCompletadas;
    
    // Vehículo en proceso de montaje
    private Vehiculo vehiculoActual;
    
    // Operarios asignados (4 estaciones)
    private Operario[] operarios;
    
    // Problemas reparados en esta simulación
    private int problemasReparados;

    /**
     * Constructor de CadenaMontaje.
     * @param numero Número identificador de la cadena (1, 2 o 3).
     */
    public CadenaMontaje(int numero)
    {
        this.numero = numero;
        this.activa = false;
        this.averiada = false;
        this.tiempoParada = 0;
        this.tipoVehiculo = 0;
        this.tipoMotor = 0;
        this.tipoTapiceria = 0;
        this.tipoRueda = 0;
        this.unidadesPendientes = 0;
        this.unidadesCompletadas = 0;
        this.vehiculoActual = null;
        this.operarios = new Operario[4];
        this.problemasReparados = 0;
    }

    /**
     * Configura la cadena de montaje para producir un tipo de vehículo.
     * @param tipoVehiculo Tipo de vehículo (1=Biplaza, 2=Turismo, 3=Furgoneta).
     * @param tipoMotor Tipo de motor (1=Eléctrico, 2=Gasolina, 3=Híbrido).
     * @param tipoTapiceria Tipo de tapicería (1=Tela, 2=Cuero, 3=Alcántara).
     * @param tipoRueda Tipo de rueda (1=Normal, 2=Deportiva, 3=Todoterreno).
     * @param unidades Unidades a producir.
     */
    public void configurar(int tipoVehiculo, int tipoMotor, int tipoTapiceria,
                            int tipoRueda, int unidades)
    {
        this.tipoVehiculo = tipoVehiculo;
        this.tipoMotor = tipoMotor;
        this.tipoTapiceria = tipoTapiceria;
        this.tipoRueda = tipoRueda;
        this.unidadesPendientes = unidades;
        this.unidadesCompletadas = 0;
        this.activa = true;
        this.vehiculoActual = null;
        this.problemasReparados = 0;
    }

    /**
     * Asigna operarios a las 4 estaciones de la cadena.
     * @param ops Array de 4 operarios.
     */
    public void asignarOperarios(Operario[] ops)
    {
        for (int i = 0; i < 4 && i < ops.length; i++) {
            this.operarios[i] = ops[i];
        }
    }

    /**
     * Crea un nuevo vehículo según la configuración de la cadena.
     * @return Nuevo vehículo con estado PENDIENTE.
     */
    public Vehiculo crearNuevoVehiculo()
    {
        String[] colores = {"Rojo", "Azul", "Negro", "Blanco", "Gris", "Plata"};
        String color = colores[(int)(Math.random() * colores.length)];
        
        switch (tipoVehiculo) {
            case 1: return new BiplazaDeportivo(color, 1200, 1600);
            case 2: return new Turismo(color, 5, 1400, 2000);
            case 3: return new Furgoneta(color, 3, 1800, 3500);
            default: return new Turismo(color, 5, 1400, 2000);
        }
    }

    /**
     * Obtiene el nombre del tipo de motor configurado.
     * @return Nombre del tipo de motor.
     */
    public String getNombreTipoMotor()
    {
        switch (tipoMotor) {
            case 1: return "Eléctrico";
            case 2: return "Gasolina";
            case 3: return "Híbrido";
            default: return "Desconocido";
        }
    }

    /**
     * Obtiene el nombre del tipo de tapicería configurado.
     * @return Nombre del tipo de tapicería.
     */
    public String getNombreTipoTapiceria()
    {
        switch (tipoTapiceria) {
            case 1: return "Tela";
            case 2: return "Cuero";
            case 3: return "Alcántara";
            default: return "Desconocido";
        }
    }

    /**
     * Obtiene el nombre del tipo de rueda configurado.
     * @return Nombre del tipo de rueda.
     */
    public String getNombreTipoRueda()
    {
        switch (tipoRueda) {
            case 1: return "Normal";
            case 2: return "Deportiva";
            case 3: return "Todoterreno";
            default: return "Desconocido";
        }
    }

    /**
     * Obtiene el nombre del tipo de vehículo configurado.
     * @return Nombre del tipo de vehículo.
     */
    public String getNombreTipoVehiculo()
    {
        switch (tipoVehiculo) {
            case 1: return "Biplaza Deportivo";
            case 2: return "Turismo";
            case 3: return "Furgoneta";
            default: return "Desconocido";
        }
    }

    // ---- Getters y Setters ----
    public int getNumero() { return numero; }
    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }
    public boolean isAveriada() { return averiada; }
    public void setAveriada(boolean averiada) { this.averiada = averiada; }
    public int getTiempoParada() { return tiempoParada; }
    public void setTiempoParada(int t) { this.tiempoParada = t; }
    public Vehiculo getVehiculoActual() { return vehiculoActual; }
    public void setVehiculoActual(Vehiculo v) { this.vehiculoActual = v; }
    public int getUnidadesPendientes() { return unidadesPendientes; }
    public void setUnidadesPendientes(int u) { this.unidadesPendientes = u; }
    public int getUnidadesCompletadas() { return unidadesCompletadas; }
    public void setUnidadesCompletadas(int u) { this.unidadesCompletadas = u; }
    public Operario[] getOperarios() { return operarios; }
    public int getTipoVehiculo() { return tipoVehiculo; }
    public int getTipoMotor() { return tipoMotor; }
    public int getTipoTapiceria() { return tipoTapiceria; }
    public int getTipoRueda() { return tipoRueda; }
    public int getProblemasReparados() { return problemasReparados; }
    public void incrementarProblemas() { problemasReparados++; }

    /**
     * Comprueba si hay trabajo pendiente en la cadena.
     * @return true si quedan unidades por producir o hay un vehículo en curso.
     */
    public boolean tieneTrabajoPendiente()
    {
        return unidadesPendientes > 0 || vehiculoActual != null;
    }

    /**
     * Decrementa el tiempo de parada y reactiva la cadena si llega a 0.
     */
    public void decrementarParada()
    {
        if (tiempoParada > 0) {
            tiempoParada--;
            if (tiempoParada == 0) {
                averiada = false;
            }
        }
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Cadena ").append(numero);
        sb.append(activa ? " [ACTIVA]" : " [INACTIVA]");
        if (averiada) sb.append(" [AVERIADA - Parada: ").append(tiempoParada).append("s]");
        sb.append(" | Vehículo: ").append(getNombreTipoVehiculo());
        sb.append(" | Pendientes: ").append(unidadesPendientes);
        sb.append(" | Completados: ").append(unidadesCompletadas);
        if (vehiculoActual != null) {
            sb.append(" | En curso: ").append(vehiculoActual.getEstado().getDescripcion());
        }
        return sb.toString();
    }
}
