import java.util.ArrayList;
import java.util.Random;

public class Sniper extends Base {
    public Sniper() {
        super(12, 10, 32, new int[]{8,10}, 15, 15, 9, false, false, "");
    }

    @Override
    public String toString()
    {
        return "Sniper - " + super.toString();
    }

    @Override
    public void Step(ArrayList<Base> group) {
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
//            else if(!group.contains(Xbowman.class) && !group.contains(Spearman.class))
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
}
