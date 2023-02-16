import java.util.Scanner;

//main program of Pakuri
public class PakuriProgram {
    public static void main(String[] args){
        int capacity = 0;
        int selection = 0;
        boolean valid = false;
        Pakudex pakudex = null;
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!\n" +
                "Enter max capacity of the Pakudex: ");
        //tries user input for validity
        while(!valid) {
            try {
                capacity = Integer.parseInt(in.next());
                pakudex = new Pakudex(capacity);
                valid = true;
            } catch (Exception e) {
                System.out.println("Please enter a valid size.\nEnter max capacity of the Pakudex: \n");

            }
        }
        System.out.println("The Pakudex can hold " + capacity + " species of Pakuri.\n");

        //menu selections
        while(selection!=6) {
            System.out.println(
                    "Pakudex Main Menu\n" +
                            "-----------------\n" +
                            "1. List Pakuri\n" +
                            "2. Show Pakuri\n" +
                            "3. Add Pakuri\n" +
                            "4. Evolve Pakuri\n" +
                            "5. Sort Pakuri\n" +
                            "6. Exit\n");
            System.out.print("What would you like to do? ");
            //test if valid
            try {
                selection = Integer.parseInt(in.next());
            } catch (Exception e) {
                System.out.println("Unrecognized menu selection!");
                continue;
            }

            //test if quit
            if(selection == 6) {
                System.out.println("\nThanks for using Pakudex! Bye!");
                break;
            }

            //list pakuri
            else if (selection == 1) {
                int counter = 1;
                String[] pakOutput = pakudex.getSpeciesArray();
                if (pakOutput == null) {
                    System.out.println("No Pakuri in Pakudex yet!\n");
                } else {
                    System.out.println("Pakuri In Pakudex: ");
                    for (String s : pakOutput) {
                        System.out.println(counter + ". " + s);
                        counter++;
                    }
                    System.out.println();
                }
            } //display stats abt pakuri
            else if (selection == 2) {
                System.out.println("Enter the name of the species to display: ");
                String spec = in.next();
                int[] stat = pakudex.getStats(spec);
                if (stat == null)
                    System.out.println("Error: No such Pakuri!\n");
                else {
                    System.out.println("Species: " + spec);
                    System.out.println("Attack: " + stat[0]);
                    System.out.println("Defense: " + stat[1]);
                    System.out.println("Speed: " + stat[2] + "\n");
                }
            } //add species to pakudex
            else if (selection == 3){
                if(pakudex.getSize() == capacity)
                    System.out.println("Error: Pakudex is full!\n");
                else {
                    System.out.println("Enter the name of the species to add: ");
                    String spec = in.next();
                    pakudex.addPakuri(spec);
                }
            } //evolve species
            else if (selection == 4){
                System.out.println("Enter the name of the species to evolve: ");
                String spec = in.next();
                pakudex.evolveSpecies(spec);
            } //sort pakuri
            else if (selection == 5){
                pakudex.sortPakuri();
            }
            //general error for ints not between 1-6
            else
                System.out.println("Unrecognized menu selection!");
        }
    }
}
