package cu.edu.cujae.services;

import java.io.File;
import java.sql.SQLException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


public class ReportServices {
  public static ReportServices reports = new ReportServices();

  private java.sql.Connection myConnection = null;

  public ReportServices() {
   super();
   try {
    this.myConnection = ServicesLocator.getConexion();
  } catch (SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
  }
  }

    public  void CargarReporte_1(){
      try {   
            final File file = new File(new File("").getAbsolutePath() + "/src/New folder/Report1.jrxml");
            final JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null,myConnection);
            final JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            //jasperViewer.setTitle("");
            jasperViewer.setVisible(true);
           
  } catch (Exception e2) {
    e2.printStackTrace(); 
    //JOptionPane.showMessageDialog(null, "Error"+e2,"Error",JOptionPane.ERROR_MESSAGE);
  }
    /*try {
      JasperPrint print = JasperFillManager.fillReport("D:\\Proyectos\\Java\\Final Project Repository\\RentACar\\src\\reports\\Report1.jasper", null, myConnection);
      JasperViewer view = new JasperViewer(print, false);
      view.setVisible(true);
    } catch (JRException e2) {
      e2.printStackTrace();
    }*/
  }

    public  void CargarReporte_2(){
    /*try {
      JasperPrint print = JasperFillManager.fillReport("D:\\Proyectos\\Java\\Final Project Repository\\RentACar\\src\\reports\\Report2.jasper", null, myConnection);
      JasperViewer view = new JasperViewer(print, false);
      view.setVisible(true);
    } catch (JRException e2) {
      e2.printStackTrace();
    }*/
    	      try {   
    	            final File file = new File(new File("").getAbsolutePath() + "/src/New folder/Report2.jrxml");
    	            final JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
    	            final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null,myConnection);
    	            final JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
    	            //jasperViewer.setTitle("");
    	            jasperViewer.setVisible(true);
    	           
    	  } catch (Exception e2) {
    	    e2.printStackTrace(); 
    	    //JOptionPane.showMessageDialog(null, "Error"+e2,"Error",JOptionPane.ERROR_MESSAGE);
    	  }
  }

    public  void CargarReporte_3(){
    /*try {
      JasperPrint print = JasperFillManager.fillReport("D:\\Proyectos\\Java\\Final Project Repository\\RentACar\\src\\reports\\Report3.jasper", null, myConnection);
      JasperViewer view = new JasperViewer(print, false);
      view.setVisible(true);
    } catch (JRException e2) {
      e2.printStackTrace();
    }*/
    	try {   
            final File file = new File(new File("").getAbsolutePath() + "/src/New folder/Report3.jrxml");
            final JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null,myConnection);
            final JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            //jasperViewer.setTitle("");
            jasperViewer.setVisible(true);
           
  } catch (Exception e2) {
    e2.printStackTrace(); 
    //JOptionPane.showMessageDialog(null, "Error"+e2,"Error",JOptionPane.ERROR_MESSAGE);
  }
  }

    public  void CargarReporte_4(){
    /*try {
      JasperPrint print = JasperFillManager.fillReport("D:\\Proyectos\\Java\\Final Project Repository\\RentACar\\src\\reports\\Report4.jasper", null, myConnection);
      JasperViewer view = new JasperViewer(print, false);
      view.setVisible(true);
    } catch (JRException e2) {
      e2.printStackTrace();
    }*/
    	try {   
            final File file = new File(new File("").getAbsolutePath() + "/src/New folder/Report4.jrxml");
            final JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null,myConnection);
            final JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            //jasperViewer.setTitle("");
            jasperViewer.setVisible(true);
           
  } catch (Exception e2) {
    e2.printStackTrace(); 
    //JOptionPane.showMessageDialog(null, "Error"+e2,"Error",JOptionPane.ERROR_MESSAGE);
  }
  }

    public  void CargarReporte_5(){
    /*try {
      JasperPrint print = JasperFillManager.fillReport("D:\\Proyectos\\Java\\Final Project Repository\\RentACar\\src\\reports\\Report5.jasper", null, myConnection);
      JasperViewer view = new JasperViewer(print, false);
      view.setVisible(true);
    } catch (JRException e2) {
      e2.printStackTrace();
    }*/
    	try {   
            final File file = new File(new File("").getAbsolutePath() + "/src/New folder/Report5.jrxml");
            final JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null,myConnection);
            final JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            //jasperViewer.setTitle("");
            jasperViewer.setVisible(true);
           
  } catch (Exception e2) {
    e2.printStackTrace(); 
    //JOptionPane.showMessageDialog(null, "Error"+e2,"Error",JOptionPane.ERROR_MESSAGE);
  }
  }

    public  void CargarReporte_6(){
    /*try {
      JasperPrint print = JasperFillManager.fillReport("D:\\Proyectos\\Java\\Final Project Repository\\RentACar\\src\\reports\\Report6.jasper", null, myConnection);
      JasperViewer view = new JasperViewer(print, false);
      view.setVisible(true);
    } catch (JRException e2) {
      e2.printStackTrace();
    }*/
    	try {   
            final File file = new File(new File("").getAbsolutePath() + "/src/New folder/Report6.jrxml");
            final JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null,myConnection);
            final JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            //jasperViewer.setTitle("");
            jasperViewer.setVisible(true);
           
  } catch (Exception e2) {
    e2.printStackTrace(); 
    //JOptionPane.showMessageDialog(null, "Error"+e2,"Error",JOptionPane.ERROR_MESSAGE);
  }
  }

    public  void CargarReporte_7(){
    	try {   
            final File file = new File(new File("").getAbsolutePath() + "/src/New folder/Report7.jrxml");
            final JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null,myConnection);
            final JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            //jasperViewer.setTitle("");
            jasperViewer.setVisible(true);
           
  } catch (Exception e2) {
    e2.printStackTrace(); 
    //JOptionPane.showMessageDialog(null, "Error"+e2,"Error",JOptionPane.ERROR_MESSAGE);
  }
    /*try {
      JasperPrint print = JasperFillManager.fillReport("D:\\Proyectos\\Java\\Final Project Repository\\RentACar\\src\\reports\\Report7.jasper", null, myConnection);
      JasperViewer view = new JasperViewer(print, false);
      view.setVisible(true);
    } catch (JRException e2) {
      e2.printStackTrace();
    }*/
  }
    public  void CargarReporte_8(){
        /*try {
          JasperPrint print = JasperFillManager.fillReport("D:\\Proyectos\\Java\\Final Project Repository\\RentACar\\src\\reports\\Report8.jasper", null, myConnection);
          JasperViewer view = new JasperViewer(print, false);
          view.setVisible(true);
        } catch (JRException e2) {
          e2.printStackTrace();
        }*/
    	try {   
            final File file = new File(new File("").getAbsolutePath() + "/src/New folder/Report8.jrxml");
            final JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null,myConnection);
            final JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            //jasperViewer.setTitle("");
            jasperViewer.setVisible(true);
           
  } catch (Exception e2) {
    e2.printStackTrace(); 
    //JOptionPane.showMessageDialog(null, "Error"+e2,"Error",JOptionPane.ERROR_MESSAGE);
  }
      }

        public  void CargarReporte_9(){
        /*try {
          JasperPrint print = JasperFillManager.fillReport("D:\\Proyectos\\Java\\Final Project Repository\\RentACar\\src\\reports\\Report9.jasper", null, myConnection);
          JasperViewer view = new JasperViewer(print, false);
          view.setVisible(true);
        } catch (JRException e2) {
          e2.printStackTrace();
        }*/
        	try {   
	            final File file = new File(new File("").getAbsolutePath() + "/src/New folder/Report9.jrxml");
	            final JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
	            final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null,myConnection);
	            final JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
	            //jasperViewer.setTitle("");
	            jasperViewer.setVisible(true);
	           
	  } catch (Exception e2) {
	    e2.printStackTrace(); 
	    //JOptionPane.showMessageDialog(null, "Error"+e2,"Error",JOptionPane.ERROR_MESSAGE);
	  }
      }

        
    }
