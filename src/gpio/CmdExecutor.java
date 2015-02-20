/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gpio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Michi
 */
public class CmdExecutor {

    protected static String execute(String[] cmd) {
        StringBuffer output = new StringBuffer();

        Process p;
        try {
            p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

        } catch (IOException | InterruptedException e) {
        }

        return output.toString();
    }

    protected static String execute(String cmd) {
        StringBuffer output = new StringBuffer();

        Process p;
        try {
            p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader err = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            String errLine = "";
            while ((errLine = err.readLine()) != null) {
                output.append(errLine).append("\n");
            }
        } catch (IOException | InterruptedException e) {
        }

        return output.toString();
    }
}
