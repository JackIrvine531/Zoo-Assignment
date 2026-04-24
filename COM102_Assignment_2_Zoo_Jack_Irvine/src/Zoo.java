import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Zoo {

    private String zooName = "Belfast city zoo";
    private ArrayList<Animal> animals;
    Scanner input = new Scanner(System.in);
    int choice;


    public Zoo(String zooName){
        this.zooName = zooName;
        this.animals = new ArrayList<>();
    }

    //add animals
    public void addAnimal() {
        do {
            System.out.println("--- add animal menu ---");
            System.out.println("What type of animal do you want to add?");
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

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    Eagle eagle = new Eagle(" ", " ", 0, 0, 0);
                    eagle.setName();
                    eagle.setColour();
                    eagle.setAge();
                    eagle.setWeight();
                    eagle.setWingSpan();
                    animals.add(eagle);
                    System.out.println(eagle.getName() + " has been added to the zoo");
                    break;

                case 2:
                    Toucan toucan = new Toucan(" ", " ", 0, 0, 0);
                    toucan.setName();
                    toucan.setColour();
                    toucan.setAge();
                    toucan.setWeight();
                    toucan.setBeakLength();
                    animals.add(toucan);
                    System.out.println(toucan.getName() + " has been added to the zoo");
                    break;

                case 3:
                    Owl owl = new Owl(" ", " ", 0, 0, 0);
                    owl.setName();
                    owl.setColour();
                    owl.setAge();
                    owl.setWeight();
                    owl.setHearingRange();
                    animals.add(owl);
                    System.out.println(owl.getName() + " has been added to the zoo");
                    break;

                case 4:
                    Hippo hippo = new Hippo(" ", " ", 0, 0, false);
                    hippo.setName();
                    hippo.setColour();
                    hippo.setAge();
                    hippo.setWeight();
                    hippo.setHungryHippo();
                    animals.add(hippo);
                    System.out.println(hippo.getName() + " has been added to the zoo");
                    break;

                case 5:
                    Shark shark = new Shark(" ", " ", 0,0,0);
                    shark.setName();
                    shark.setColour();
                    shark.setAge();
                    shark.setWeight();
                    shark.setNumTeeth();
                    animals.add(shark);
                    System.out.println(shark.getName() + " has been added to the zoo");
                    break;

                case 6:
                    Penguin penguin = new Penguin(" ", " ", 0,0,0);
                    penguin.setName();
                    penguin.setColour();
                    penguin.setAge();
                    penguin.setWeight();
                    penguin.setSwimSpeed();
                    animals.add(penguin);
                    System.out.println(penguin.getName() + " has been added to the zoo");
                    break;

                case 7:
                    Crocodile croc = new Crocodile(" ", " ", 0,0,0);
                    croc.setName();
                    croc.setColour();
                    croc.setAge();
                    croc.setWeight();
                    croc.setBiteForce();
                    animals.add(croc);
                    System.out.println(croc.getName() + " has been added to the zoo");
                    break;

                case 8:
                    Python python = new Python(" ", " ", 0,0,0);
                    python.setName();
                    python.setColour();
                    python.setAge();
                    python.setWeight();
                    python.setTongueFlicksPerMin();
                    animals.add(python);
                    System.out.println(python.getName() + " has been added to the zoo");
                    break;

                case 9:
                    Caecilians caecil = new Caecilians(" ", " ", 0,0,0);
                    caecil.setName();
                    caecil.setColour();
                    caecil.setAge();
                    caecil.setWeight();
                    caecil.setBurrowDepth();
                    animals.add(caecil);
                    System.out.println(caecil.getName() + " has been added to the zoo");
                    break;
            }
        } while (choice !=0);
    }

    //    remove animal by name
    public void removeAnimal(String name) {
        Animal toRemove = null;

        for (Animal a : animals) {
            if (a.getName().equalsIgnoreCase(name)) {
                toRemove = a;
                break;
            }//inner if
        }//outter for

        if (toRemove != null) {
            animals.remove(toRemove);
            System.out.println(name + " has gone to a farm in the countryside");
        } else {
            System.out.println(name + " not found");
        }
    }// remove animal from zoo

    //    update animal details
    public void updateDetails(String name) {
        for (Animal a : animals) {
            if (a.getName().equalsIgnoreCase(name)) {

                do {
                    System.out.println("--- update menu ---");
                    System.out.println("1. update name");
                    System.out.println("2. update colour");
                    System.out.println("3. update age");
                    System.out.println("4. update weight");
                    System.out.println("5. back to menu");

                    choice = input.nextInt();
                    input.nextLine(); //clear buffer

                    switch (choice) {
                        case 1: a.setName();
                            break;

                        case 2: a.setColour();
                            break;

                        case 3: a.setAge();
                            break;

                        case 4: a.setWeight();
                            break;

                        case 5: System.out.println("exiting update menu");
                            break;
                    }//switch


                } while (choice !=0);
            }// inner if
        }//outter for
    }//update details


    public void zooReport() {
        ArrayList<String> animalTypes = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();
        ArrayList<ArrayList<String>> colourLists = new ArrayList<>();

        for (Animal currAnimal : animals) {
            String type = currAnimal.getClass().getSimpleName();
            String colour = currAnimal.getColour();

            int index = animalTypes.indexOf(type);

            //add new animal type to list
            if (index == -1) {
                animalTypes.add(type);
                counts.add(1);

                ArrayList<String> colours = new ArrayList<>();
                colours.add(colour);
                colourLists.add(colours);

            } else {
                counts.set(index, counts.get(index) + 1);
                colourLists.get(index).add(colour);
            }//else
        }//for

        // print report
        System.out.println("--- Zoo Report ---");
        System.out.println("Zoo name: " + zooName);

        for (int i = 0; i< animalTypes.size(); i++) {
            String type = animalTypes.get(i);
            int count = counts.get(i);
            ArrayList<String> colours = colourLists.get(i);

            String dominantColour = getDominantColour(colours);

            System.out.println("Animal: " + type);
            System.out.println("Count: " + count);
            System.out.println("Dominant colour: " + dominantColour);
            System.out.println("-----------------------");
        }//for

    }//zooReport

    private String getDominantColour(ArrayList<String> colours) {
        String dominant = "";
        int maxCount = 0;

        for (int i =0; i< colours.size(); i++) {
            String current = colours.get(i);
            int count = 0;

            for (int n = 0; n < colours.size(); n++) {
                if (colours.get(n).equals(current)) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                dominant = current;
            }
        }

        return dominant;
    }//get dominant colour

}//class
