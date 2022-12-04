package chars;

import java.util.List;
import java.util.Random;

public class Spearman extends Base {
    public Spearman(List<Base> gang, int x, int y) {
        super(4, 5, 0, new int[]{1,3}, 10, 10, 4, false, false, "Spearman");
        super.gang = gang;
        super.position = new Vector2(x, y);
    }

    @Override
    public void Step(List<Base> group) {
        Random random = new Random();

            for (Base npc: group) {
                if(npc.getClass() == Sniper.class || npc.getClass() == Robber.class)
                {
                    npc.setCurrentHealth(npc.getCurrentHealth() - random.nextInt(getDamage()[0],getDamage()[1]));
                    if(npc.getCurrentHealth() <= 0)
                    {
                        group.remove(npc);
                    }
                    break;
                }
//                else if(!group.contains(chars.Sniper.class) && !group.contains(chars.Robber.class))
//                {
//                    npc.setCurrentHealth(npc.getCurrentHealth() - random.nextInt(getDamage()[0],getDamage()[1]));
//                    if(npc.getCurrentHealth() <= 0)
//                    {
//                        group.remove(npc);
//                    }
//                    break;
//                }
            }
    }

    @Override
    public String GetInfo() {
        return "Spearman- " +
                "HP(10.0 - " + getCurrentHealth() + ")";
    }
}
