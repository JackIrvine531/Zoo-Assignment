import java.util.Scanner;

public class Owl extends Animal implements Flyable {

//    instance variable
    private int hearingRange = 0;

//    scanner setup
    Scanner input = new Scanner(System.in);

//    constructor
    Owl(String name, String colour, int age, double weight, int hearingRange){
        super(name, colour, age, weight);
        this.hearingRange = hearingRange;
    }

//  getters
    @Override
    public String makeSound() {
        return "Hoo, Hoo, I am" + name + " a " + age + " year old " + this.getClass().getSimpleName();
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

    public int getHearingRange() {
        return hearingRange;
    }

    public void displayDetails() {

        String details = "Name: " + name + "\n" +
                "Colour: " + colour + "\n" +
                "Age: " + age + "\n" +
                "Weight: " + weight + "\n" +
                "Hearing Range: " + hearingRange + "\n";
        System.out.println(details);
    }

//    setters

    @Override
    public void setName() {
        System.out.print("Enter the new name for the owl: ");
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
        System.out.print("Enter the new weight for " + name + ": ");
        this.weight = input.nextDouble();
    }

    public void setHearingRange() {
        System.out.print("Enter the new hearing range for " + name + ": ");
        this.hearingRange = input.nextInt();
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

}//class
