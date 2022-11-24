import java.util.ArrayList;

public class Wizard extends Base {
    public Wizard() {
        super(17, 12, 0, new int[]{-5,-5}, 30, 30, 9, false, true, "");
    }

    @Override
    public String toString()
    {
        return "Wizard - " + super.toString();
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
