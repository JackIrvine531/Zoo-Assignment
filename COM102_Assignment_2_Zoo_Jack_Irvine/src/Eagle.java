import java.util.Scanner;

public class Eagle extends Animal implements Flyable{
//    instance variable
    private double wingSpan = 0;

//    scanner setup
    Scanner input = new Scanner(System.in);

//    constructor
    Eagle(String name, String colour, int age, double weight, double wingSpan){
        super(name, colour, age, weight);
        this.wingSpan = wingSpan;
    }

//    getters
    @Override
    public String makeSound() {
        return "kee-kee-kee, I am" + name + " a " + age + " year old " + this.getClass().getSimpleName();
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

    public double getWingSpan() {
        return wingSpan;
    }

    public void displayDetails() {

        String details = "Name: " + name + "\n" +
                "Colour: " + colour + "\n" +
                "Age: " + age + "\n" +
                "Weight: " + weight + "\n" +
                "Wingspan: " + wingSpan + "\n";

        System.out.println(details);
    }

//    setters

    @Override
    public void setName() {
        System.out.print("Enter the new name for the eagle: ");
        this.name = input.nextLine();
    }

    @Override
    public void setColour() {
        System.out.print("Enter the colour for " + name + ": ");
        this.colour = input.nextLine();

    }

    @Override
    public void setAge() {
        System.out.print("Enter the age for " + name + ": ");
        this.age = input.nextInt();
    }

    @Override
    public void setWeight() {
        System.out.print("Enter the weight for " + name + " in kg: ");
        this.weight = input.nextDouble();
    }

    public void setWingSpan() {
        System.out.print("Enter the wing span for " + name + " in meters: ");
        this.wingSpan = input.nextDouble();
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
