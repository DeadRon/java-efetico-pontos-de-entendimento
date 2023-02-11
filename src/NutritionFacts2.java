public class NutritionFacts2 {

    private int servingsSize;
    private int servings;
    private int calories;
    private int fat;
    private int sodium;
    private int carbohydrate;

    public NutritionFacts2() {}

    public void setServingsSize(int servingsSize) {
        this.servingsSize = servingsSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public static void main(String... args){

        NutritionFacts2 cocaCola = new NutritionFacts2();
        cocaCola.setServings(8);
        cocaCola.setServingsSize(240);
        cocaCola.setCalories(100);
        cocaCola.setSodium(33);
        cocaCola.setCarbohydrate(27);

    }
}