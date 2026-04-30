import java.util.Random;

public class Toucan extends Animal implements Flyable {
//    instance variable
    private double beakLength;

//    constructor
    Toucan(String name, String colour, int age, double weight, double beakLength){
        super(name, colour, age, weight);
        this.beakLength = beakLength;
    }

// make sound
    @Override
    public String makeSound() {

        return "kreekk, kreekk, I am " + name +
                " a " + age + " year old " + this.getClass().getSimpleName();
    }

//    getters
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

    public double getBeakLength() {
        return beakLength;
    }

    public void displayDetails() {

        String details = "Name: " + name + "\n" +
                "Animal type: " + this.getClass().getSimpleName() + "\n" +
                "Colour: " + colour + "\n" +
                "Age: " + age + "\n" +
                "Weight: " + weight + "g\n" +
                "Beak Length: " + beakLength + "\n";

        System.out.println(details);
    }

    @Override
    public String getRandomFacts() {
        String[] facts = {
                "The Toco toucan has a massive beak, buts its surprisingly lightweight as its made of keratin with a honeycomb structure inside",
                "A toucans beak isn't just for show, it helps regulate body temperature by realising heat like a natural radiator",
                "Toucans sleep in tree holes and tuck their beaks under their wings curling up into a tiny ball to fit inside",
                "Toucans spend most of their lives in tress and are not great flyers, preferring to hop between branches"
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

    public void setBeakLength(double beakLength) {
        this.beakLength = beakLength;
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
        System.out.println(name + " is croaking");
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
