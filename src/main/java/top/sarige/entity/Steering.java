package top.sarige.entity;

public class Steering {

    public int id;
    public int angle;

    public Steering(int id, int angle) {
        this.id = id;
        this.angle = angle;
    }

    public int getAngle() {
        return angle;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Steering{" +
                "id=" + id +
                ", angle=" + angle +
                '}';
    }
}
