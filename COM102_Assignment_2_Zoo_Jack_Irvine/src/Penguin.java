public class Penguin extends Animal implements Swimable {
//    instance variable
    private int swimSpeed;

//    constructor
    Penguin(String name, String colour, int age, double weight, int swimSpeed){
        super(name, colour, age, weight);
        this.swimSpeed = swimSpeed;
    }

//  getters
    @Override
    public String makeSound() {
        return "gak, gak, I am " + name + " a " + age + " year old " + this.getClass().getSimpleName();
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


    public void getSwimSpeed() {
        System.out.println(swimSpeed + " MPH");
    }

    public void displayDetails() {

        String details = "Name: " + name + "\n" +
                "Animal type: " + this.getClass().getSimpleName() + "\n" +
                "Colour: " + colour + "\n" +
                "Age: " + age + "\n" +
                "Weight: " + weight + "kg\n" +
                "Swim Speed: " + swimSpeed + "\n";

        System.out.println(details);
    }

//    setters
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void setWeight(Double weight) {
        this.weight = weight;
    }


    public void setSwimSpeed(int swimSpeed) {
        this.swimSpeed = swimSpeed;
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
