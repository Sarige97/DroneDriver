package top.sarige;

import cn.hutool.core.io.file.FileReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientStart {

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/SpringContext.xml");
        Socket socket = context.getBean(Socket.class);
        OutputStream os = socket.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));

        String fileStr = new FileReader("test.xml").readString();
        writer.write(fileStr);
        writer.newLine();
        writer.flush();

    }
}
