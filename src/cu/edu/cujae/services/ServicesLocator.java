package cu.edu.cujae.services;

import java.sql.SQLException;

import cu.edu.cujae.utils.Connec;

public class ServicesLocator {

	private static TouristServices touristServices = null;
    private static CarServices carServices = null;
    private static DriverServices driverServices = null;
    private static ContractServices contractServices = null;
    private static UserServices userServices = null;
    private static BrandServices brandServices = null;
    private static CountryServices countryServices = null;
    private static ModelServices modelServices = null;
    private static PayMethodServices payMethodServices = null;
    private static LicenseServices licenseServices = null;
    private static SituationServices situationServices = null;
    private static ReportServices reportServices = null;


    public static TouristServices getTouristServices() {
        if (touristServices == null) {
            touristServices = new TouristServices();
        }
        return touristServices;
    }

    public static CarServices getCarServices() {
        if (carServices == null) {
            carServices = new CarServices();
        }
        return carServices;
    }

    public static DriverServices getDriverServices() {
        if (driverServices == null) {
            driverServices = new DriverServices();
        }
        return driverServices;
    }

    public static ContractServices getContractsServices() {
        if (contractServices == null) {
            contractServices = new ContractServices();
        }
        return contractServices;
    }

    public static UserServices getUserServices() {
        if (userServices == null) {
            userServices = new UserServices();
        }
        return userServices;
    }

    public static BrandServices getBrandServices() {
        if (brandServices == null) {
            brandServices = new BrandServices();
        }
        return brandServices;
    }
    
    public static ModelServices getModelServices() {
        if (modelServices == null) {
            modelServices = new ModelServices();
        }
        return modelServices;
    }
    
    public static SituationServices getSituationServices() {
        if (situationServices == null) {
            situationServices = new SituationServices();
        }
        return situationServices;
    }
    
    public static LicenseServices getLicenseServices() {
        if (licenseServices == null) {
            licenseServices = new LicenseServices();
        }
        return licenseServices;
    }
    
    public static PayMethodServices getPayMethodServices() {
        if (payMethodServices == null) {
            payMethodServices = new PayMethodServices();
        }
        return payMethodServices;
    }
    
    public static CountryServices getCountryServices() {
        if (countryServices == null) {
            countryServices = new CountryServices();
        }
        return countryServices;
    }

    public static ReportServices getReportServices() {
        if (reportServices == null) {
            reportServices = new ReportServices();
        }
        return reportServices;
    }
    
    public static java.sql.Connection getConnection() {
		Connec connection = null;
		try {
			connection = new Connec("localhost", "JDBC","postgres", "postgres");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection.getConnection();
	}
    
}


