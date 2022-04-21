import java.util.*;


public class ShoppingList {
    public static Scanner input;
    public static Map<String,Double> items = new TreeMap<>() ;
    public static List<String> orderNames = new ArrayList<>();

    public static List<Double> orderPrices = new ArrayList<>();
    public static void main(String[] args){
        input = new Scanner(System.in);
        fillItemsMap();

        while(true) {
            printMenu();
            System.out.println("What item would you like to order?");
            String itemName = input.nextLine();
            if (items.containsKey(itemName) == false) {
                itemNotExists();
                continue;
            }
            orderNames.add(itemName);

            Double itemPrice = items.get(itemName);
            orderPrices.add(itemPrice);
            System.out.println("Adding " + itemName + " to cart at $" + itemPrice);
            System.out.println("\n");
            System.out.println("Would you like to order anything else (y/n)?");
            String response = input.nextLine();
            System.out.println("\n");
            if(response.equals("y")){
               continue;
            }
            else
            {
                System.out.println("Thanks for your order!");
                System.out.println("Here's what you got:");
                for(int i=0;i<orderNames.size();i++){
                    System.out.println(orderNames.get(i)+ " \t " +"$"+orderPrices.get(i));
                }
                average();
                mostExpensive();
                minExpensive();


                break;
            }
        }

    }
    public static void fillItemsMap(){

        items.put("apple",0.99);
        items.put("banana",0.59);
        items.put("cauliflower",1.59);
        items.put("dragonfruit",2.19);
        items.put("elderberry",1.79);
        items.put("figs",2.09);
        items.put("grapefruit",1.99);
        items.put("honeydew",3.49);

    }
    public static void printMenu(){
        System.out.println("Welcome to Guenther's Market!\n");
        System.out.println("Item    \t  Price");
        System.out.println("=================================");
        for(Map.Entry<String,Double> entry: items.entrySet()){
            System.out.println(entry.getKey()+  "\t" +"$"+entry.getValue());
        }
        System.out.println("\n");

    }
    public static void itemNotExists(){
        System.out.println("Sorry, we don't have those. Please try again.");
    }
    public static void average(){
        Double avg=0.0;
        for(int i=0;i<orderPrices.size();i++){
            avg=avg+orderPrices.get(i);

        }
        avg=avg/orderPrices.size();
        System.out.println("Average price per item in order was "+avg);
    }
    public static void mostExpensive(){
        double cost=0.0;
        int ind=-1;
        for(int i=0;i<orderPrices.size();i++){
            if(orderPrices.get(i)> cost)
            {
                cost=orderPrices.get(i);
                ind=i;
            }

        }
        System.out.println("Most expensive ordered item was "+orderNames.get(ind)+" and cost is "+orderPrices.get(ind));
    }
    public static void minExpensive(){
        double cost=1000000000.0;
        int ind=-1;
        for(int i=0;i<orderPrices.size();i++){
            if(orderPrices.get(i)< cost)
            {
                cost=orderPrices.get(i);
                ind=i;
            }

        }
        System.out.println("Least expensive ordered item was "+orderNames.get(ind)+" and cost is "+orderPrices.get(ind));
    }
}