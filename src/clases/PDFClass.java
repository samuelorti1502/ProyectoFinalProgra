package clases;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.*;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.*;;
import java.util.logging.*;
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
    private String ext;
    private String reporteRuta;
    private String reporte;
    private String archivoReporte;
    private String imagen;
    private int tipoR;
    private int columnas;
    private float pointColumnWidths[];
    Date date = new Date();

    public PDFClass(String modulo, int tipo) {
        this.modulo = modulo;
        this.tipo = tipo;
        tipoSD(tipo);
    }

    public void tipoSD(int tipo) {
        SimpleDateFormat DateFor = new SimpleDateFormat("yyyyMMddHHmm");

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
                this.reporteRuta = "Bicicletas/ReporteB" + DateFor.format(date) + ".pdf";
                this.reporte = "bicicletas";
                this.archivoReporte = "bicicletas.txt";
                this.imagen = "bici.png";
                this.columnas = 4;
                this.pointColumnWidths = new float[columnas];

                for (int i = 0; i < this.columnas; i++) {
                    this.pointColumnWidths[i] = 150F;
                    System.out.println(this.pointColumnWidths[i]);
                }

                break;
            case 4: //ReporteEntregas
                this.tipoR = 2;
                this.reporteRuta = "Entregas/ReporteE" + DateFor.format(date) + ".pdf";
                this.reporte = "entregas";
                this.archivoReporte = "control_entregas.txt";
                this.imagen = "bici1.png";
                this.columnas = 9;
                this.pointColumnWidths = new float[columnas];

                for (int i = 0; i < this.columnas; i++) {
                    this.pointColumnWidths[i] = 150F;
                }

                break;
            case 5: //ReporteDevoluciones
                this.tipoR = 2;
                this.reporteRuta = "Devoluciones/ReporteD" + DateFor.format(date) + ".pdf";
                this.reporte = "devoluciones";
                this.archivoReporte = "control_devoluciones.txt";
                this.imagen = "bici2.png";
                this.columnas = 7;
                this.pointColumnWidths = new float[columnas];

                for (int i = 0; i < this.columnas; i++) {
                    this.pointColumnWidths[i] = 150F;
                }

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

            table2.addCell(createTextCell(this.lblNombre));
            table2.addCell(createTextCell(nombres));
            table2.addCell(createTextCell(this.lblApellido));
            table2.addCell(createTextCell(apellidos));
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

    public void reportes(String[] encabezado) {
        System.out.println("Columnas " + this.pointColumnWidths);
        String[] u;

        SimpleDateFormat DateFor = new SimpleDateFormat("EEEEE dd MMMMM yyyy HH:mm:ss");

        try {
            PdfDocument pdf = new PdfDocument(new PdfWriter("reportes/" + this.reporteRuta));
            Document doc = new Document(pdf, PageSize.A4.rotate());
            doc.setMargins(2, 20, 20, 20);

            Table tablaTitulo = new Table(UnitValue.createPercentArray(new float[]{1, 2}));
            tablaTitulo.addCell(createImageCell("src/images/" + this.imagen));
            tablaTitulo.addCell(createTextCell("Reporte de " + this.reporte + "\n Guatemala, " + DateFor.format(date)));

            for (int i = 0; i < 4; i++) {
                tablaTitulo.addCell(createTextCell(" "));
            }

            Table table = new Table(this.pointColumnWidths);

            this.tablaTipoReporte(table, encabezado);
            
            doc.add(tablaTitulo);
            doc.add(table);

            // Closing the document       
            doc.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }

        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("reportes/" + this.reporteRuta);
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

            File myObj = new File(this.archivoReporte);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                u = data.split(",");

                for (int i = 0; i < u.length; i++) {
                    table.addCell(createTextCell(u[i]));
                }
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
