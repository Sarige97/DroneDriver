package top.sarige;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.net.Socket;

public class ClientStart {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/SpringContext.xml");
        Socket bean = context.getBean(Socket.class);


    }
}
