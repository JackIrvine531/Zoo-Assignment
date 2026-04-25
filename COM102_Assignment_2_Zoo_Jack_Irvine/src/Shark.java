import java.util.Scanner;

public class Shark extends Animal implements Swimable {

//    instance variable
    private int numTeeth = 0;

//    scanner setup
    Scanner input = new Scanner(System.in);

//    constructor
    Shark(String name, String colour, int age, double weight, int numTeeth){
        super(name, colour, age, weight);
        this.numTeeth = numTeeth;
    }

//    getters

    @Override
    public String makeSound() {
        return "blub, blub, I am" + name +
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

    @Override
    public void getTypeTrait() {
        System.out.println(numTeeth);
    }

    public void displayDetails() {

        String details = "Name: " + name + "\n" +
                "Colour: " + colour + "\n" +
                "Age: " + age + "\n" +
                "Weight: " + weight + "kg\n" +
                "Number of Teeth: " + numTeeth + "\n";

        System.out.println(details);
    }


//    setters
    @Override
    public void setName() {
        System.out.print("Enter the new name for the shark: ");
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
        System.out.print("Enter the new number of teeth for " + name + ": ");
        this.numTeeth = input.nextInt();
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
    public void checkWaterConditions() {
        System.out.println("The water in " + name + "'s habitat is in good condition");
    }

}//class
