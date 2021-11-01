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
public class BiciClass {
    
    private int codigoBici;
    private String Marca;
    private String Modelo;
    private String ruta;

    public BiciClass(int codigoBici, String Marca, String Modelo, String ruta) {
        this.codigoBici = codigoBici;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.ruta = ruta;
    }
    
    public void nuevaBici(){
        try {
            File file = new File("bicicletas.txt");

            FileWriter archivo = new FileWriter(file.getAbsoluteFile(), true);

            String texto =  getCodigoBici() + "," + getMarca() + "," + getModelo() + "," + getRuta();

            PrintWriter imprimir = new PrintWriter(archivo);
            imprimir.println(texto);

            archivo.close();
        } catch (IOException ex) {
            //Logger.getLogger(UsuarioJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Bicicleta creada exitosamente");
    }

    public int getCodigoBici() {
        return codigoBici;
    }

    public void setCodigoBici(int codigoBici) {
        this.codigoBici = codigoBici;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    /**
     * @return the ruta
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    
    
}
