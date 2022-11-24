import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        HeroTeam heroCreate = new HeroTeam();

        ArrayList<Base> firstTeam = heroCreate.CreateWizardTeam(10);
        ArrayList<Base> secondTeam = heroCreate.CreateMonkTeam(10);

//        ArrayList<Base> foundTeam = heroCreate.FindNpc(firstTeam, "Peasant");
//        for (Base npc: foundTeam) {
//            System.out.println(npc);
//        }


        firstTeam.forEach(System.out::println);
        System.out.println();
        secondTeam.forEach(System.out::println);
        System.out.println("\n");

        Sniper sniper = new Sniper();
        Robber robber = new Robber();
        Spearman spearman = new Spearman();
        Xbowman xbowman = new Xbowman();


        for (int i = 0; i < 4; i++)
        {
            sniper.Step(secondTeam);
            spearman.Step(firstTeam);
            robber.Step(secondTeam);
            xbowman.Step(firstTeam);
        }



        firstTeam.forEach(System.out::println);
        System.out.println();
        secondTeam.forEach(System.out::println);


        Monk monk = new Monk();
        monk.Step(secondTeam);
    }
}