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
public class DevolClass {
    
    private String solicitud;
    private String fechaD;
    private String horaD;
    private String nombresD;
    private String apellidosD;
    private String codBici;
    private String usuario;

    public DevolClass(String solicitud, String fechaD, String horaD, String nombresD, String apellidosD, String codBici, String usuario) {
        this.solicitud = solicitud;
        this.fechaD = fechaD;
        this.horaD = horaD;
        this.nombresD = nombresD;
        this.apellidosD = apellidosD;
        this.codBici = codBici;
        this.usuario = usuario;
    }
    
    public void devolucion() {
        try {
            File file = new File("control_devoluciones.txt");

            FileWriter archivo = new FileWriter(file.getAbsoluteFile(), true);

            String texto =  this.getSolicitud() + "," + this.getFechaD() + "," + this.getHoraD() + "," + this.getNombresD() + "," + this.getApellidosD() 
                    + "," + this.getCodBici() + "," + this.getUsuario(); 

            PrintWriter imprimir = new PrintWriter(archivo);
            imprimir.println(texto);

            archivo.close();
        } catch (IOException ex) {
            //Logger.getLogger(UsuarioJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Bicicleta recibida exitosamente");
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
     * @return the fechaD
     */
    public String getFechaD() {
        return fechaD;
    }

    /**
     * @param fechaD the fechaD to set
     */
    public void setFechaD(String fechaD) {
        this.fechaD = fechaD;
    }

    /**
     * @return the horaD
     */
    public String getHoraD() {
        return horaD;
    }

    /**
     * @param horaD the horaD to set
     */
    public void setHoraD(String horaD) {
        this.horaD = horaD;
    }

    /**
     * @return the nombresD
     */
    public String getNombresD() {
        return nombresD;
    }

    /**
     * @param nombresD the nombresD to set
     */
    public void setNombresD(String nombresD) {
        this.nombresD = nombresD;
    }

    /**
     * @return the apellidosD
     */
    public String getApellidosD() {
        return apellidosD;
    }

    /**
     * @param apellidosD the apellidosD to set
     */
    public void setApellidosD(String apellidosD) {
        this.apellidosD = apellidosD;
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
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
