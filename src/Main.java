
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HeroTeam.Init();

        Scanner scanner = new Scanner(System.in);

        while (true){
            ConsoleView.view();
            System.out.println("Press ENTER");
            scanner.nextLine();
        }


//        HeroTeam.wizardTeam.forEach(System.out::println);
//        System.out.println();
//        HeroTeam.monkTeam.forEach(System.out::println);
//        System.out.println("\n");



    }
}