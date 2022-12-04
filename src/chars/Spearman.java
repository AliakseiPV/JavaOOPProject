import java.util.ArrayList;
import java.util.Random;

public class Spearman extends Base {
    public Spearman() {
        super(4, 5, 0, new int[]{1,3}, 10, 10, 4, false, false, "");
    }

    @Override
    public String toString()
    {
        return "Spearman - " + super.toString();
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
//                else if(!group.contains(Sniper.class) && !group.contains(Robber.class))
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
}
