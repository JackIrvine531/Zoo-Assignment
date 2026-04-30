import java.util.ArrayList;

public abstract class Store {

    protected String name;
    protected ArrayList<Item> items;

    //constructor
    public Store(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public abstract void displayItems();
    public abstract void buyItem(int index, Visitor visitor);
    public abstract int getItemCount();

}//class
