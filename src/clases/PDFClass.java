package clases;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.property.VerticalAlignment;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel David Ortiz
 */
public class PDFClass {

    private String modulo;
    private int tipo;
    private String lblNombre;
    private String lblApellido;
    private String lblFirma;
    private String lblFirma2;
    private String ext;
    private String reporteRuta;
    private String reporte;
    private String archivoReporte;
    private String imagen;
    private int tipoR;
    private int columnas;
    Date date = new Date();

    public PDFClass(String modulo, int tipo) {
        this.modulo = modulo;
        this.tipo = tipo;
        tipoSD(tipo);
    }

    public void tipoSD(int tipo) {
        switch (tipo) {
            case 1: //Entrega
                this.lblNombre = "Nombres solicitante: ";
                this.lblApellido = "Apellidos solicitante: ";
                this.lblFirma = "Firma solicitante: ";
                this.ext = "E.png";
                break;
            case 2: //Devolucion
                this.lblNombre = "Nombres de quien devuelve: ";
                this.lblApellido = "Apellidos de quien devuelve: ";
                this.lblFirma = "Firma de quien devuelve: ";
                this.ext = "D.png";
                break;
            case 3: //ReporteBici
                this.tipoR = 1;
                this.reporteRuta = "Bicicletas/ReporteB.pdf";
                this.reporte = "bicicletas";
                this.archivoReporte = "bicicletas.txt";
                this.imagen = "bici.png";
                this.columnas = 3;
                break;
            case 4: //ReporteBici
                this.tipoR = 2;
                this.reporteRuta = "Entradas/ReporteE.pdf";
                this.reporte = "entradas";
                this.archivoReporte = "control_entregas.txt";
                this.imagen = "bici1.png";
                this.columnas = 9;
                break;
        }
    }

    public void pdfSolDev(String numero, String nombres, String apellidos, String marca, String modelo) {
        Locale locale = new Locale("es", "ES");

        String nombreArchivo = this.modulo + " " + numero + ".pdf";
        SimpleDateFormat DateFor = new SimpleDateFormat("EEEEE dd MMMMM yyyy HH:mm:ss");

        try {
            PdfDocument pdf = new PdfDocument(new PdfWriter("formularios/" + nombreArchivo));
            Document doc = new Document(pdf, new PageSize(612, 396));
            doc.setMargins(2, 20, 20, 20);

            Table table = new Table(UnitValue.createPercentArray(new float[]{1, 2}));
            table.addCell(createImageCell("images/QR/" + numero + this.ext));
            table.addCell(createTextCell(this.modulo + " No. " + numero + "\n Guatemala, " + DateFor.format(date)));

            Table table2 = new Table(UnitValue.createPercentArray(2));

            for (int i = 0; i < 2; i++) {
                table2.addCell(createTextCell(" "));
            }

            /*Image img1 = new Image(ImageDataFactory.create("images/QR/" + numero + ".png"));
            img1.setAutoScale(true);
            table2.addCell(img1);*/
            table2.addCell(createTextCell(this.lblNombre));
            table2.addCell(createTextCell(nombres));
            table2.addCell(createTextCell(this.lblApellido));
            table2.addCell(createTextCell(apellidos));
            //table2.addCell(createImageCell("images/QR/" + this.lblSolicitud.getText() + ".png"));
            table2.addCell(createTextCell("Bicicleta: "));
            table2.addCell(createTextCell(marca + " " + modelo));

            for (int i = 0; i < 4; i++) {
                table2.addCell(createTextCell(" "));
            }

            Table table3 = new Table(UnitValue.createPercentArray(4));
            table3.addCell(createTextCell(this.lblFirma));
            table3.addCell(createTextCell("___________________"));
            table3.addCell(createTextCell("Firma encargado: "));
            table3.addCell(createTextCell("___________________"));

            doc.add(table);
            doc.add(table2);
            doc.add(table3);

            doc.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Imprimir error " + e.getMessage());
        }

        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("formularios/" + nombreArchivo);
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                // no application registered for PDFs
            }
        }

    }

    public void reportes() {
        String[] u;

        String[] encabezadoB = {"Codigo", "Marca", "Modelo"};
        String[] encabezadoE = {"No Solicitud", "Fecha", "Hora", "Nombre", "Apellido", "Codigo", "Marca", "Modelo", "Usuario"};

        SimpleDateFormat DateFor = new SimpleDateFormat("EEEEE dd MMMMM yyyy HH:mm:ss");

        try {
            PdfDocument pdf = new PdfDocument(new PdfWriter("reportes/" + this.reporteRuta));
            Document doc = new Document(pdf);
            doc.setMargins(2, 20, 20, 20);

            Table tablaTitulo = new Table(UnitValue.createPercentArray(new float[]{1, 2}));
            tablaTitulo.addCell(createImageCell("src/images/" + this.imagen));
            tablaTitulo.addCell(createTextCell("Reporte de " + this.reporte + "\n Guatemala, " + DateFor.format(date)));

            for (int i = 0; i < 4; i++) {
                tablaTitulo.addCell(createTextCell(" "));
            }

            float[] pointColumnWidths = {150F, 150F, 150F};
            Table table = new Table(pointColumnWidths);

            //Tipo Reporte
            // Adding cells to the table       
            /*table.addCell(createTextCell("Codigo"));
            table.addCell(createTextCell("Marca"));
            table.addCell(createTextCell("Modelo"));*/
            File myObj = new File(this.archivoReporte);
            Scanner myReader = new Scanner(myObj);

            switch (tipoR) {
                case 1:
                    this.tablaTipoReporte(table, encabezadoB);
                    break;
                case 2:
                    this.tablaTipoReporte(table, encabezadoE);
                    break;
            }

            /*while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                u = data.split(",");

                table.addCell(createTextCell(u[0]));
                table.addCell(createTextCell(u[1]));
                table.addCell(createTextCell(u[2]));
            }*/
            //Tipo Reporte
            // Adding Table to document        
            doc.add(tablaTitulo);
            doc.add(table);

            // Closing the document       
            doc.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }

        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("reportes/" + this.reporte);
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                // no application registered for PDFs
            }
        }
    }

    private void tablaTipoReporte(Table table, String encabezado[]) {
        String[] u;
        try {
            for (int i = 0; i < encabezado.length; i++) {
                table.addCell(createTextCell(encabezado[i]));
            }

            /*table.addCell(createTextCell("Marca"));
            table.addCell(createTextCell("Modelo"));*/
            File myObj = new File(this.archivoReporte);
            Scanner myReader = new Scanner(myObj);

            /*for (int i = 0; i < u.length; i++) {
                String data = myReader.nextLine();
                u = data.split(",");
                table.addCell(createTextCell(u[0]));
            }*/
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                u = data.split(",");

                table.addCell(createTextCell(u[0]));
                table.addCell(createTextCell(u[1]));
                table.addCell(createTextCell(u[2]));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDFClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Cell createImageCell(String path) throws MalformedURLException {
        Image img = new Image(ImageDataFactory.create(path));
        img.setWidth(UnitValue.createPercentValue(100));
        Cell cell = new Cell().add(img);
        cell.setBorder(Border.NO_BORDER);
        return cell;
    }

    private static Cell createTextCell(String text) {
        Cell cell = new Cell();
        Paragraph p = new Paragraph(text);
        p.setTextAlignment(TextAlignment.RIGHT);
        cell.add(p).setVerticalAlignment(VerticalAlignment.BOTTOM);
        cell.setBorder(Border.NO_BORDER);

        return cell;
    }

}
