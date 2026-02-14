import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Main{
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws ParseException, IOException{
        WestminsterSkinConsultationManager menu = new WestminsterSkinConsultationManager();
        menu.loadFromFile();

        while (true) {
            System.out.println("\nWELCOME TO SKIN CONSULTATION MANAGEMENT SYSTEM\n");
            System.out.println("A - Management ");
            System.out.println("B - User ");
            System.out.println("\nEnter 'A' or 'B' to continue : ");
            char choice = input.next().toUpperCase(Locale.ROOT).charAt(0);

            if (choice == 'A') {
                while (true) {
                    System.out.println("\nSKIN CONSULTATION MANAGEMENT SYSTEM\n");
                    System.out.println("1. Add a Doctor");
                    System.out.println("2. Delete a Doctor");
                    System.out.println("3. Print the Doctors List");
                    System.out.println("4. Save to file");
                    System.out.println("5. Open GUI");
                    System.out.println("6. Exit");
                    System.out.println("\nEnter an option to continue : ");
                    int option = input.nextInt();

                    switch (option) {
                        case 1 -> {
                            System.out.println("\n--- Add a Doctor ---\n");
                            WestminsterSkinConsultationManager menu1 = new WestminsterSkinConsultationManager();
                            menu1.addDoctor();
                        }
                        case 2 -> {
                            System.out.println("\n--- Delete a Doctor ---\n");
                            WestminsterSkinConsultationManager menu2 = new WestminsterSkinConsultationManager();
                            menu2.deleteDoctor();
                        }
                        case 3 -> {
                            System.out.println("\n--- List of Doctors ---\n");
                            WestminsterSkinConsultationManager menu3 = new WestminsterSkinConsultationManager();
                            menu3.printDetails();
                        }
                        case 4 -> {
                            System.out.println("\n--- Data successfully saved to the system ---\n");
                            WestminsterSkinConsultationManager menu4 = new WestminsterSkinConsultationManager();
                            menu4.saveToFile();
                        }
                        case 5 -> {
                            System.out.println("\n--- Graphical User Interface Opened ---\n");
                            new Home();
                            Home.setDoctorList(WestminsterSkinConsultationManager.getDoctorList());
                        }
                        case 6 -> {
                            System.out.println("\nExited...");
                            System.exit(0);
                        }
                        default -> System.out.println("Invalid input. Try again...");
                    }
                }

            } else if(choice == 'B'){
                System.out.println("\nSKIN CONSULTATION MANAGEMENT SYSTEM\n");
                System.out.println("1. Open User Interface");
                System.out.println("2. Exit");
                System.out.println("\nEnter an option to continue : ");
                int option = input.nextInt();

                switch (option){
                    case 1 -> {
                        System.out.println("\n--- Graphical User Interface Opened ---\n");
                        new Home();
                        Home.setDoctorList(WestminsterSkinConsultationManager.getDoctorList());
                    }
                    case 2 -> {
                        System.out.println("\nExited...");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid input. Try again...");
                }

            } else{
                System.out.println("Invalid input. Try again...");
            }
        }
    }
}