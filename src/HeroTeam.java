import chars.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HeroTeam{
    public static final int GANG_SIZE = 10;
    public static List<Base> wizardTeam;
    public static List<Base> monkTeam;

    public static void Init()
    {
        Random random = new Random();
        wizardTeam = new ArrayList<>();
        monkTeam = new ArrayList<>();

        int x=1;
        int y=1;
        for (int i = 0; i < GANG_SIZE; i++) {
            int value = random.nextInt(0,4);
            switch (value) {
                case 0 -> wizardTeam.add(new Peasant(wizardTeam,x++,y));
                case 1 -> wizardTeam.add(new Robber(wizardTeam,x++,y));
                case 2 -> wizardTeam.add(new Sniper(wizardTeam,x++,y));
                case 3 -> wizardTeam.add(new Wizard(wizardTeam,x++,y));
            }
        }

        x=1;
        y=10;
        for (int i = 0; i < GANG_SIZE; i++) {
            int value = random.nextInt(0,4);
            switch (value) {
                case 0 -> monkTeam.add(new Monk(monkTeam,x++,y));
                case 1 -> monkTeam.add(new Peasant(monkTeam,x++,y));
                case 2 -> monkTeam.add(new Spearman(monkTeam,x++,y));
                case 3 -> monkTeam.add(new Xbowman(monkTeam,x++,y));
            }
        }
    }

//    public ArrayList<Base> FindNpc(List<Base> team, String npcClassName)
//    {
//        ArrayList<Base> output= new ArrayList<>();
//        for (Base npc: team) {
//            if(npc.getClass().toString().toLowerCase().indexOf(npcClassName.toLowerCase()) > -1)
//                output.add(npc);
//        }
//        return output;
//    }

}
