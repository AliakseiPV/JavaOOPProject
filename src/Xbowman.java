import java.util.ArrayList;
import java.util.Random;

public class Xbowman extends Base {
    public Xbowman() {
        super(6, 3, 16, new int[]{2,3}, 10, 10, 4, false, false, "");
    }

    @Override
    public String toString()
    {
        return "Xbowman - " + super.toString();
    }

    @Override
    public void Step(ArrayList<Base> group) {
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
//            else if(!group.contains(Sniper.class) && !group.contains(Robber.class))
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
