package top.sarige.communication.client;

import top.sarige.entity.Lighting;
import top.sarige.entity.Motor;
import top.sarige.entity.Moving;
import top.sarige.entity.Steering;

import java.util.List;

public class DefaultCommand implements Command {
    private Moving moving;
    private List<Lighting> lightingList;
    private List<Motor> motorList;
    private List<Steering> steeringList;

    public DefaultCommand() {
    }

    public DefaultCommand(Moving moving, List<Lighting> lightingList, List<Motor> motorList, List<Steering> steeringList) {
        this.moving = moving;
        this.lightingList = lightingList;
        this.motorList = motorList;
        this.steeringList = steeringList;
    }

    public Moving getMoving() {
        return moving;
    }

    public void setMoving(Moving moving) {
        this.moving = moving;
    }

    public List<Lighting> getLightingList() {
        return lightingList;
    }

    public void setLightingList(List<Lighting> lightingList) {
        this.lightingList = lightingList;
    }

    public List<Motor> getMotorList() {
        return motorList;
    }

    public void setMotorList(List<Motor> motorList) {
        this.motorList = motorList;
    }

    public List<Steering> getSteeringList() {
        return steeringList;
    }

    public void setSteeringList(List<Steering> steeringList) {
        this.steeringList = steeringList;
    }
}
