package cu.edu.cujae.services;

import java.sql.SQLException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


public class ReportServices {
	public static ReportServices reports = new ReportServices();

	private java.sql.Connection myConnection = null;

	public ReportServices() {
	 super();
	 try {
		this.myConnection = ServicesLocator.getConnection();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

    public  void CargarReporte_1(){
		try {
			JasperPrint print = JasperFillManager.fillReport("", null, myConnection);
			JasperViewer view = new JasperViewer(print, false);
			view.setVisible(true);
		} catch (JRException e2) {
			e2.printStackTrace();
		}
	}

    public  void CargarReporte_2(){
		try {
			JasperPrint print = JasperFillManager.fillReport("", null, myConnection);
			JasperViewer view = new JasperViewer(print, false);
			view.setVisible(true);
		} catch (JRException e2) {
			e2.printStackTrace();
		}
	}

    public  void CargarReporte_3(){
		try {
			JasperPrint print = JasperFillManager.fillReport("", null, myConnection);
			JasperViewer view = new JasperViewer(print, false);
			view.setVisible(true);
		} catch (JRException e2) {
			e2.printStackTrace();
		}
	}

    public  void CargarReporte_4(){
		try {
			JasperPrint print = JasperFillManager.fillReport("", null, myConnection);
			JasperViewer view = new JasperViewer(print, false);
			view.setVisible(true);
		} catch (JRException e2) {
			e2.printStackTrace();
		}
	}

    public  void CargarReporte_5(){
		try {
			JasperPrint print = JasperFillManager.fillReport("", null, myConnection);
			JasperViewer view = new JasperViewer(print, false);
			view.setVisible(true);
		} catch (JRException e2) {
			e2.printStackTrace();
		}
	}

    public  void CargarReporte_6(){
		try {
			JasperPrint print = JasperFillManager.fillReport("", null, myConnection);
			JasperViewer view = new JasperViewer(print, false);
			view.setVisible(true);
		} catch (JRException e2) {
			e2.printStackTrace();
		}
	}

    public  void CargarReporte_7(){
		try {
			JasperPrint print = JasperFillManager.fillReport("", null, myConnection);
			JasperViewer view = new JasperViewer(print, false);
			view.setVisible(true);
		} catch (JRException e2) {
			e2.printStackTrace();
		}
	}

    public  void CargarReporte_8(){
		try {
			JasperPrint print = JasperFillManager.fillReport("", null, myConnection);
			JasperViewer view = new JasperViewer(print, false);
			view.setVisible(true);
		} catch (JRException e2) {
			e2.printStackTrace();
		}
	}

    public  void CargarReporte_9(){
		try {
			JasperPrint print = JasperFillManager.fillReport("", null, myConnection);
			JasperViewer view = new JasperViewer(print, false);
			view.setVisible(true);
		} catch (JRException e2) {
			e2.printStackTrace();
		}
	}

    
}
