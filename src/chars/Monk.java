import java.util.ArrayList;
import java.util.Random;

public class Monk extends Base {
    public Monk() {
        super(12, 7, 0, new int[]{-4,-4}, 30,30, 5, false, true, "");
    }

    @Override
    public String toString()
    {
        return "Monk - " + super.toString();
    }

    @Override
    public void Step(ArrayList<Base> group) {
        Base diyingNpc = null;
        var minHealth = 100.0;

        for (Base npc: group) {
            var temp = npc.getMaxHealth() - npc.getCurrentHealth();
            if(temp < minHealth)
            {
                minHealth = temp;
                diyingNpc = npc;
            }
        }

        diyingNpc.setCurrentHealth(diyingNpc.getCurrentHealth() - getDamage()[0]);
        if(diyingNpc.getMaxHealth() < diyingNpc.getCurrentHealth())
        {
            diyingNpc.setCurrentHealth(diyingNpc.getMaxHealth());
        }

    }
}

