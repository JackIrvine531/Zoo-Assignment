import java.util.Scanner;

public class Crocodile extends Animal implements Slitherable, Swimable{
//    instance variable
    private double biteForce = 0;

//    scanner setup
    Scanner input = new Scanner(System.in);

//    constructor
    Crocodile(String name, String colour, int age, double weight, double biteForce) {
        super(name, colour, age, weight);
        this.biteForce = biteForce;
    }

//    getters

    @Override
    public String makeSound() {
        return "Hsssss, I am" + name + " a " + age + " year old " + this.getClass().getSimpleName();
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
        System.out.println(biteForce + " PSI");
    }

    public void displayDetails() {

        String details = "Name: " + name + "\n" +
                "Colour: " + colour + "\n" +
                "Age: " + age + "\n" +
                "Weight: " + weight + "kg\n" +
                "Bite Force: " + biteForce + "\n";

        System.out.println(details);
    }

//    setters

    @Override
    public void setName() {
        System.out.print("Enter a new name for the crocodile: ");
        this.name = input.nextLine();

    }

    @Override
    public void setColour() {
        System.out.print("Enter a new colour for " + name + ": ");
        this.colour = input.nextLine();
    }

    @Override
    public void setAge() {
        System.out.print("Enter a new age for " + name + ": ");
        this.age = input.nextInt();
    }

    @Override
    public void setWeight() {
        System.out.print("Enter a new weight for " + name + " in kg: ");
        this.weight = input.nextDouble();
    }

    @Override
    public void setTypeTrait() {
        System.out.print("Enter a new bite force for " + name + " in PSI: ");
        this.biteForce = input.nextDouble();
    }

//    slitherable interface

    @Override
    public void slither() {
        System.out.println(name + " slithered about");
    }

    @Override
    public void shedSkin() {
        System.out.println(name + " started to shed its skin");
    }

    @Override
    public void checkSkinConditions() {
        System.out.println(name + "'s skin is in good condition");
    }

//    swimable interface

    @Override
    public void swim() {
        System.out.println(name + " is swimming around");
    }

    @Override
    public void dive() {
        System.out.println(name + " has dove underwater");
    }

    @Override
    public void checkWaterConditions() {
        System.out.println("The water in " + name + "'s habitat is in good condition");
    }

}//class
