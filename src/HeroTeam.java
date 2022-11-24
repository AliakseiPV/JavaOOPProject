import java.util.ArrayList;
import java.util.Random;

public class HeroTeam{

    public ArrayList<Base> FindNpc(ArrayList<Base> team, String npcClassName)
    {
        ArrayList<Base> output= new ArrayList<>();
        for (Base npc: team) {
            if(npc.getClass().toString().toLowerCase().indexOf(npcClassName.toLowerCase()) > -1)
                output.add(npc);
        }
        return output;
    }

    public ArrayList<Base> CreateWizardTeam(int heroCount)
    {
        Random random = new Random();
        ArrayList<Base> firstTeam = new ArrayList<>();

        for (int i = 0; i < heroCount; i++) {
            int value = random.nextInt(0,4);
            switch (value) {
                case 0 -> firstTeam.add(new Peasant());
                case 1 -> firstTeam.add(new Robber());
                case 2 -> firstTeam.add(new Sniper());
                case 3 -> firstTeam.add(new Wizard());
            }
        }
        return firstTeam;
    }

    public ArrayList<Base> CreateMonkTeam(int heroCount)
    {
        Random random = new Random();
        ArrayList<Base> secondTeam = new ArrayList<>();

        for (int i = 0; i < heroCount; i++) {
            int value = random.nextInt(0,4);
            switch (value) {
                case 0 -> secondTeam.add(new Monk());
                case 1 -> secondTeam.add(new Peasant());
                case 2 -> secondTeam.add(new Spearman());
                case 3 -> secondTeam.add(new Xbowman());
            }
        }
        return secondTeam;
    }
}
