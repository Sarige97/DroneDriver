package top.sarige.entity;

public class Moving {

    private final int status;
    private final int accelerate;

    public Moving(int status, int accelerate) {
        this.status = status;
        this.accelerate = accelerate;
    }

    public int getStatus() {
        return status;
    }

    public int getAccelerate() {
        return accelerate;
    }

    @Override
    public String toString() {
        return "Moving{" +
                "status=" + status +
                ", accelerate=" + accelerate +
                '}';
    }
}
