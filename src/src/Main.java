import java.util.Scanner;
import VM.VM;

public class Main {
    public static VM vm = new VM();
    public static void main(String[] args) {
        int opc = -1;
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("============================");
            System.out.println("|   MENU SELECTION         |");
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
                vm.run();
                break;
            case 2:
                vm.output();
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
