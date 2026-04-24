import java.util.Scanner;

public class Caecilians extends Animal implements Slitherable {
//    instance variable
    private int burrowDepth = 0;

//    scanner setup
    Scanner input = new Scanner(System.in);

//    constructor
    Caecilians(String name, String colour, int age, double weight, int burrowDepth) {
        super(name, colour, age, weight);
        this.burrowDepth = burrowDepth;
    }


//    getters
    @Override
    public String makeSound() {
        return "click, click";
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

    public int getBurrowDepth() {
        return burrowDepth;
    }

//    setters

    @Override
    public void setName() {
        System.out.print("Enter the new name for the caecilian: ");
        this.name = input.nextLine();
    }

    @Override
    public void setColour() {
        System.out.print("Enter the new colour for " + name + ": ");
        this.name = input.nextLine();
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

    public void setBurrowDepth() {
        System.out.print("Enter the new burrow depth for " + name + ": ");
        this.burrowDepth = input.nextInt();
    }

//    slitherable interface

    @Override
    public void slither() {
        System.out.println(name + " is slithering about");
    }

    @Override
    public void shedSkin() {
        System.out.println(name + " is shedding its skin");
    }

}//class
