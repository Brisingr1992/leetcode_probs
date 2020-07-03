import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Solution {
    public static int[] prisonCellsAfterNDaysBF(int[] cells, int N) {
        while (N-- > 0) {
            cells = nextDay(cells);
        }

        return cells;
    }

    public static int[] prisonCellsAfterNDays(int[] cells, int N) {
        Set<String> set = new HashSet<>();
        
        boolean hasCycle = false;
        int days = 0;
        
        for (int i = 0; i < N; i++) {
            int[] next = nextDay(cells);
            
            String key = Arrays.toString(next); // Or can use a bitmask based key
            if (set.contains(key)) {
                hasCycle = true;
                break;
            } else {
                set.add(key);
                days++;
            }
            
            cells = next;    
        }
        
        if (hasCycle) {
            N = N % days;
            for (int i = 0; i < N; i++) {
                cells = nextDay(cells);
            }
        }
        return cells;
    }

    private static int[] nextDay(int[] cells) {
        int[] nextCells = new int[cells.length];
        nextCells[0] = 0;
        for (int i = 1; i < cells.length - 1; i++) {
            nextCells[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        }
        nextCells[cells.length - 1] = 0;
        return nextCells;
    }

    public static void main(String[] args) {
        int[] cells1 = new int[] {0,1,0,1,1,0,0,1};
        int[] cells2 = new int[] {1,0,0,1,0,0,1,0};

        System.out.println(Arrays.toString(prisonCellsAfterNDaysBF(cells1, 7)));
        System.out.println(Arrays.toString(prisonCellsAfterNDaysBF(cells2, 1000000000)));

        System.out.println(Arrays.toString(prisonCellsAfterNDays(cells1, 7)));
        System.out.println(Arrays.toString(prisonCellsAfterNDays(cells2, 1000000000)));
    }
}