import java.util.HashMap;
import java.util.Map;

public class CardDeckCalculator {
    
    public static int calculateMaxDecks(Map<Character, int[]> cardCounts) {
        // Calculate how many full sets can be made for each type
        int maxDecksK = getFullSets(cardCounts.get('K'));
        int maxDecksH = getFullSets(cardCounts.get('H'));
        int maxDecksD = getFullSets(cardCounts.get('D'));
        int maxDecksS = getFullSets(cardCounts.get('S'));
        
        // The maximum number of decks is determined by the smallest of these values
        return Math.min(Math.min(maxDecksK, maxDecksH), Math.min(maxDecksD, maxDecksS));
    }
    
    private static int getFullSets(int[] cardArray) {
        // A full set requires exactly one card for each number 0-12
        int minFullSets = Integer.MAX_VALUE;
        for (int count : cardArray) {
            minFullSets = Math.min(minFullSets, count);
        }
        return minFullSets;
    }

    public static void main(String[] args) {
        // Example input: card counts for each number (0-12) for each type
        Map<Character, int[]> cardCounts = new HashMap<>();
        
        // Example with K having cards 0-12, some duplicates (like 3 of card 0)
        cardCounts.put('K', new int[]{13, 14, 81, 31, 12, 33, 53, 15, 34, 27, 94, 22, 12}); // 13 cards with number 0
        cardCounts.put('H', new int[]{41, 83, 21, 31, 27, 10, 15, 19, 10, 52, 25,47, 17}); // 27 cards with number 5
        cardCounts.put('D', new int[]{5, 24, 45, 14, 12, 81, 11, 41, 21, 34, 26, 28, 9}); //26 cards with number 10
        cardCounts.put('S', new int[]{6, 14, 5, 11, 23, 24, 54, 71, 16, 18, 10, 21, 17}); // 14 cards with number 1
        
        int maxDecks = calculateMaxDecks(cardCounts);
        System.out.println("Maximum card deck = " + maxDecks);
    }
}
