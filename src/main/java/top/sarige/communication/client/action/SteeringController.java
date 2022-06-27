package top.sarige.communication.client.action;

import top.sarige.communication.client.Command;

public interface SteeringController extends CommandExecutor {

    void execute(Command command);

}
