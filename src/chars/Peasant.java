package chars;


import java.util.List;

public class Peasant extends Base {
    public Peasant(List<Base> gang, int x, int y) {
        super(1, 1, 0, new int[]{1,1}, 1,1, 3, true, false, "Peasant");
        super.gang = gang;
        super.position = new Vector2(x, y);
    }

    @Override
    public void Step(List<Base> group) {
        if(this.status.equals("dead")) return;
        if(this.status.equals("used")) this.status = "stand";
    }

    @Override
    public String GetInfo() {
        return "Peasant - " +
                "Status(" + status + "), " +
                "HP(1.0 - " + getCurrentHealth() + ")  ";
    }
}
