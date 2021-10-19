/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel David Ortiz
 */
public class UsuarioClass {
    private String usuario;
    private String codigo;
    private String contraseña1;
    private String contraseña2;
    private String DPI;

    public String claveMurci(String texto) {
        texto = texto.replace('m', '0');
        texto = texto.replace('M', '0');
        texto = texto.replace('u', '1');
        texto = texto.replace('U', '1');
        texto = texto.replace('r', '2');
        texto = texto.replace('R', '2');
        texto = texto.replace('c', '3');
        texto = texto.replace('C', '3');
        texto = texto.replace('i', '4');
        texto = texto.replace('I', '4');
        texto = texto.replace('e', '5');
        texto = texto.replace('E', '5');
        texto = texto.replace('l', '6');
        texto = texto.replace('L', '6');
        texto = texto.replace('a', '7');
        texto = texto.replace('A', '7');
        texto = texto.replace('g', '8');
        texto = texto.replace('G', '8');
        texto = texto.replace('o', '9');
        texto = texto.replace('O', '9');
        return texto;
    }

    public void nuevoUsuario(String codigo, String nombres, String apellidos, String dpi, String usuario, 
            String pass1, String pass2) {
        //String usuario, String email, String contraseña1,  String contraseña2){
        try {
            File file = new File("usuarios.txt");

            FileWriter archivo = new FileWriter(file.getAbsoluteFile(), true);

            String texto =  codigo + "," + nombres + "," + apellidos + "," + dpi + "," +claveMurci(usuario) + "," + 
                    claveMurci(pass1) + "," + claveMurci(pass2);

            PrintWriter imprimir = new PrintWriter(archivo);
            imprimir.println(texto);

            archivo.close();
        } catch (IOException ex) {
            //Logger.getLogger(UsuarioJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");
    }

    public boolean validarUsuario(String usuario, String contraseña) {
        String[] u;
        boolean isLogin = false;
        try {
            File myObj = new File("usuarios.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                u = data.split(",");
                if(u[1].equals(claveMurci(usuario)) && u[2].equals(claveMurci(contraseña))){
                    isLogin = true;
                    //FrmJuego juego = new FrmJuego();
                    //JOptionPane.showMessageDialog(null, "A jugar");
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        return isLogin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña1() {
        return contraseña1;
    }

    public void setContraseña1(String contraseña1) {
        this.contraseña1 = contraseña1;
    }

    public String getContraseña2() {
        return contraseña2;
    }

    public void setContraseña2(String contraseña2) {
        this.contraseña2 = contraseña2;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }
    
    
}
