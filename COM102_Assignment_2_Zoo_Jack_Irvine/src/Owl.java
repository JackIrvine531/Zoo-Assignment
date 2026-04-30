import java.util.Random;

public class Owl extends Animal implements Flyable {

//    instance variable
    private int hearingRange;

//    constructor
    Owl(String name, String colour, int age, double weight, int hearingRange){
        super(name, colour, age, weight);
        this.hearingRange = hearingRange;
    }

//  getters
    @Override
    public String makeSound() {
        return "Hoo, Hoo, I am " + name + " a " + age + " year old " + this.getClass().getSimpleName();
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


    public void getHearingRange() {
        System.out.println(hearingRange + " Meters");
    }

    public void displayDetails() {

        String details = "Name: " + name + "\n" +
                "Animal type: " + this.getClass().getSimpleName() + "\n" +
                "Colour: " + colour + "\n" +
                "Age: " + age + "\n" +
                "Weight: " + weight + "kg\n" +
                "Hearing Range: " + hearingRange + "\n";
        System.out.println(details);
    }

    @Override
    public String getRandomFacts() {
        String[] facts = {
                "Owls can rotate their heads up to 270 degrees thanks to extra neck vertebrae and special blood vessels",
                "An owls feathers are specially adapted to muffle sound making them almost completely silent when flying",
                "Owls have excellent low-light vision, but their eyes are so large and fixed they cannot move them, which is why they rely on head rotation",
                "Despite their reputation for being wise, they are not especially intelligent compared to other birds such as crows or parrots"
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

    public void setHearingRange(int hearingRange) {
        this.hearingRange = hearingRange;
    }

//    flyable interface

    @Override
    public void fly() {
        System.out.println(name + " has took off flying");
    }

    @Override
    public void land() {
        System.out.println(name + " has landed");
    }

    @Override
    public void chirp() {
        System.out.println(name + " is hooting");
    }

    @Override
    public void roost() {
        System.out.println(name + " is roosting");
    }

    @Override
    public void cleanSelf() {
        System.out.println(name + " is cleaning its feathers");
    }

    @Override
    public void performWingCheck() {
        System.out.println(name + "'s wings are in good condition");
    }

}//class
