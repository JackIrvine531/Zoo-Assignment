import java.util.Random;

public class Shark extends Animal implements Swimable {

//    instance variable
    private int numTeeth;

//    constructor
    Shark(String name, String colour, int age, double weight, int numTeeth){
        super(name, colour, age, weight);
        this.numTeeth = numTeeth;
    }

//    getters

    @Override
    public String makeSound() {
        return "blub, blub, I am " + name +
                " a " + age + " year old " + this.getClass().getSimpleName();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getColour() {
        return colour;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public int getNumTeeth() {
        return numTeeth;
    }

    public void displayDetails() {

        String details = "Name: " + name + "\n" +
                "Animal type: " + this.getClass().getSimpleName() + "\n" +
                "Colour: " + colour + "\n" +
                "Age: " + age + "\n" +
                "Weight: " + weight + "kg\n" +
                "Number of Teeth: " + numTeeth + "\n";

        System.out.println(details);
    }

    @Override
    public String getRandomFacts() {
        String[] facts = {
                "Sharks don't have bones, their skeletons are made of cartilage, the same flexible material in our nose and ears",
                "Sharks constantly lose and replace teeth, some can go through 20,000+ teeth in a lifetime",
                "Many sharks need to keep swimming to push water over their gills to breathe, though some species can rest on the seafloor",
                "Despite their reputation sharks rarely attack humans, in fact you're far more likely to be killed by a cow than a shark"
        };
        return facts[new Random().nextInt(facts.length)];
    }


    //    setters
    @Override
    public void setName(String name) {
        this.name = name;

    }

    @Override
    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public boolean isValid() {
        return name != null && !name.trim().isEmpty()
                && colour != null && !colour.trim().isEmpty()
                && age> 0
                && weight > 0;
    }

    public void setNumTeeth(int numTeeth) {
        this.numTeeth = numTeeth;
    }

//    swimable interface

    @Override
    public void swim() {
        System.out.println(name + " is swimming about");
    }

    @Override
    public void dive() {
        System.out.println(name + " has dived deeper");
    }

    @Override
    public void rise() {
        System.out.println(name + " has risen in the water");
    }

    @Override
    public void hide() {
        System.out.println(name + " has hidden from view");
    }

    @Override
    public void unhide() {
        System.out.println(name + " has returned into view after hiding");
    }

    @Override
    public void checkWaterConditions() {
        System.out.println("The water in " + name + "'s habitat is in good condition");
    }

}//class
