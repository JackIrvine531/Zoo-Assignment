public class GiftShop extends Store {

    public GiftShop() {
        super("Gift Shop");

        items.add(new Item("Eagle plush", 20));
        items.add(new Item("Toucan plush", 24));
        items.add(new Item("Owl plush", 20));
        items.add(new Item("Hippo plush", 25));
        items.add(new Item("Shark plush", 30));
        items.add(new Item("Penguin plush", 23));
        items.add(new Item("Crocodile plush", 30));
        items.add(new Item("Python plush", 20));
        items.add(new Item("Caecilian plush", 15));
        items.add(new Item("Zoo mug", 9.99));
        items.add(new Item("Zoo keyring", 5));
        items.add(new Item("Zoo T-shirt", 25));
        items.add(new Item("Zoo postcard", 2.99));
        items.add(new Item("Zoo magnet", 4.99));

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
