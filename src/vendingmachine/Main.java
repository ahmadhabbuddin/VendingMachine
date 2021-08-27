package vendingmachine;

import java.util.Scanner;

// == MAIN CLASS == //
public class Main {

    // == MAIN METHOD TO RUN ALL CODES == //
    public static void main(String[] args) {
        // == OBJECT INSTANCE == //
        VendingMachine vm = new VendingMachine();
        Scanner scanner = new Scanner(System.in);

        // == RECORD SNACK LIST == //
        vm.setSnackList(new Snacks("01", "Biskuit", 15, new Long(6000)));
        vm.setSnackList(new Snacks("02", "Chips", 12, new Long(8000)));
        vm.setSnackList(new Snacks("03", "Oreo", 8, new Long(10000)));
        vm.setSnackList(new Snacks("04", "Tango", 14, new Long(12000)));
        vm.setSnackList(new Snacks("05", "Cokelat", 8, new Long(15000)));

        // == START TRANSACTION == //
        boolean transaction = true;
        while (transaction) {
            vm.startTransaction();
            System.out.println("Transaction success!");
            System.out.print("Exit transaction? [y/n] -> ");
            String confirm = scanner.next();
            System.out.println("=====================================");
            System.out.println("");
            if (confirm.toLowerCase().equals("y")) {
                transaction = false;
            }
        }

    }

}

