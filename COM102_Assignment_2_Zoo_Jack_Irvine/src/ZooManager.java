import java.util.Scanner;

public class ZooManager {
    private static final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args){



        Zoo myZoo = new Zoo("Belfast city zoo");
        Zookeeper keeper = new Zookeeper("John zoo");
        //zoo report class??
        int choice;

        do {
            System.out.println("--- Belfast City Zoo ---");
            System.out.println("----- Main Menu -----");
            System.out.println("1. Add Animal");
            System.out.println("2. Remove Animal");
            System.out.println("3. Update Animal Details");
            System.out.println("4. Search Zoo for Animals by Name");
            System.out.println("5. Search Zoo for Animals by Colour");
            System.out.println("6. Display all Animals Details");
            System.out.println("7. Display Zoo Report");
            System.out.println("8. Preform Daily Care");
            System.out.println("0. Exit the program");

            choice = getValidMenuChoice("Enter choice: ", 0, 8);

            switch (choice) {
                case 0:
                    break;

                case 1:
                    addAnimalMenu(myZoo);
                    break;

                case 2:
                    System.out.print("Enter name of Animal to remove: ");
                    myZoo.removeAnimal(userInput.nextLine());
                    break;

                case 3:
                    updateAnimalMenu(myZoo);
                    break;

                case 4:
                    System.out.print("Enter the name to search: ");
                    myZoo.searchByName(userInput.nextLine());
                    break;

                case 5:
                    System.out.print("Enter the colour to search: ");
                    myZoo.searchByColour(userInput.nextLine());
                    break;


                case 6:
                    myZoo.displayAllAnimals();
                    break;

                case 7:
                    myZoo.zooReport();
                    break;

                case 8:
                    keeper.preformDailyCare(myZoo.getAnimals());
                    break;
            }

        }while (choice !=0);
    }//main

    //add animals
    private static void addAnimalMenu(Zoo myZoo) {

        int type;
        do {
            System.out.println("--- add animal menu ---");
            System.out.println("What type of animal do you want to add?");
            System.out.println("---------");
            System.out.println("Warning: Any data fields left blank when entering an animal will not be saved beyond the current session!");
            System.out.println("---------");
            System.out.println("1. Eagle");
            System.out.println("2. Toucan");
            System.out.println("3. Owl");
            System.out.println("4. Hippo");
            System.out.println("5. Shark");
            System.out.println("6. Penguin");
            System.out.println("7. Crocodile");
            System.out.println("8. Python");
            System.out.println("9. Caecilian");
            System.out.println("0. return to main menu");

            type = getValidMenuChoice("Enter choice: ", 0, 9);

//            exits menu if 0 is chosen
            if (type == 0) {
                return;
            } else {

                String name = getValidString("Enter name: ");
                int age = getValidInt("Enter age: ");
                String colour = getValidString("Enter colour: ");
                double weight = getValidDouble("Enter weight in kg: ");


                switch (type) {

                    case 0:
                        break;

                    case 1:

                        double wingSpan = getValidDouble("Enter wing span in meters: ");

                        myZoo.addAnimal(new Eagle(name, colour, age, weight, wingSpan));
                        break;

                    case 2:
                        double beakLength = getValidDouble("Enter the beak length in cm: ");
                        myZoo.addAnimal(new Toucan(name, colour, age, weight, beakLength));
                        break;

                    case 3:
                        int hearingRange = getValidInt("Enter the hearing range in meters: ");
                        myZoo.addAnimal(new Owl(name, colour, age, weight, hearingRange));
                        break;

                    case 4:
                        boolean hungryHippo = getValidBoolean("Enter if it is a hungry hungry hippo (true or false): ");
                        myZoo.addAnimal(new Hippo(name, colour, age, weight, hungryHippo));
                        break;

                    case 5:
                        int numTeeth = getValidInt("Enter the number of teeth: ");
                        myZoo.addAnimal(new Shark(name, colour, age, weight, numTeeth));
                        break;

                    case 6:
                        int swimSpeed = getValidInt("Enter the swim speed in MPH: ");
                        myZoo.addAnimal(new Penguin(name, colour, age, weight, swimSpeed));
                        break;

                    case 7:
                        double biteForce = getValidDouble("Enter the bite force in PSI: ");
                        myZoo.addAnimal(new Crocodile(name, colour, age, weight, biteForce));
                        break;

                    case 8:
                        int tongueFlicksPerMin = getValidInt("Enter the tongue flicks per minute: ");
                        myZoo.addAnimal(new Python(name, colour, age, weight, tongueFlicksPerMin));
                        break;

                    case 9:
                        int burrowDepth = getValidInt("Enter the burrow depth in cm: ");
                        myZoo.addAnimal(new Caecilian(name, colour, age, weight, burrowDepth));
                        break;

                    default:
                        System.out.println("Invalid choice, try again");
                }
            }
        } while (type != 0);

    }//add animal

