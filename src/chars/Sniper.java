package chars;

import java.util.List;
import java.util.Random;

public class Sniper extends Base {
    public Sniper(List<Base> gang, int x, int y) {
        super(12, 10, 32, new int[]{8,10}, 15, 15, 9, false, false, "Sniper");
        super.gang = gang;
        super.position = new Vector2(x, y);
    }

    @Override
    public void Step(List<Base> group) {
        Random random = new Random();

        for (Base npc: group) {
            if(npc.getClass() == Xbowman.class || npc.getClass() == Spearman.class)
            {
                npc.setCurrentHealth(npc.getCurrentHealth() - random.nextInt(getDamage()[0],getDamage()[1]));
                if(npc.getCurrentHealth() <= 0)
                {
                    group.remove(npc);
                }
                break;
            }
//            else if(!group.contains(chars.Xbowman.class) && !group.contains(chars.Spearman.class))
//            {
//                npc.setCurrentHealth(npc.getCurrentHealth() - random.nextInt(getDamage()[0],getDamage()[1]));
//                if(npc.getCurrentHealth() <= 0)
//                {
//                    group.remove(npc);
//                }
//                break;
//            }
        }
    }

    @Override
    public String GetInfo() {
        return "Sniper  - " +
                "HP(15.0 - " + getCurrentHealth() + ")";
    }
}
