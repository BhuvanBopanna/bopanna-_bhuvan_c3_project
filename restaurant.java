import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
       LocalTime time = LocalTime.now();
       System.out.println("current time:"+time);
       if(time.isAfter(openingTime)&& time.isBefore(closingTime)) {
           return true;
       }
       else {
           return false;
       }
       }





    public LocalTime getCurrentTime(){ return  LocalTime.now(); }


    public List<Item> getMenu(){
        return this.menu;


    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }

    public boolean contains(String amelieCafe) {
        return true;
    }

    public  int calcTotal(List<String>myMenu){
        int totalValue = 0;
        for(String Item:myMenu){
        for(Item item:menu){
        if(myMenu.getName.equals(Item)){
      return totalValue = item.getPrice();
}
   }
}
}
}
