import java.util.*;

public class ZooManager {
    private static Scanner userInput = new Scanner(System.in);

    //program main method that starts up the main menu
    public static void main(String[] args){



        Zoo myZoo = new Zoo("Belfast city zoo");
        myZoo.loadZooDetails();
        myZoo.loadAnimalDetails();

        Zookeeper keeper = new Zookeeper("John ZooKeeper");
        Visitor visitor = new Visitor(200);

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
            System.out.println("9. View Animal Enclosure");
            System.out.println("10. Get Animal Facts");
            System.out.println("11. Visit Zoo stores");
            System.out.println("0. Exit the program");

            choice = getValidMenuChoice("Enter choice: ", 0, 11);

            switch (choice) {
                case 0:
                    System.out.println("Saving data...");
                    myZoo.saveZooDetails();
                    myZoo.saveAnimalDetails();
                    System.out.println("Data saved, Exiting program");
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

                case 9:
                    viewEnclosureMenu(myZoo);
                    break;

                case 10:
                    getAnimalFactsMenu();
                    break;

                case 11:
                    getZooStoreMenu(visitor);
                    break;
            }

        }while (choice !=0);
    }//main

    //add animals
    private static void addAnimalMenu(Zoo myZoo) {

        int type;
        do {
            System.out.println("\n--- add animal menu ---");
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
            System.out.println("\n--- Update details menu ---");
            System.out.println("1. Update details by name search");
            System.out.println("2. Display list of all animals");
            System.out.println("0. Exit Update details menu");

            menuChoice = getValidMenuChoice("Enter choice: ", 0, 2);

            switch (menuChoice) {
                case 1:

                    String oldName = getValidString("Enter the name of the animal to update: ");

                    Animal searchAni = myZoo.findAnimal(oldName);

//                    check if animal exists
                    if (searchAni == null) {
                        System.out.println("Animal not found, Update cancelled");
                        return;
                    }else {
//                      if animal exits now update it.

                        //starting with common attributes
                        String newName = getValidString("Enter a new name: ");
                        String colour = getValidString("Enter new colour: ");
                        int age = getValidInt("Enter new age: ");
                        double weight = getValidDouble("Enter new weight: ");

                        //instance variables
                        Double wingspan = null;
                        Double beakLength = null;
                        Integer hearingRange = null;
                        Boolean hungryHippo = null;
                        Integer numTeeth = null;
                        Integer swimSpeed = null;
                        Double biteForce = null;
                        Integer tongueFlicks = null;
                        Integer burrowDepth = null;

                        if (searchAni instanceof Eagle) {
                            wingspan = getValidDouble("Enter new wing span in meters: ");

                        } else if (searchAni instanceof Toucan) {
                            beakLength = getValidDouble("Enter new beak length in cm: ");

                        } else if (searchAni instanceof Owl) {
                            hearingRange = getValidInt("Enter new hearing range in meters: ");

                        } else if (searchAni instanceof Hippo) {
                            hungryHippo = getValidBoolean("Enter if it is now a hungry hungry hippo (yes or no): ");

                        } else if (searchAni instanceof Shark) {
                            numTeeth = getValidInt("Enter the new number of teeth: ");

                        } else if (searchAni instanceof Penguin) {
                            swimSpeed = getValidInt("Enter new swim speed in MPH: ");

                        } else if (searchAni instanceof Crocodile) {
                            biteForce = getValidDouble("Enter new bite force in PSI: ");

                        } else if (searchAni instanceof Python) {
                            tongueFlicks = getValidInt("Enter new tongue flicks per minute: ");

                        } else if (searchAni instanceof Caecilian) {
                            burrowDepth = getValidInt("Enter new burrow depth in cm: ");

                        }


                        myZoo.updateDetails(oldName, newName, colour, age, weight, wingspan, beakLength, hearingRange,
                                hungryHippo, numTeeth, swimSpeed, biteForce, tongueFlicks, burrowDepth);
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

            if (input.equals("true") || input.equalsIgnoreCase("y") || input.equals("yes")) {
                return true;
            } else if (input.equals("false") || input.equalsIgnoreCase("n") || input.equals("no")) {
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

//    view animal encloser custom feature
    public static void viewEnclosureMenu(Zoo zoo) {
        int choice;
        do {
            System.out.println("\n---------");
            System.out.println("--- Enclosure Menu ---");
            System.out.println("Choose a enclosure to view");
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

            choice = getValidMenuChoice("Enter choice: ", 0, 9);

            //return to main menu, have this up here as if below the next step it will crash when exiting menu
            if (choice == 0) {
                return;
            }

            Class<?> selectedType = null;

            switch (choice) {
                case 0:
                    break;

                case 1:
                    selectedType = Eagle.class;
                    break;

                case 2:
                    selectedType = Toucan.class;
                    break;

                case 3:
                    selectedType = Owl.class;
                    break;

                case 4:
                    selectedType = Hippo.class;
                    break;

                case 5:
                    selectedType = Shark.class;
                    break;

                case 6:
                    selectedType = Penguin.class;
                    break;

                case 7:
                    selectedType = Crocodile.class;
                    break;

                case 8:
                    selectedType = Python.class;
                    break;

                case 9:
                    selectedType = Caecilian.class;
                    break;

            }

            ArrayList<Animal> enclosure = zoo.getAnimalType(selectedType);

//            if no animals of that type
            if (enclosure.isEmpty()) {
                System.out.println("No animals in this enclosure");
                return;
            }

//            get random animals from enclosure
            Collections.shuffle(enclosure);

//            get random amount of animals from the enclosure
            Random randNum = new Random();
            int numberOfAnimals = randNum.nextInt(enclosure.size()) + 1;

            System.out.println("\n---------");
            for (int i = 0; i<numberOfAnimals; i++) {
                Animal a = enclosure.get(i);

//                get interface methods
                ArrayList<String> actions = new ArrayList<>();
                if (a instanceof Swimable) {
                    actions.add("swim");
                    actions.add("dive");
                    actions.add("rise");
                    actions.add("hide");
                    actions.add("unhide");
                }
                if (a instanceof Flyable) {
                    actions.add("fly");
                    actions.add("land");
                    actions.add("chirp");
                    actions.add("roost");
                    actions.add("cleanSelf");
                }
                if (a instanceof Slitherable) {
                    actions.add("slither");
                    actions.add("shedSkin");
                    actions.add("bask");
                    actions.add("hiss");
                    actions.add("ambush");
                }

                if (actions.isEmpty()) {
                    System.out.println("actions not working in zoo manager");
                } else {
//                    picks random action
                    String action = actions.get(randNum.nextInt(actions.size()));

                    switch (action) {
                        case "swim":
                            assert a instanceof Swimable;
                            ((Swimable) a).swim();
                            break;

                        case "dive":
                            assert a instanceof Swimable;
                            ((Swimable) a).dive();
                            break;

                        case "rise":
                            assert a instanceof Swimable;
                            ((Swimable) a).rise();
                            break;

                        case "hide":
                            assert a instanceof Swimable;
                            ((Swimable) a).hide();
                            break;

                        case "unhide":
                            assert a instanceof Swimable;
                            ((Swimable) a).unhide();

                        case "fly":
                            assert a instanceof Flyable;
                            ((Flyable) a).fly();
                            break;

                        case "land":
                            assert a instanceof Flyable;
                            ((Flyable) a).land();
                            break;

                        case "chirp":
                            assert a instanceof Flyable;
                            ((Flyable) a).chirp();
                            break;

                        case "roost":
                            assert a instanceof Flyable;
                            ((Flyable) a).roost();
                            break;

                        case "cleanSelf":
                            assert a instanceof Flyable;
                            ((Flyable) a).cleanSelf();
                            break;

                        case "slither":
                            assert a instanceof Slitherable;
                            ((Slitherable) a).slither();
                            break;

                        case "shedSkin":
                            assert a instanceof Slitherable;
                            ((Slitherable) a).shedSkin();
                            break;

                        case "bask":
                            assert a instanceof Slitherable;
                            ((Slitherable) a).bask();
                            break;

                        case "hiss":
                            assert a instanceof Slitherable;
                            ((Slitherable) a).hiss();
                            break;

                        case "ambush":
                            assert a instanceof Slitherable;
                            ((Slitherable) a).ambush();
                            break;
                    }//switch
                }//else


            }//for

        } while (choice != 0);

    }// view enclosure

    // get animal facts custom feature
    private static void getAnimalFactsMenu() {
        int choice;
        do {
            System.out.println("\n---------");
            System.out.println("--- Animal Fact Menu ---");
            System.out.println("Choose which animal to get facts about");
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

            choice = getValidMenuChoice("Enter choice: ", 0, 9);

            //menu loop
            boolean repeat;

            switch (choice) {
                case 0:
                    break;

                case 1:
                    Animal tempEagle = new Eagle("", "", 0,0,0);
                    System.out.println(tempEagle.getRandomFacts());
                    break;

                case 2:
                    Animal tempToucan = new Toucan("", "", 0,0,0);
                    System.out.println(tempToucan.getRandomFacts());
                    break;

                case 3:
                    Animal tempOwl = new Owl("", "", 0,0,0);
                    System.out.println(tempOwl.getRandomFacts());
                    break;

                case 4:
                    Animal tempHippo = new Hippo("", "", 0,0,true);
                    System.out.println(tempHippo.getRandomFacts());
                    break;

                case 5:
                    Animal tempShark = new Shark("", "", 0,0,0);
                    System.out.println(tempShark.getRandomFacts());
                    break;

                case 6:
                    Animal tempPenguin = new Penguin("", "", 0,0,0);
                    System.out.println(tempPenguin.getRandomFacts());
                    break;

                case 7:
                    Animal tempCroc = new Crocodile("", "", 0,0,0);
                    System.out.println(tempCroc.getRandomFacts());
                    break;

                case 8:
                    Animal tempPython = new Python("", "", 0,0,0);
                    System.out.println(tempPython.getRandomFacts());
                    break;

                case 9:
                    Animal tempCaecilian = new Caecilian("", "", 0,0,0);
                    System.out.println(tempCaecilian.getRandomFacts());
                    break;
            }
        } while (choice !=0);
    }

    //store menu custom feature
    private static void getZooStoreMenu(Visitor visitor) {
        GiftShop giftShop = new GiftShop();
        Cafe cafe = new Cafe();
        DonationStand donationStand = new DonationStand();

        int choice;
        do {
            System.out.println("\n---------");
            System.out.println("--- Which store do you want to visit?");
            System.out.println("---------");
            System.out.println("1. Visit the Cafe");
            System.out.println("2. Visit the Gift shop");
            System.out.println("3. Visit the Donation stand");
            System.out.println("4. Check your balance");
            System.out.println("5. Add funds to your balance");
            System.out.println("0. Return to Main Menu");


            choice = getValidMenuChoice("Enter Choice: ", 0, 5);

            switch (choice) {
                case 1:
                    visitStore(cafe, visitor);
                    break;

                case 2:
                    visitStore(giftShop, visitor);
                    break;

                case 3:
                    visitStore(donationStand, visitor);
                    break;

                case 4:
                    System.out.println("\n---------");
                    System.out.println("Balance: " + visitor.getBalance());
                    System.out.println("---------");
                    break;

                case 5:
                    double amount = getValidDouble("Enter amount to add: ");
                    visitor.deposit(amount);
                    break;

            }
        }while (choice !=0);
    }//get zoo store menu

    //store logic
    public static void visitStore(Store store, Visitor visitor) {

        int choice;

        do {
            System.out.println("\n---------");
            store.displayItems();
            System.out.println("0. Return to Stores Menu");

            choice = getValidMenuChoice("Select item to buy: ", 0, store.getItemCount());

            if (choice ==0) {
                return;
            }

            store.buyItem(choice - 1, visitor);

            boolean repeat = getValidBoolean("Buy another item? (yes/no): ");

            if (!repeat) {
                return;
            }
        } while (true);
    }// visit store loop

    //set scanner method for testing
    public static void setScanner(Scanner newScanner) {
        userInput = newScanner;
    }

}//class
