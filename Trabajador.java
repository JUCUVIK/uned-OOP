/**
 * Clase abstracta que representa un trabajador de la fábrica.
 * Contiene los datos personales comunes a todos los perfiles.
 * 
 * Subclases: Operario, GestorPlanta, AdministradorSistema, MecanicoCinta
 * 
 * @author Sergio Cuadrado Hernández

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

    public String getNombreCompleto()
    {
        return nombre + " " + apellidos;
    }

    public abstract String getPerfil();

    public String toString()
    {
        return getPerfil() + ": " + getNombreCompleto() + " (DNI: " + dni + ")";
    }
}
