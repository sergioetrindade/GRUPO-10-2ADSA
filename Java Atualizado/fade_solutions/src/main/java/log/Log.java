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
import org.joda.time.format.DateTimeFormat;

import java.io.*;
import java.net.InetAddress;

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.LocalDateTime;
import slack.Slack;


/**
 *
 * @author guilh
 */
public class Log {

   

    public static void criarLogs(Exception ex){
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("ddMMyyyyHHmmss");
        String str = date.toString(fmt);

        try {
            FileOutputStream fos = new FileOutputStream(str + "-Log.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            PrintWriter bw = new PrintWriter(osw);
            bw.write("--------------------------------------------");
            bw.println();
            bw.write("--------------------------------------------");
            bw.println();
            bw.write("Hostname:");
            bw.write(InetAddress.getLocalHost().getHostName());
            bw.println();
//            bw.write(login);
//            bw.newLine();
            bw.write("ERRO:");
//            bw.write();
            ex.printStackTrace(bw);
            bw.println();
            bw.write("--------------------------------------------");
            bw.println();
            bw.write("--------------------------------------------");
            bw.close();
            FileInputStream fis = new FileInputStream(str + "-Log.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String linha = br.readLine();

            while(linha != null){
                System.out.println(linha);
                linha = br.readLine();
            }

            br.close();
            Slack.EnviarMensagem("A maquina de hostname:" + InetAddress.getLocalHost().getHostName());
            Slack.EnviarMensagem("ERRO NO SISTEMA: Confira o LOG");
        }catch (Exception e){
            e.printStackTrace();
        }

}
}