//    update animal menu
    private static void updateAnimalMenu(Zoo myZoo) {
        int menuChoice;
        do {
            System.out.println("--- Update details menu ---");
            System.out.println("1. Update details by name search");
            System.out.println("2. Display list of all animals");
            System.out.println("0. Exit Update details menu");

            menuChoice = getValidMenuChoice("Enter choice: ", 0, 2);

            switch (menuChoice) {
                case 1:

                    String oldName = getValidString("Enter the name of the animal to update");

                    Animal searchAni = myZoo.findAnimal(oldName);

//                    check if animal exists
                    if (searchAni == null) {
                        System.out.println("Animal not found, Update cancelled");
                        return;
                    }else {
//                      if animal exits now update it.
                        String newName = getValidString("Enter a new name: ");
                        String colour = getValidString("Enter new colour: ");
                        int age = getValidInt("Enter new age: ");
                        double weight = getValidDouble("Enter new weight: ");

                        myZoo.updateDetails(newName, colour, age, weight);
                    }

                case 2:
                    myZoo.displayAllAnimals();
                    break;

                case 0:
                    break;

            }

        } while (menuChoice != 0);
    }

    //    string validation
    private static String getValidString(String inputPrompt) {
        while (true) {
            System.out.print(inputPrompt);
            String input = userInput.nextLine();

            if (!input.trim().isEmpty()) {
                return input;
            } else {
                System.out.println("Input cannot be empty ");
            }
        }//while
    }//string validation

//    int validation
    private static int getValidInt(String inputPrompt) {
        while (true) {
            System.out.print(inputPrompt);
            String input = userInput.nextLine();

            try{
                int value = Integer.parseInt(input);
                if (value > 0) {
                    return value;
                }else {
                    System.out.println("Number must be greater than 0 ");
                }

            } catch (NumberFormatException e) {
                System.out.print("Invalid Number ");
            }//try catch
        }//while
    } // int validation

//    double validation
    private static double getValidDouble(String inputPrompt) {
        while (true) {
            System.out.print(inputPrompt);
            String input = userInput.nextLine();

            try {
                double value = Double.parseDouble(input);
                if (value >= 0) {
                    return value;
                } else {
                    System.out.print("Value must be positive ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid number ");
            }//try catch
        }//while
    }//validate double

//    boolean validation
    private static boolean getValidBoolean(String inputPrompt) {
        while (true) {
            System.out.print(inputPrompt);
            String input = userInput.nextLine().trim().toLowerCase();

            if (input.equals("true")) {
                return true;
            } else if (input.equals("false")) {
                return false;
            } else {
                System.out.println("Invalid input, please enter true or false ");
            }//ifs
        }//while
    }//validate boolean

//    validate menu nav
    private static int getValidMenuChoice(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = userInput.nextLine();

            try {
                int value = Integer.parseInt(input);

                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Please enter a number between "
                            + min + " & " + max);
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid Number ");
            }//try catch
        }//while
    }//get valid menu choice number.

}//class
