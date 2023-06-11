/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Relatorio;

import java.sql.Connection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.ReportContext;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.ExporterConfiguration;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.ExporterOutput;
import net.sf.jasperreports.export.ReportExportConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Rony
 */
public class GerarRelatorio{
 private Connection conexao = null;
    

    public Connection getConexao() {
        return conexao;
    }
    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    public GerarRelatorio(Connection conexao) {
        this.conexao = conexao;
    }
   
  public void print_report(String tipo_report){
      HashMap hma = new HashMap();
      var filename = tipo_report.equals("categoria")? "src/main/java/Cherry.jrxml": "src/main/java/Cherry.jrxml";
      String outFileName = "src/main/java/teste1.pdf";
      JasperReport jasperReport;
        try {
            jasperReport = JasperCompileManager.compileReport(filename);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hma, this.getConexao());
            
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outFileName));
            
            SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
            exporter.setConfiguration(configuration);

            exporter.exportReport();
        } catch (JRException ex) {
            Logger.getLogger(GerarRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
      
  }    

    public void previewReport(String start_date, String end_date) throws JRException {
         HashMap hma = new HashMap();
         hma.put("START_DATE", start_date);
         hma.put("END_DATE", end_date);
        JasperReport jasperReport = JasperCompileManager.compileReport("src/main/java/Cherry.jrxml");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hma, this.getConexao());
        JasperViewer jasperView = new JasperViewer(jasperPrint, false);
        jasperView.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        jasperView.setVisible(true);
    }
}
