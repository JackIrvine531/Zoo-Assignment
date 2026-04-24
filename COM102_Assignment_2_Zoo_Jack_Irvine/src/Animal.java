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

    //    setters
    public abstract void setName();
    public abstract void setColour();
    public abstract void setAge();
    public abstract void setWeight();

}//class
