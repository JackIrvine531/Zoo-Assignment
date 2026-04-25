import java.util.Scanner;

public class Toucan extends Animal implements Flyable {
//    instance variable
    private double beakLength = 0;

//    scanner setup
    Scanner input = new Scanner(System.in);

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

    @Override
    public void getTypeTrait() {
        System.out.println(beakLength + "cm");
    }

    public void displayDetails() {

        String details = "Name: " + name + "\n" +
                "Colour: " + colour + "\n" +
                "Age: " + age + "\n" +
                "Weight: " + weight + "g\n" +
                "Beak Length: " + beakLength + "\n";

        System.out.println(details);
    }

//    setters
    @Override
    public void setName() {
        System.out.print("Enter the new name for the toucan: ");
        this.name = input.nextLine();
    }

    @Override
    public void setColour() {
        System.out.print("Enter the new colour for " + name + ": ");
        this.colour = input.nextLine();
    }

    @Override
    public void setAge() {
        System.out.print("Enter the new age for " + name + ": ");
        this.age = input.nextInt();
    }

    @Override
    public void setWeight() {
        System.out.print("Enter the new weight for " + name + " in grams: ");
        this.weight = input.nextDouble();
    }

    @Override
    public void setTypeTrait() {
        System.out.print("Enter the new beak length for " + name + " in cm: ");
        this.beakLength = input.nextDouble();
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
    public void performWingCheck() {
        System.out.println(name + "'s wings are in good condition");
    }
}//class
