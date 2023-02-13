package nerdschool.bar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Pub {
    public static final String HANSA = "hansa";
    public static final String GRANS = "grans";
    public static final String STRONGBOW = "strongbow";
    public static final String GT = "gt";
    public static final String BACARDI_SPECIAL = "bacardi_special";

    public static HashMap<String, Integer> drinkPrices;
    public static ArrayList<String> discountedDrinks;

    public Pub(){
         drinkPrices = new HashMap<String, Integer>();
         drinkPrices.put(HANSA, 74);
         drinkPrices.put(GRANS, 103);
         drinkPrices.put(STRONGBOW, 110);
         drinkPrices.put(GT, (getUnitPriceGin() + getUnitPriceTonic() +
                 getUnitPriceGreenStuff()));
         drinkPrices.put(BACARDI_SPECIAL, (getUnitPriceGin()/2 + getUnitPriceRum() +
                 getUnitPriceGrenadine() + getUnitPriceLime()));

         discountedDrinks = new ArrayList<>(Arrays.asList(GRANS, HANSA, STRONGBOW));
    }

    public int computeCost(String drink, boolean isStudent, int numberOfDrinks) {

        if (numberOfDrinks > 2 && (drink == GT || drink == BACARDI_SPECIAL)) {
            throw new RuntimeException("Too many drinks, max 2.");
        }
        Integer price = drinkPrices.get(drink);
        if (price == null){
            throw new RuntimeException("No such drink exists");
        }
        if (isStudent && (discountedDrinks.contains(drink))) {
            price = price - price/10;
        }
        return price*numberOfDrinks;
    }

    private int getUnitPriceRum() { return 65; }

    private int getUnitPriceGrenadine() { return 10; }

    private int getUnitPriceLime() { return 10; }

    private int getUnitPriceGreenStuff() { return 10; }

    private int getUnitPriceTonic() { return 20; }

    private int getUnitPriceGin() {
        return 85;
    }
}
