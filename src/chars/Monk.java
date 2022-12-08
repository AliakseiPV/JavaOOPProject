package chars;

import java.util.ArrayList;
import java.util.List;

public class Monk extends Base {
    public Monk(List<Base> gang, int x, int y) {
        super(12, 7, 0, new int[]{-4,-4}, 30,30, 5, false, true, "Monk");
        super.gang = gang;
        super.position = new Vector2(x, y);
    }

    @Override
    public void Step(List<Base> group) {
        if(this.status.equals("dead")) return;

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

    @Override
    public String GetInfo() {
        return  "Monk    - " +
                "Status(" + status + "), " +
                "HP(30.0 - " + getCurrentHealth() + ")";
    }
}

