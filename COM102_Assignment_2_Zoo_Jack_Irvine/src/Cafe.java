public class Cafe extends Store{

    //constructor
    public Cafe() {
        super("Cafe");

        //items that will be displayed in the cafe menu
        items.add(new Item("Coffee", 4.5));
        items.add(new Item("Tea", 3));
        items.add(new Item("Sandwich", 4.5));
        items.add(new Item("Toastie", 5));
        items.add(new Item("Wrap", 4.5));
        items.add(new Item("Kids Zoo Meal", 4));
        items.add(new Item("Adult Zoo Meal", 6));
        items.add(new Item("Bottle of water", 2.5));
        items.add(new Item("Juice box", 4.5));

    }

    @Override
    public void displayItems() {
        System.out.println("--- " + name + " ---");
        for (int i =0; i< items.size(); i++) {
            Item item = items.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - £" + item.getPrice());

        }
    }

    @Override
    public void buyItem(int index, Visitor visitor) {

        //out of bounds
        if (index <0 || index >= items.size()) {
            System.out.println("Invalid Selection");
            return;
        }

        Item item = items.get(index);

        //pay for item if enough money
        if (visitor.withdraw(item.getPrice())) {
            System.out.println("You bought: " + item.getName());
        } else {
            System.out.println("Not enough balance, Transaction Canceled");
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}//class
