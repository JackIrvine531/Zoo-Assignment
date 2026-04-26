import java.util.ArrayList;

public class Zoo {

    private String zooName = "Belfast city zoo";
    private final ArrayList<Animal> animals;


    public Zoo(String zooName){
        this.zooName = zooName;
        this.animals = new ArrayList<>();
    }

    //add animals
    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println("---------");
        System.out.println(animal.getName() + " added to the zoo.");
        System.out.println("---------");
    }

    //    remove animal by name
    public void removeAnimal(String name) {

        Animal toRemove = null;

        for (Animal a : animals) {
            if (a.getName().equalsIgnoreCase(name)) {
                toRemove = a;
                break;
            }//inner if
        }//outer for

        if (toRemove != null) {
            animals.remove(toRemove);
            System.out.println(name + " has gone to a farm in the countryside");
        } else {
            System.out.println(name + " not found");
        }

    }// remove animal from zoo

    //    update animal details
    public void updateDetails(String name, String newColour, int newAge, double newWeight) {
        for (Animal a: animals) {
            if (a.getName().equalsIgnoreCase(name)) {

                a.setName(name);
                a.setColour(newColour);
                a.setAge(newAge);
                a.setWeight(newWeight);

                System.out.println(name + " updated successfully");
                return;
            }else {
                System.out.println("Animal not found");
            }
        }
    }//update details

//    search if animal exists before updating details
    public Animal findAnimal(String name) {
        for (Animal a : animals) {
            if (a.getName().equalsIgnoreCase(name)) {
                return a;
            }
        }

        return null;
    }

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

    public void displayAllAnimals() {
        if (animals.isEmpty()) {
            System.out.println("There are no animals in the Zoo");
            return;
        }

        System.out.println("--- Animals in " + zooName + " ---");
        int count = 1;
        for (Animal a : animals) {
            System.out.println("Animal No: " + count);
            a.displayDetails();
            System.out.println("---------");
            count++;
        }
    }//display details

    public void searchByName(String name) {
        boolean found = false;

        for (Animal a : animals) {
            if (a.getName().equalsIgnoreCase(name)) {
                System.out.println("---------");
                System.out.println(a.getName() + " found: ");
                a.displayDetails();
                System.out.println(a.makeSound());

                found = true;
                System.out.println("---------");
            }//inner if
        }//outer for

        if (!found) {
            System.out.println("---------");
            System.out.println("No animal found with that name");
            System.out.println("---------");
        }

    }//search by name

    public void searchByColour(String colour) {
        boolean found = false;

        for (Animal a : animals) {
            if (a.getColour().equalsIgnoreCase(colour)) {
                System.out.println("---------");
                System.out.println("Animals of that colour found:");
                a.displayDetails();
                System.out.println(a.makeSound());

                found = true;
                System.out.println("---------");
            }//inner if
        }//outer for

        if (!found) {
            System.out.println("---------");
            System.out.println("No animals found with that colour");
            System.out.println("---------");
        }

    }//search by colour

//    getters

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public String getZooName() {
        return zooName;
    }



}//class
