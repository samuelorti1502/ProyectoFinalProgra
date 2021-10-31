package clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel David Ortiz
 */
public class EntregaClass {

    private String solicitud;
    private String fecha;
    private String hora;
    private String nombres;
    private String apellidos;
    private String codBici;
    private String marca;
    private String modelo;

    public EntregaClass(String solicitud, String fecha, String hora, String nombres, String apellidos, String codBici, String marca, String modelo) {
        this.solicitud = solicitud;
        this.fecha = fecha;
        this.hora = hora;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.codBici = codBici;
        this.marca = marca;
        this.modelo = modelo;
    }
    
    public void entrega() {
        try {
            File file = new File("control_entregas.txt");

            FileWriter archivo = new FileWriter(file.getAbsoluteFile(), true);

            String texto =  this.getSolicitud() + "," + this.getFecha() + "," + this.getHora() + "," + this.getNombres() + "," + this.getApellidos()
                    + "," + this.getCodBici() + "," + this.getMarca() + "," + this.getModelo();

            PrintWriter imprimir = new PrintWriter(archivo);
            imprimir.println(texto);

            archivo.close();
        } catch (IOException ex) {
            //Logger.getLogger(UsuarioJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Bicicleta entregada exitosamente");
    }

    /**
     * @return the solicitud
     */
    public String getSolicitud() {
        return solicitud;
    }

    /**
     * @param solicitud the solicitud to set
     */
    public void setSolicitud(String solicitud) {
        this.solicitud = solicitud;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the codBici
     */
    public String getCodBici() {
        return codBici;
    }

    /**
     * @param codBici the codBici to set
     */
    public void setCodBici(String codBici) {
        this.codBici = codBici;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
