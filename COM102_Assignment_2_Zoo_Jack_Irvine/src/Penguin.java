import java.util.Scanner;

public class Penguin extends Animal implements Swimable {
//    instance variable
    private int swimSpeed = 0;

//    scanner setup
    Scanner input = new Scanner(System.in);

//    constructor
    Penguin(String name, String colour, int age, double weight, int swimSpeed){
        super(name, colour, age, weight);
        this.swimSpeed = swimSpeed;
    }

//  getters
    @Override
    public String makeSound() {
        return "gak, gak, I am" + name + " a " + age + " year old " + this.getClass().getSimpleName();
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

    @Override
    public void getTypeTrait() {
        System.out.println(swimSpeed + " MPH");
    }

    public void displayDetails() {

        String details = "Name: " + name + "\n" +
                "Colour: " + colour + "\n" +
                "Age: " + age + "\n" +
                "Weight: " + weight + "kg\n" +
                "Swim Speed: " + swimSpeed + "\n";

        System.out.println(details);
    }

//    setters
    @Override
    public void setName() {
        System.out.print("Enter the new name for the penguin: ");
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
        System.out.print("Enter the new weight for " + name + " in kg: ");
        this.weight = input.nextDouble();
    }

    @Override
    public void setTypeTrait() {
        System.out.print("Enter the new swim speed in MPH for " + name + ": ");
        this.swimSpeed = input.nextInt();
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
    public void checkWaterConditions() {
        System.out.println("The water in " + name + "'s habitat is in good condition");
    }

}//class
