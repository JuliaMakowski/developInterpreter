import java.util.Scanner;
import VM.VM;

public class Main {
    public static void main(String[] args) {
        VM vm = new VM();
        int opc = -1;
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("============================");
            System.out.println("|   MENU SELECTION DEMO    |");
            System.out.println("============================");
            System.out.println("| Options:                 |");
            System.out.println("|        1. Run Program    |");
            System.out.println("|        2. Show output    |");
            System.out.println("|        0. Exit           |");
            System.out.println("============================");
            opc = in.nextInt();
            menuOptions(opc);
        }while (opc!=0);
    }

    public static void menuOptions(int opc){
        switch (opc){
            case 1:
                break;
            case 2:
                break;
            case 0:
                System.out.println("Ending program. Have a nice day!");
                break;
            default:
                System.out.println("Wrong option");
                break;
        }
    }
}
