package Day28;
public class OnlineStockSpan{
    class Pair {
        int price;
        int span;

        Pair(int price, int span) {
            this.price = price;
            this.span = span;
        }
    }

    Stack<Pair> stack;

    public void StockSpanner() {

        stack = new Stack<>();
    }

    public int next(int price) {

        int span = 1;

        // Merge previous smaller/equal prices
        while (!stack.isEmpty() &&
               stack.peek().price <= price) {

            span += stack.pop().span;
        }

        stack.push(new Pair(price, span));

        return span;
    }
}