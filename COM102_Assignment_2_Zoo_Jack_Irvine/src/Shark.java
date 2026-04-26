public class Shark extends Animal implements Swimable {

//    instance variable
    private int numTeeth;

//    constructor
    Shark(String name, String colour, int age, double weight, int numTeeth){
        super(name, colour, age, weight);
        this.numTeeth = numTeeth;
    }

//    getters

    @Override
    public String makeSound() {
        return "blub, blub, I am " + name +
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

    public void getNumTeeth() {
        System.out.println(numTeeth);
    }

    public void displayDetails() {

        String details = "Name: " + name + "\n" +
                "Animal type: " + this.getClass().getSimpleName() + "\n" +
                "Colour: " + colour + "\n" +
                "Age: " + age + "\n" +
                "Weight: " + weight + "kg\n" +
                "Number of Teeth: " + numTeeth + "\n";

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

    public void setNumTeeth(int numTeeth) {
        this.numTeeth = numTeeth;
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
