package runner;

import java.io.File;

import static controls.WaitElement.sleep;

public class FileUtils {
    public static boolean verifyFileContainsInDownloadDirectory(String fileName, String extension) {
        boolean flag = false;
        try {
            String pathFolderDownload = Constants.DOWNLOAD_PATH;
            File dir = new File(pathFolderDownload);
            File[] files = dir.listFiles();
            if (files == null || files.length == 0) {
                return false;
            }
            for (File file : files) {
                if (file.getName().contains(fileName) && file.getName().endsWith("." + extension)) {
                    return true;
                }
            }
            return flag;
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
            return flag;
        }
    }

    public static boolean verifyFileEqualsInDownloadDirectory(String fileName) {
        boolean flag = false;
        try {
            String pathFolderDownload = Constants.DOWNLOAD_PATH;
            File dir = new File(pathFolderDownload);
            File[] files = dir.listFiles();
            if (files == null || files.length == 0) {
                return false;
            }

            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    flag = true;
                }
            }
            return flag;
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
            return flag;
        }
    }

    public static Boolean verifyDownloadFileContainsNameCompletedWaitTimeout(String fileName, String extension, int timeoutSeconds) {
        boolean check = false;
        int i = 0;
        while (i < timeoutSeconds) {
            boolean exist = verifyFileContainsInDownloadDirectory(fileName, extension);
            if (exist) {
                i = timeoutSeconds;
                return true;
            }
            sleep(1);
            i++;
        }
        return check;
    }


    public static Boolean verifyDownloadFileEqualsNameCompletedWaitTimeout(String fileName, int timeoutSeconds) {
        boolean check = false;
        int i = 0;
        while (i < timeoutSeconds) {
            boolean exist = verifyFileEqualsInDownloadDirectory(fileName);
            if (exist) {
                i = timeoutSeconds;
                return true;
            }
            sleep(1);
            i++;
        }
        return check;
    }

    public static void deleteAllFileInDownloadDirectory() {
        try {
            String pathFolderDownload = Constants.DOWNLOAD_PATH;
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();

            for (File listOfFile : listOfFiles) {
                if (listOfFile.isFile()) {
                    new File(listOfFile.toString()).delete();
                }
            }
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
