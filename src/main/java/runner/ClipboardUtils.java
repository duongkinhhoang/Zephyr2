package runner;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static controls.WaitElement.sleep;
import static runner.Constants.DEFAULT_WAIT_TIME;

public class ClipboardUtils {
    private static String getData() {
        String data = null;
        try {
            data = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static Boolean verifyClipboardContainsText(String expectedText) {
        int i = 0;
        while (i < DEFAULT_WAIT_TIME) {
            boolean exist = getData().contains(expectedText);

            if (exist) {
                System.out.println("[info] clipboard " + ClipboardUtils.getData());
                return true;
            }
            sleep(1);
            i++;
        }

        return ClipboardUtils.getData().contains(expectedText);
    }

    public static Boolean verifyClipboardNotContainsText(String expectedText) {
        return ClipboardUtils.getData().contains(expectedText);
    }
}
