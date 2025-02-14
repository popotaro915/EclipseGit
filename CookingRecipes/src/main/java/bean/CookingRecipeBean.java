package bean;

import java.io.Serializable;

public class CookingRecipeBean implements Serializable {
    private String servings;
    private int[] Numbers;
    private int food_int;
    private double food_double;
    private int amount;
    
    public CookingRecipeBean() {
        
    }
    
    public void setServings(String servings) {
        this.servings = servings;
    }
    
    public void setNumbers(int[] Numbers) {
        this.Numbers = Numbers;
    }
    
    public void setFood_int(int food_int) {
        this.food_int = food_int;
    }
    
    public void setFood_double(double food_double) {
        this.food_double = food_double;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public String getServings() {
        return servings;
    }
    
    public int[] getNumbers() {
        return Numbers;
    }
    
    public int getFood_int() {
        return food_int;
    }
    
    public double getFood_double() {
        return food_double;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public int calc_int() {
        amount = food_int * Integer.parseInt(servings);
        return amount;
    }
    
    public String tablespoon() { //大さじ
        String result;
            if(food_int * Integer.parseInt(servings) > 5) {
                result = "大さじ" + food_int * Integer.parseInt(servings);
            } else {
                result = food_int * Integer.parseInt(servings) * 15 + "g"; //大さじ1=15g
            }
        return result;
    }
}
