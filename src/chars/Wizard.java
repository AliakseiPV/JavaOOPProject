package chars;

import java.util.List;

public class Wizard extends Base {
    public Wizard(List<Base> gang, int x, int y) {
        super(17, 12, 0, new int[]{-5,-5}, 30, 30, 9, false, true, "Wizard");
        super.gang = gang;
        super.position = new Vector2(x, y);
    }

    @Override
    public void Step(List<Base> group) {
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
        return "Wizard  - " +
                "HP(30.0 - " + getCurrentHealth() + ")";
    }
}
