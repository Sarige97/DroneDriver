package top.sarige.communication.client;

import top.sarige.communication.client.action.LightingController;
import top.sarige.communication.client.action.MovingController;
import top.sarige.communication.client.action.SteeringController;

public class AbstractDroneController implements DroneController {

    MovingController movingController;
    SteeringController steeringController;
    LightingController lightingController;

}
