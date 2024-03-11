package genericLibraries;

/**
 * This interface contains the external file paths and JDBC url
 * 
 * @author jyoth
 *
 */
public interface IConstantPath {
	String PROPERTIES_PATH = "./src/test/resources/commonData.properties";
	String EXCEL_PATH = "./src/test/resources/VtigerCRMTestData.xlsx";
	String JDBC_URL = "jdbc:mysql://localhost:3306/advselenium";
}
