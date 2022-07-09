package top.sarige.communication.client;

import org.dom4j.*;
import top.sarige.entity.Lighting;
import top.sarige.entity.Motor;
import top.sarige.entity.Moving;
import top.sarige.entity.Steering;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultCommandParser implements CommandParser {
    @Override
    public Command parseCommand(String str) {
        DefaultCommand command = new DefaultCommand();
        try {
            Document document = DocumentHelper.parseText(str);
            Element rootElement = document.getRootElement();
            Element moveController = getElementByEleName(rootElement, "moveController").get(0);
            Element steerings = getElementByEleName(rootElement, "steerings").get(0);
            Element motors = getElementByEleName(rootElement, "motors").get(0);
            Element lightings = getElementByEleName(rootElement, "lightings").get(0);
            //解析移动状态并实例化
            String movingStatus = getAttributeByAttrName(moveController, "status");
            String movingAccelerate = getAttributeByAttrName(moveController, "accelerate");
            Moving moving = new Moving(Integer.parseInt(movingStatus), Integer.parseInt(movingAccelerate));
            command.setMoving(moving);
            //解析舵机状态
            List<Element> steeringElementList = getElementByEleName(steerings, "steering");
            List<Steering> steeringList = new ArrayList<>();
            steeringElementList.forEach(element -> {
                String id = getAttributeByAttrName(element, "id");
                String position = getAttributeByAttrName(element, "position");
                steeringList.add(new Steering(Integer.parseInt(id), Integer.parseInt(position)));
            });
            command.setSteeringList(steeringList);
            //解析马达状态
            List<Element> motorElementList = getElementByEleName(motors, "motor");
            List<Motor> motorList = new ArrayList<>();
            motorElementList.forEach(element -> {
                String id = getAttributeByAttrName(element, "id");
                String status = getAttributeByAttrName(element, "status");
                String accelerate = getAttributeByAttrName(element, "accelerate");
                motorList.add(new Motor(Integer.parseInt(id), Integer.parseInt(status), Integer.parseInt(accelerate)));
            });
            command.setMotorList(motorList);
            //解析灯光状态
            List<Element> lightingElementList = getElementByEleName(lightings, "lighting");
            List<Lighting> lightingList = new ArrayList<>();
            lightingElementList.forEach(element -> {
                String id = getAttributeByAttrName(element, "id");
                String type = getAttributeByAttrName(element, "type");
                String status = getAttributeByAttrName(element, "status");
                lightingList.add(new Lighting(Integer.parseInt(id), Integer.parseInt(type), Integer.parseInt(status)));
            });
            command.setLightingList(lightingList);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return command;
    }

    public String getAttributeByAttrName(Element element, String attrName) {
        Attribute attribute = element.attribute(attrName);
        return attribute.getValue();
    }

    public List<Element> getElementByEleName(Element rootElement, String eleName) {
        List<Element> list = new ArrayList<>();
        for (Iterator i = rootElement.elementIterator(); i.hasNext(); ) {
            Element next = (Element) i.next();
            if (next.getName().equals(eleName)) {
                list.add(next);
            }
        }
        return list;
    }
}
