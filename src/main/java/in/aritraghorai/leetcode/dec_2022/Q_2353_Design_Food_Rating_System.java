package in.aritraghorai.leetcode.dec_2022;

import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * !Name: Aritra Ghorai
 * !Date:17/12/2023
 * ?Program Details:2353. Design a Food Rating System
 *
 */

public class Q_2353_Design_Food_Rating_System {
  static class FoodRatings {

    private HashMap<String, PriorityQueue<FoodItem>> cousine = new HashMap<>();

    private HashMap<String, FoodItem> foods = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
      for (int i = 0; i < foods.length; i++) {
        FoodItem foodItem = new FoodItem(foods[i], cuisines[i], ratings[i]);
        this.foods.put(foods[i], foodItem);
        cousine.putIfAbsent(
            cuisines[i],
            new PriorityQueue<>((a, b) -> b.rating == a.rating
                ? a.food.compareTo(b.food)
                : b.rating - a.rating));
        cousine.get(cuisines[i]).add(foodItem);
      }
    }

    public void changeRating(String food, int newRating) {
      FoodItem foodItem = foods.get(food);
      cousine.get(foodItem.cuisine).remove(foodItem);
      foodItem.rating = newRating;
      cousine.get(foodItem.cuisine).add(foodItem);
    }

    public String highestRated(String cuisine) {
      return cousine.get(cuisine).peek().food;
    }
  }

  static class FoodItem {
    String food;
    String cuisine;
    int rating;

    public FoodItem(String food, String cuisine, int rating) {
      this.food = food;
      this.cuisine = cuisine;
      this.rating = rating;
    }
  }
}
