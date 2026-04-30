import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

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

//    get animal type
    public ArrayList<Animal> getAnimalType(Class<?> type) {
        ArrayList<Animal> results = new ArrayList<>();

        for (Animal a : animals) {
            if (type.isInstance(a)) {
                results.add(a);
            }
        }
        return results;
    }

    //save zoo details
    public void saveZooDetails() {
        try (FileWriter writer = new FileWriter("zooDetails.txt")) {

            writer.write("Zoo Name: " + zooName + "\n");
            writer.write("Total Animals: " + animals.size() + "\n");

        } catch (IOException e) {
            System.out.println("Error saving zoo details");
        }
    }

    //save animal details
    public void saveAnimalDetails() {
        try (FileWriter writer = new FileWriter("AnimalDetails.txt")) {
            for (Animal a : animals) {

                //skip invalid animals
                if (a == null || !a.isValid()) {
                    continue;
                } else {
                    writer.write("Type: " + a.getClass().getSimpleName() + "\n");
                    writer.write("Name: " + a.getName() + "\n");
                    writer.write("Age: " + a.getAge() + "\n");
                    writer.write("Colour: " + a.getColour() + "\n");
                    writer.write("Weight: " + a.getWeight() + "\n");

                    if (a instanceof Eagle) {
                        writer.write("WingSpan: " + ((Eagle) a).getWingSpan() + "\n");
                    }

                    if (a instanceof Toucan) {
                        writer.write("Beak Length: " + ((Toucan) a).getBeakLength() + "\n");
                    }

                    if (a instanceof Owl) {
                        writer.write("Hearing Range: " + ((Owl) a).getHearingRange() + "\n");
                    }

                    if (a instanceof Hippo) {
                        writer.write("Hungry Hippo: " + ((Hippo) a).getHungryHippo() + "\n");
                    }

                    if (a instanceof Shark) {
                        writer.write("Num Teeth: " + ((Shark) a).getNumTeeth() + "\n");
                    }

                    if (a instanceof Penguin) {
                        writer.write("Swim Speed: " + ((Penguin) a).getSwimSpeed() + "\n");
                    }

                    if (a instanceof Crocodile) {
                        writer.write("Bite Force: " + ((Crocodile) a).getBiteForce() + "\n");
                    }

                    if (a instanceof Python) {
                        writer.write("Tongue Flicks Per Minute: " + ((Python) a).getTongueFlicksPerMin() + "\n");
                    }

                    if (a instanceof Caecilian) {
                        writer.write("Burrow Depth: " + ((Caecilian) a).getBurrowDepth() + "\n");
                    }

                    writer.write("---------");
                }//if else
            } //for

        } catch (IOException e) {
            System.out.println("Error saving animal details");
        }
    }// save animal details

    //load zoo details
    public void loadZooDetails() {

        try (BufferedReader reader = new BufferedReader(new FileReader("zooDetails.txt"))) {
            String line;

            while((line = reader.readLine()) != null) {

                if (line.startsWith("Zoo Name: ")) {
                    this.zooName = line.substring(10);
                }
            }
        } catch (IOException e) {
            System.out.println("No previous zoo data found");
        }//try catch
    }//load zoo details

    public void loadAnimalDetails() {

        try (BufferedReader reader = new BufferedReader(new FileReader("AnimalDetails.txt"))) {

            String line;

            String type = "";
            String name = "";
            String colour = "";
            int age = 0;
            double weight = 0;

            //instance variables
            double wingSpan = 0;
            double beakLength = 0;
            int hearingRange = 0;
            boolean hungryHippo = false;
            int numTeeth = 0;
            int swimSpeed = 0;
            double biteForce = 0;
            int tongueFlicksPerMin = 0;
            int burrowDepth = 0;

            while ((line = reader.readLine()) !=null) {

                if (line.startsWith("Type: ")) {
                    type = line.substring(6);
                } else if (line.startsWith("Name: ")) {
                    name = line.substring(6);

                } else if (line.startsWith("Age: ")) {
                    age = Integer.parseInt(line.substring(5));

                } else if (line.startsWith("Colour: ")) {
                    colour = line.substring(8);

                } else if (line.startsWith("Weight: ")) {
                    weight = Double.parseDouble(line.substring(8));

                } else if (line.startsWith("WingSpan: ")) {
                    wingSpan = Double.parseDouble(line.substring(10));

                } else if (line.startsWith("Beak Length: ")) {
                    beakLength = Double.parseDouble(line.substring(13));

                } else if (line.startsWith("Hearing Range: ")) {
                    hearingRange = Integer.parseInt(line.substring(15));

                } else if (line.startsWith("Hungry Hippo: ")) {
                    hungryHippo = Boolean.parseBoolean(line.substring(15));

                } else if (line.startsWith("Num Teeth: ")) {
                    numTeeth = Integer.parseInt(line.substring(11));

                } else if (line.startsWith("Swim Speed: ")) {
                    swimSpeed = Integer.parseInt(line.substring(12));

                } else if (line.startsWith("Bite Force: ")) {
                    biteForce = Double.parseDouble(line.substring(12));

                } else if (line.startsWith("Tongue Flicks Per Minute: ")) {
                    tongueFlicksPerMin = Integer.parseInt(line.substring(26));

                } else if (line.startsWith("Burrow Depth: ")) {
                    burrowDepth = Integer.parseInt(line.substring(14));

                } else if (line.startsWith("---------")) {

                    //create animal from loaded data
                    Animal animal = null;

                    switch (type) {

                        case "Eagle":
                            animal = new Eagle(name, colour, age, weight, wingSpan);
                            break;

                        case "Toucan":
                            animal = new Toucan(name, colour, age, weight, beakLength);
                            break;

                        case "Owl":
                            animal = new Owl(name, colour, age, weight, hearingRange);
                            break;

                        case "Hippo":
                            animal = new Hippo(name, colour, age, weight, hungryHippo);
                            break;

                        case "Shark":
                            animal = new Shark(name, colour, age, weight, numTeeth);
                            break;

                        case "Penguin":
                            animal = new Penguin(name, colour, age, weight, swimSpeed);
                            break;

                        case "Crocodile":
                            animal = new Crocodile(name, colour, age, weight, biteForce);
                            break;

                        case "Python":
                            animal = new Python(name, colour, age, weight, tongueFlicksPerMin);
                            break;

                        case "Caecilian":
                            animal = new Caecilian(name, colour, age, weight, burrowDepth);
                            break;
                    }

                    // add valid animals
                    if (animal != null && animal.isValid()) {
                        animals.add(animal);
                    }

                    //reset for next animal
                    type = "";
                    name = "";
                    colour = "";
                    age = 0;
                    weight = 0;

                    //instance variables
                    wingSpan = 0;
                    beakLength = 0;
                    hearingRange = 0;
                    hungryHippo = false;
                    numTeeth = 0;
                    swimSpeed = 0;
                    biteForce = 0;
                    tongueFlicksPerMin = 0;
                    burrowDepth = 0;

                }// else ifs
            }// while

        } catch (IOException e) {
            System.out.println("No animal data found");
        }//try catch
    }//load animal details

}//class
