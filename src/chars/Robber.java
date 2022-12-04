import java.util.ArrayList;
import java.util.Random;

public class Robber extends Base{
    public Robber() {
        super(8, 3, 0, new int[]{2,4}, 10, 10, 6, false, false, "");
    }

    @Override
    public String toString()
    {
        return "Robber - " + super.toString();
    }

    @Override
    public void Step(ArrayList<Base> group) {
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

