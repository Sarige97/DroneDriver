package top.sarige.entity;

public class Motor {

    final public static int BRAKE = 0;
    final public static int GOHEAD = 1;
    final public static int GOBACK = 2;
    final public static int FREE = 3;

    public int id;
    public int status;
    public boolean isAccelerate;

    public Motor(int id, int status, boolean isAccelerate) {
        this.id = id;
        this.status = status;
        this.isAccelerate = isAccelerate;
    }
}
