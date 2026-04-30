import java.util.Random;

public class Penguin extends Animal implements Swimable {
//    instance variable
    private int swimSpeed;

//    constructor
    Penguin(String name, String colour, int age, double weight, int swimSpeed){
        super(name, colour, age, weight);
        this.swimSpeed = swimSpeed;
    }

//  getters
    @Override
    public String makeSound() {
        return "gak, gak, I am " + name + " a " + age + " year old " + this.getClass().getSimpleName();
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


    public int getSwimSpeed() {
        return swimSpeed;
    }

    public void displayDetails() {

        String details = "Name: " + name + "\n" +
                "Animal type: " + this.getClass().getSimpleName() + "\n" +
                "Colour: " + colour + "\n" +
                "Age: " + age + "\n" +
                "Weight: " + weight + "kg\n" +
                "Swim Speed: " + swimSpeed + "\n";

        System.out.println(details);
    }

    @Override
    public String getRandomFacts() {
        String[] facts = {
                "Penguins when swimming can reach speeds of up to 24kmh/15MPH",
                "Not all penguins live in Antarctica with species like the Galapagos penguin living near the equator",
                "Penguins have a thick layer of fat and dense waterproof feathers to survive freezing conditions",
                "The Emperor penguin can dive over 500 meters deep and stay underwater for more than 20 minutes"
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


    public void setSwimSpeed(int swimSpeed) {
        this.swimSpeed = swimSpeed;
    }

//    swimable interface
    @Override
    public void swim() {
        System.out.println(name + " has gone for a swim");
    }

    @Override
    public void dive() {
        System.out.println(name + " has dove deeper in the water");
    }

    @Override
    public void rise() {
        System.out.println(name + " has risen in the water a bit");
    }

    @Override
    public void hide() {
        System.out.println(name + " has hidden from view");
    }

    @Override
    public void unhide() {
        System.out.println(name + " has returned to view after hiding");
    }

    @Override
    public void checkWaterConditions() {
        System.out.println("The water in " + name + "'s habitat is in good condition");
    }

}//class
