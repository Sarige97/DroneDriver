package top.sarige.entity;

public class Lighting {

    final static public int TYPE_RGB = 0;
    final static public int TYPE_NORMAL = 1;

    final static public int STATUS_OFF = 0;
    final static public int STATUS_ON = 1;
    final static public int STATUS_BLINK = 2;

    private final int id;
    private final int type;
    private final int status;

    public Lighting(int id, int type, int status) {
        this.id = id;
        this.type = type;
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Lighting{" +
                "id=" + id +
                ", type=" + type +
                ", status=" + status +
                '}';
    }
}
