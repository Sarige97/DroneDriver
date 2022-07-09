package top.sarige;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.sarige.communication.client.CommandParser;
import top.sarige.communication.client.DefaultCommand;
import top.sarige.communication.client.DefaultCommandParser;
import top.sarige.entity.Motor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ServerStart {

    CommandParser commandParser;

    public ServerStart(CommandParser commandParser) {
        this.commandParser = commandParser;
    }

    public static void main(String[] args) throws IOException {
        ServerStart serverStart = new ServerStart(new DefaultCommandParser());
        serverStart.run();

    }

    public void run() throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/SpringContext.xml");
        ServerSocket serverSocket = context.getBean(ServerSocket.class);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        try {
            StringBuilder commandStrBuilder = new StringBuilder();
            while (true) {
                String str = reader.readLine();
                commandStrBuilder.append(str);
                if (str.trim().equals("</cmd>")) {
                    DefaultCommand command = (DefaultCommand) commandParser.parseCommand(commandStrBuilder.toString());
                    List<Motor> motorList = command.getMotorList();
                    for (Motor motor : motorList) {
                        System.out.println(motor);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Socket连接已断开");
            System.out.println(e.getMessage());
        }
    }

}
