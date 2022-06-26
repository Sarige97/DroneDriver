package top.sarige;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerStart {

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/SpringContext.xml");
        ServerSocket serverSocket = context.getBean(ServerSocket.class);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        try {
            while (true) {
                String str = reader.readLine();

                System.out.println(str);
            }
        } catch (IOException e) {
            System.out.println("Socket连接已断开");
            System.out.println(e.getMessage());
        }
    }
}
