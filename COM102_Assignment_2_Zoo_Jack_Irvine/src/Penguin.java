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
        return "gak, gak";
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

    public void setSwimSpeed() {
        System.out.print("Enter the new swim speed for " + name + ": ");
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

}//class
