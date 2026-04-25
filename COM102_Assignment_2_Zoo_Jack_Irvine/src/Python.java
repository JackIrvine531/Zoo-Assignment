import java.util.Scanner;

public class Python extends Animal implements Slitherable {
//    instance variable
    private int tongueFlicksPerMin = 0;

//    Scanner setup
    Scanner input = new Scanner(System.in);

//    constructor
    Python(String name, String colour, int age, double weight, int tongueFlicksPerMin){
        super(name, colour, age, weight);
        this.tongueFlicksPerMin =  tongueFlicksPerMin;
    }

//    getters

    @Override
    public String makeSound() {
        return "sssssss, I am" + name + " a " + age + " year old " + this.getClass().getSimpleName();
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

    public int getTongueFlicksPerMin() {
        return tongueFlicksPerMin;
    }

    public void displayDetails() {

        String details = "Name: " + name + "\n" +
                "Colour: " + colour + "\n" +
                "Age: " + age + "\n" +
                "Weight: " + weight + "\n" +
                "Tongue Flicks Per Minute: " + tongueFlicksPerMin + "\n";

        System.out.println(details);
    }

//    setters

    @Override
    public void setName() {
        System.out.print("Enter the new name for the python: ");
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

    public void setTongueFlicksPerMin() {
        System.out.print("Enter the new tongue flicks per minute for " + name + ": ");
        this.tongueFlicksPerMin = input.nextInt();
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
