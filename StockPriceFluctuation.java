/*
You are given a stream of records about a particular stock. Each record contains a timestamp and the corresponding price of the stock at that timestamp.

Unfortunately due to the volatile nature of the stock market, the records do not come in order. Even worse, some records may be incorrect. Another record with the same timestamp may appear later in the stream correcting the price of the previous wrong record.

Design an algorithm that:

Updates the price of the stock at a particular timestamp, correcting the price from any previous records at the timestamp.
Finds the latest price of the stock based on the current records. The latest price is the price at the latest timestamp recorded.
Finds the maximum price the stock has been based on the current records.
Finds the minimum price the stock has been based on the current records.
Implement the StockPrice class:

StockPrice() Initializes the object with no price records.
void update(int timestamp, int price) Updates the price of the stock at the given timestamp.
int current() Returns the latest price of the stock.
int maximum() Returns the maximum price of the stock.
int minimum() Returns the minimum price of the stock.
*/
class StockPrice {

    private HashMap<Integer, Integer> map;
    private TreeMap<Integer, Integer> priceFreq;
    private int latest = Integer.MIN_VALUE;

    public StockPrice() {
        map = new HashMap<>();
        priceFreq = new TreeMap<>();
    }

    public void update(int timestamp, int price) {

        if (map.containsKey(timestamp)) {

            Integer old = map.get(timestamp);
            priceFreq.put(old, priceFreq.get(old) - 1);
            if (priceFreq.get(old) == 0) 
                priceFreq.remove(old);
        }

        map.put(timestamp, price);
        priceFreq.put(price, priceFreq.getOrDefault(price, 0) + 1);
        latest = Math.max(latest, timestamp);
    }

    public int current() {
        return map.get(latest);
    }

    public int maximum() {
        return priceFreq.lastKey();
    }

    public int minimum() {
        return priceFreq.firstKey();
    }
}
