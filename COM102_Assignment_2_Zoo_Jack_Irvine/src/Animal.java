public abstract class Animal {
//    protected for subclass access not global access
    protected String name, colour;
    protected int age;
    protected double weight;

//constructor
    Animal(String name, String colour, int age, double weight){
        this.name = name;
        this.colour = colour;
        this.age = age;
        this.weight = weight;
    }

    public abstract String makeSound();

    //    getters
    public abstract String getName();
    public abstract String getColour();
    public abstract int getAge();
    public abstract double getWeight();
    public abstract void displayDetails();

    //    setters
    public abstract void setName(String name);
    public abstract void setColour(String colour);
    public abstract void setAge(int age);
    public abstract void setWeight(Double weight);

}//class
