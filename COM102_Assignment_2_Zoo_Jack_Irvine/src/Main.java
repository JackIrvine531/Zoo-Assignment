import java.util.Scanner;

void main() {
    //    scanner setup
        Scanner input = new Scanner(System.in);
        int choice;

        Zoo myZoo = new Zoo("Belfast city zoo");


        do {
            System.out.println("--- menu ---");
            System.out.println("1. add animal");
            System.out.println("2. remove animal");
            System.out.println("3. Edit animal details");
            System.out.println("4. Search Zoo for animals");
            System.out.println("5. display all animals details");
            System.out.println("6. display Zoo report");
            System.out.println("0. Exit the program");
            System.out.print("Input: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 0:
                    break;

                case 1:
                    myZoo.addAnimal();
                    break;

                case 2:
                    myZoo.removeAnimal();
                    break;

                case 3:
                    myZoo.updateDetails();
                    break;

                case 4:
                    myZoo.searchMenu();

                case 5:
                    myZoo.displayAllAnimals();
                    break;

                case 6:
                    myZoo.zooReport();
                    break;
            }

        }while (choice !=0);


    }//main
