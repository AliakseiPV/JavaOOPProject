package chars;

import java.util.List;
import java.util.Random;

public class Robber extends Base{
    public Robber(List<Base> gang, int x, int y) {
        super(8, 3, 0, new int[]{2,4}, 10, 10, 6, false, false, "Robber");
        super.gang = gang;
        super.position = new Vector2(x, y);
    }

    @Override
    public void Step(List<Base> group) {
        Random random = new Random();

        for (Base npc: group) {
            if(npc.getClass() == Xbowman.class || npc.getClass() == Spearman.class )
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
        return "Robber  - " +
                "HP(10.0 - " + getCurrentHealth() + ")";
    }
}

