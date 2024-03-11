package data;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Random;

import static javax.swing.UIManager.get;

public class DataPlacement {

    //search user
    public static final String TEXTSEARCHUSER = "Alice.Duval";

    //change information
    public static final String FIRSTNAME = "cristiano";
    public static final String MIDDLENAME = "ronaldo";
    public static final String LASTNAME = "jr";
    public static final String NICKNAME = "cr7";
    public static final String EMPLOYEEID = "85116";
    public static final String OTHERID = "85080";
    public static final String LICENSENNUMBER = "85081";
    public static final String LICENSEEXPIRYDATE = "2023-01-22";
    public static final String SSNNUMBER = "85082";
    public static final String SINNUMBER = "85083";
    public static final String NATIONALY = "Afghan";
    public static final String MARITALSTATUS = "Single";
    public static final String MALE = "Male";
    public static final String FEMALE = "Female";
    public static final String DATEOFBIRTH = "2023-02-22";
    public static final String MILLITARYSERVICE = "15";

    //share photo
    public static final String IMAGE = "\\src\\test\\resources\\file\\imageTest.jpg";
    public static final String TEXTCONTENT = "ATS Test Upload File";
    //add user
    public static final String TEXTADDUSER = "Alice.Duval"+(int)Math.floor(Math.random() * (50 - 2 + 1) + 2) ;
    public static final String EMPLOYMENTNAME = "a";
    public static final String PASS = "admin123";
    public static final String CONFIRMPASS = "admin123";


    //download
    public static final String FOLDER_DOWNLOAD = System.getProperty("user.dir")+"/src/test/resources/downloads";
    public static final String FILE_DOWNLOAD = System.getProperty("user.dir")+"/src/test/resources/downloads/resume.pdf";
    public static final String NAMESEARCH="Phil";

    //Testcase6
    public static final String COLOR="rgb(226, 38, 77)";

}
