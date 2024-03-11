package runner;

//import helpers.PropertiesHelper;

import java.io.File;

public class Constants {
    public static final String WORKING_DIRECTORY = System.getProperty("user.dir");
    public static final String DOWNLOAD_PATH = WORKING_DIRECTORY + "/src/test/resources/downloads".replace("/", File.separator);
    public static final String FILE_DOWNLOAD = WORKING_DIRECTORY + "/src/test/resources/downloads/resume.pdf".replace("/", File.separator);

    public static final int DEFAULT_WAIT_TIME = 10;
    public static final int WAIT_PAGE_LOADED = 40;

    public static int COUNTlIKE;
}
