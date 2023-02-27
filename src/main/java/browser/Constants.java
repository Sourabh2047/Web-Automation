package browser;

import java.io.File;

public class Constants {
    /**
     * The Constant WORKING_DIRECTORY.
     */
    public static final String WORKING_DIRECTORY = System.getProperty("user.dir");

    /**
     * The Constant REPORT_DIRECTORY.
     */
    public final static String REPORT_DIRECTORY = WORKING_DIRECTORY + "/ExtentReports/AutomationResult.html";

    /**
     * The Constant PROJECT_NAME.
     */
    public final static String PROJECT_NAME = "Enveu";

    /**
     * The Constant EXTENT_CONFIG_PATH.
     */
    public final static String EXTENT_CONFIG_PATH = WORKING_DIRECTORY + "/src/main/resources/config/extent-config.xml";

    /**
     * The Constant PROPERTY_FILE_PATH.
     */
    public final static String PROPERTY_FILE_PATH = WORKING_DIRECTORY + "/src/main/resources/config/test.properties";

    /**
     * The Constant CHROME_DRIVER_PATH.
     */
    public final static String CHROME_DRIVER_PATH = WORKING_DIRECTORY + "/src/test/resources/drivers/chromedriver.exe";

    /**
     * This will contains Test Data for test case
     */
    public final static String TEST_DATA_PATH = WORKING_DIRECTORY
            + File.separator + "src" + File.separator + "main" + File.separator + "resources"
            + File.separator + "Data" + File.separator + "ObjectRepo.json";

}