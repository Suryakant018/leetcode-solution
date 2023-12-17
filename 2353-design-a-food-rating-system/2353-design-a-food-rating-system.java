
class Food{
    String food;
    String cuisine;
    int rating;
    Food(String cuisine,String food,int rating){
        this.rating=rating;
        this.food=food;
        this.cuisine=cuisine;
    }
}


class FoodRatings {
    String food[];
    String cuisine[];
    int rating[];
    HashMap<String,PriorityQueue<Food>> ob=new HashMap<>();
    HashMap<String,Food> map=new HashMap<>();
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        rating=ratings;
        for(int i=0;i<foods.length;i++){
            Food food=new Food(cuisines[i],foods[i],ratings[i]);
            map.put(foods[i],food);
            if(!ob.containsKey(cuisines[i]))
            ob.put(cuisines[i],new PriorityQueue<Food>((a,b)->
            b.rating==a.rating ? a.food.compareTo(b.food) : b.rating-a.rating));
            ob.get(cuisines[i]).add(food);
        }
    }

    public void changeRating(String f, int n) {
        Food node=map.get(f);
        ob.get(node.cuisine).remove(node);
        node.rating=n;
        ob.get(node.cuisine).add(node);
    }

    public String highestRated(String cui) {
        int i = 0, max = -1;
        return ob.get(cui).peek().food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */