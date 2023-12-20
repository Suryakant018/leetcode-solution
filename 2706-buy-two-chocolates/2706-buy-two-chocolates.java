class Solution {
  public int buyChoco(int[] prices, int money) {
    var min1 = 101;
    var min2 = 101;

    for (var price : prices) {
      if (price < min1) {
        min2 = min1;
        min1 = price;
      } else if (price < min2) {
        min2 = price;
      }
    }
    var diff = money - min1 - min2;
    return diff >= 0 ? diff : money;
  }
}
