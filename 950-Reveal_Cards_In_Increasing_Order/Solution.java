import java.util.Deque;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Queue;

public class Solution {
    public static int[] deckRevealedIncreasing(int[] deck) {
        Deque<Integer> queue = new LinkedList<>();
        Arrays.sort(deck);
        
        for (int i = deck.length - 1; i >= 0; i--) {
            if (queue.isEmpty()) {
                queue.add(deck[i]);
            } else {
                queue.addFirst(queue.pollLast());
                queue.addFirst(deck[i]);
            }
        }
        
        int[] result = new int[deck.length];
        for (int i = 0; i < deck.length; i++) {
            result[i] = queue.pollFirst();
        }
        
        return result;
    }
    
    static void simulate(int[] deck) {
        Queue<Integer> queue = new LinkedList<>();
        for (int x: deck) queue.add(x);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
            if (!queue.isEmpty()) queue.add(queue.poll());
        }
    }
    public static void main(String[] args) {
        int[] deck = deckRevealedIncreasing(new int[] {17,13,11,2,3,5,7});
        simulate(deck);
    }
}