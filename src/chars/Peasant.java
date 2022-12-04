import java.util.ArrayList;

public class Peasant extends Base {
    public Peasant() {
        super(1, 1, 0, new int[]{1,1}, 1,1, 3, true, false, "");
    }

    @Override
    public String toString()
    {
        return "Peasant - " + super.toString();
    }

    @Override
    public void Step(ArrayList<Base> group) {

    }
}
