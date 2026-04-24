import java.util.Scanner;

public class Hippo extends Animal implements Swimable {
//    instance variable
    private boolean hungryHippo = true;

//    scanner setup
    Scanner input = new Scanner(System.in);

//    constructor
    Hippo(String name, String colour, int age, double weight, boolean hungryHippo){
        super(name, colour, age, weight);
        this.hungryHippo = hungryHippo;
    }

//    getters

    @Override
    public String makeSound() {
        return "honk,honk,honk,honk,honk";
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

    public boolean getHungryHippo() {
        return hungryHippo;
    }

//    setters

    @Override
    public void setName() {
        System.out.print("Enter the new name for the hippo: ");
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

    public void setHungryHippo() {
        System.out.print("Is " + name + " a hungry hungry hippo? (true or false): ");
        this.name = input.nextLine();
    }

//    Swimable interface

    @Override
    public void swim() {
        System.out.println(name + " swims about for a bit");
    }

    @Override
    public void dive() {
        System.out.println(name + " has dived under the water");
    }
}//class
