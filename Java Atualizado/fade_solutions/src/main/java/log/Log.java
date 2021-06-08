/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log;

/**
 *
 * @author guilh
 */
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 *
 * @author guilh
 */
public class Log {

    public static void main(String[] args) throws IOException {
        String quebralinha = "--------------------------------------------";
        String dataHora = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        String returntxt = ": Erro";
        FileOutputStream fos = new FileOutputStream(returntxt + "log1.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        
        bw.write(quebralinha);
        bw.newLine();
        bw.write(dataHora);
        bw.write(returntxt);
        bw.newLine();
        bw.write(quebralinha);
        bw.newLine();
        bw.close();
        
        FileInputStream fis = new FileInputStream(returntxt + "log1.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        
        String texto = br.readLine();
        while (texto != null) {
            System.out.println(texto);
            texto = br.readLine();
        }
        br.close();
    }
}

