package fr.isep.mybouffetest.Search;


public class FoodModel {
    String foodName;
    int image;


    public FoodModel(String foodName, int image){
        this.foodName = foodName;
        this.image = image;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


}
