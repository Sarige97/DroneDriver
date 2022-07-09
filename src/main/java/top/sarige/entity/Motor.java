package top.sarige.entity;

public class Motor {

    final public static int BRAKE = 0;
    final public static int GOHEAD = 1;
    final public static int GOBACK = 2;
    final public static int FREE = 3;

    public int id;
    public int status;
    public int accelerate;

    public Motor(int id, int status, int accelerate) {
        this.id = id;
        this.status = status;
        this.accelerate = accelerate;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "id=" + id +
                ", status=" + status +
                ", accelerate=" + accelerate +
                '}';
    }
}
