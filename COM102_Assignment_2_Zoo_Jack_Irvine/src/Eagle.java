import java.util.Random;

public class Eagle extends Animal implements Flyable{
//    instance variable
    private double wingSpan;

//    constructor
    Eagle(String name, String colour, int age, double weight, double wingSpan){
        super(name, colour, age, weight);
        this.wingSpan = wingSpan;
    }

//    getters
    @Override
    public String makeSound() {
        return "kee-kee-kee, I am " + name + " a " + age + " year old " + this.getClass().getSimpleName();
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


    public void getWingSpan() {
        System.out.println(wingSpan + " Meters");
    }

    public void displayDetails() {

        String details = "Name: " + name + "\n" +
                "Animal type: " + this.getClass().getSimpleName() + "\n" +
                "Colour: " + colour + "\n" +
                "Age: " + age + "\n" +
                "Weight: " + weight + "kg\n" +
                "Wingspan: " + wingSpan + "\n";

        System.out.println(details);
    }

    @Override
    public String getRandomFacts() {
        String[] facts = {
                "An eagles eyesight is 4-8 times better than humans, with some able to see a fish from over a mile away",
                "Eagles can carry prey that weighs as much as their own body weight",
                "Many eagles mate for life and return to the same nesting area every year",
                "Eagles live on every continent except Antarctica",
                "The sound a Bald eagle makes in US media is not the sound of a bald eagle but a red-tailed hawk, Bald eagles kind of sound like seagulls"
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

    public void setWingSpan(double wingSpan) {
        this.wingSpan = wingSpan;
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
        System.out.println(name + " is chirping");
    }

    @Override
    public void roost() {
        System.out.println(name + " is roosting");
    }

    @Override
    public void cleanSelf() {
        System.out.println(name + " is cleaning itself");
    }

    @Override
    public void performWingCheck() {
        System.out.println(name + "'s wings are in good condition");
    }
}//class
