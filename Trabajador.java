/**
 * Clase abstracta que representa un trabajador de la fábrica.
 * Contiene los datos personales comunes a todos los perfiles.
 * 
 * Subclases: Operario, GestorPlanta, AdministradorSistema, MecanicoCinta
 * 
 * @author Estudiante UNED
 * @version 1.0
 */
public abstract class Trabajador
{
    private String nombre;
    private String apellidos;
    private String dni;
    private String direccion;
    private String numSeguridadSocial;
    private String puesto;
    private double salario;
    private String fechaIngreso;

    /**
     * Constructor de Trabajador.
     * @param nombre Nombre del trabajador.
     * @param apellidos Apellidos del trabajador.
     * @param dni DNI del trabajador.
     * @param direccion Dirección del trabajador.
     * @param numSeguridadSocial Número de la Seguridad Social.
     * @param puesto Puesto que desempeña.
     * @param salario Salario del trabajador.
     * @param fechaIngreso Fecha de ingreso en la fábrica.
     */
    public Trabajador(String nombre, String apellidos, String dni,
                      String direccion, String numSeguridadSocial,
                      String puesto, double salario, String fechaIngreso)
    {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion = direccion;
        this.numSeguridadSocial = numSeguridadSocial;
        this.puesto = puesto;
        this.salario = salario;
        this.fechaIngreso = fechaIngreso;
    }

    // ---- Getters ----
    public String getNombre() { return nombre; }
    public String getApellidos() { return apellidos; }
    public String getDni() { return dni; }
    public String getDireccion() { return direccion; }
    public String getNumSeguridadSocial() { return numSeguridadSocial; }
    public String getPuesto() { return puesto; }
    public double getSalario() { return salario; }
    public String getFechaIngreso() { return fechaIngreso; }

    // ---- Setters ----
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public void setDni(String dni) { this.dni = dni; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setNumSeguridadSocial(String nss) { this.numSeguridadSocial = nss; }
    public void setPuesto(String puesto) { this.puesto = puesto; }
    public void setSalario(double salario) { this.salario = salario; }
    public void setFechaIngreso(String fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    /**
     * Devuelve el nombre completo del trabajador.
     * @return Nombre y apellidos.
     */
    public String getNombreCompleto()
    {
        return nombre + " " + apellidos;
    }

    /**
     * Método abstracto que devuelve el perfil del trabajador.
     * @return Perfil del trabajador.
     */
    public abstract String getPerfil();

    public String toString()
    {
        return getPerfil() + ": " + getNombreCompleto() + " (DNI: " + dni + ")";
    }
}
