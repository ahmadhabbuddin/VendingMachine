package vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class VendingMachine{
    

// == RECORDS == //
    private final List<Snacks> snackList = new ArrayList<>();
    private final List<TransactionHistory> trxHistory = new ArrayList<>();

    // == OBJECT == //
    private final Long[] acceptedBanknotes = {2000L, 5000L, 10000L, 20000L, 50000L};

    // == SHOW ALL SNACK RECORDS == //
    public void showSnackList() {

        System.out.println("Code\tSnack\t\tPrice(Rp)\tStock");
        System.out.println("");
        this.snackList.forEach((sn) -> {
            System.out.println(sn.getSnackCode() + ".\t" + sn.getSnackName() + "\t\t" + sn.getPrice() + "\t\t" + sn.getStock());
        });
        System.out.println("");
    }

    // == CHOOSE SNACK == //
    public Snacks chooseSnack(String snackCode) {
        Snacks snack = null;
        for (Snacks sn : this.snackList) {
            if (sn.getSnackCode().equals(snackCode) && sn.getStock() > 0) {
                snack = sn;
            }
        }
        return snack;
    }

    // == CHECK AVAILABILITY SNACK == //
    public boolean availableStock(Snacks sn, int req) {
        return !(req < 1 || req > sn.getStock());
    }

    // == RECORD SNACKS == //
    public void setSnackList(Snacks sn) {
        this.snackList.add(sn);
    }

    // == TRANSACTIONS == //
    public void startTransaction() {
        // == OBJECT SCANNER == //

        Scanner scanner = new Scanner(System.in);
        // == SHOW SNACK LIST == //
        this.showSnackList();

        // == STATEMENT TO CHOOSE SNACK == //
        Snacks snack = null;
        while (snack == null) {
            System.out.print("Insert Snack Code: ");
            String snackCode = scanner.next();
            snack = this.chooseSnack(snackCode);
            if (snack == null) {
                System.out.println("=====================================");
                System.out.println("Sorry, snack not available or stock is empty. Please choose other Snack, please!");
                System.out.println("=====================================\n");
                this.showSnackList();
            }
        }
        System.out.println("[" + snack.getSnackName() + " - " + snack.getPrice() + "]");

        // == STATEMENT TO CHECK AVAILABILITY SNACK == //
        int req = 0;
        while (!this.availableStock(snack, req)) {
            System.out.print("Insert number of snack (Available " + snack.getStock() + "): ");
            req = scanner.nextInt();
            if (req < 1) {
                System.out.println("=====================================");
                System.out.println("Please insert more than 0.");
                System.out.println("=====================================");
            } else {
                if (!this.availableStock(snack, req)) {
                    System.out.println("=====================================");
                    System.out.println("Out of stock or less.");
                    System.out.println("=====================================");
                }
            }
        }

        // == STATEMENT TO PAYMENT == //
        Long totalPayment = snack.getPrice() * new Long(req);
        int count = 0;
        while (totalPayment > 0) {
            if ( count > 0 ){
                System.out.println("Total payment remain: " + totalPayment);
            }else{
                System.out.println("Total payment: " + totalPayment);
            }
            System.out.print("Insert money to pay: ");
            Long pay = scanner.nextLong();
            if (Arrays.asList(this.acceptedBanknotes).indexOf(pay) < 0) {
                System.out.println("Banknotes is not accepted! Please insert other banknotes. [ex: 2000, 5000, 10000, 20000, 50000]");
            } else {
                totalPayment -= pay;
            }
            count++;
        }

        // == UPDATE SNACK RECORD == //
        snack.setStock(snack.getStock() - req);

        // == SAVE TRANSACTION TO HISTORY == //
        saveTransaction(snack, totalPayment);

        // == END TRANSACTION == //
        System.out.println("=====================================");
        System.out.println("Enjoy your snack");
        if (totalPayment < 0) {
            System.out.println("Change: " + (totalPayment * -1));
        }
        System.out.println("=====================================");
    }

    // == METHOD TO SAVE TRANSACTION HISTORY == //
    public void saveTransaction(Snacks sn, Long payment) {
        TransactionHistory trx = new TransactionHistory(new Long(this.trxHistory.size() + 1), sn.getSnackCode(), payment);
        this.trxHistory.add(trx);
    }
}


