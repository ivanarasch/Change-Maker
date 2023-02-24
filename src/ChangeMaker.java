import java.util.Arrays;

public class ChangeMaker {
    static int count;
    public static void main(String[] args) {
        count = 0;
        int[] coins = {10, 5, 50};
        int amount = 80;
        int[][] memo = new int[amount + 1][];

        int[] solution = new int[coins.length];

        /**
         * Here are four different solutions to the coin change problem.
         * Each is configured to determine a solution (or all of them) and count
         * the number of times the method was called during recursion. Feel
         * free to uncomment any one of them to observe the difference. Use different
         * coins denominations and amounts if you like. See if you can figure out how they
         * are different and why one of them vastly outperforms the other three. In some,
         * solutions are built from the top down. In others, solutions are built from the bottom up.
         * Note that for many of them, setting the amount higher than 100 will start to deliver some
         * very slow runtimes.
         */
        //allSolutions(solution, amount, coins);
//        solution = backtrack(solution, amount, coins);
        solution = subproblem(amount, coins);
       // solution = subproblem_memo(memo, amount, coins);

        for (int i : solution) {
            System.out.print(" " + i);
        }
        System.out.println(" | total coins: " + countCoins(solution) + " | method calls: " + count);
    }

    public static void allSolutions(int[] solution, int amount, int[] coins) {
        count++;
        if (amount == 0) {
            for (int j : solution)
                System.out.print(" " + j);
            System.out.println();
        } else if (amount > 0) {
            for (int i = 0; i < coins.length; i++) {
                solution[i]++;
                allSolutions(solution, amount - coins[i], coins);
                solution[i]--;
            }
        }
    }

    public static int[] backtrack(int[] solution, int amount, int[] coins) {
        count++;
        if (amount == 0)
        {
            return Arrays.copyOf(solution, solution.length);
        }
        else if (amount > 0)
        {
            int[][] temp = new int[coins.length][];
            int[] best = {-1};
            int bestCount = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++)
            {
                solution[i]++;

                temp[i] = backtrack(solution, amount - coins[i], coins);
                int tempCount = countCoins(temp[i]);
                if (tempCount > 0 && tempCount < bestCount) {
                    best = temp[i];
                    bestCount = tempCount;
                }

                solution[i]--;
            }
            return best;
        }

        return new int[]{-1};
    }

    public static int[] subproblem_memo(int[][] memo, int amount, int[] coins) {
        count++;

        if (amount < 0)
            return new int[]{-1};

        if (memo[amount] != null)
            return memo[amount];

        int[] solution = {-1};

        for (int i = 0; i < coins.length; i++)
        {

            if (amount - coins[i] == 0)
            {
                solution = new int[coins.length];
                solution[i] = 1;
                return solution;
            }
            else if (amount - coins[i] > 0)
            {

                int[] temp = subproblem_memo(memo, amount - coins[i], coins);
                if (countCoins(temp) > 0) {
                    if (countCoins(solution) < 0 || countCoins(solution) > countCoins(temp) + 1) {
                        solution = new int[coins.length];
                        solution[i] = 1;

                        for (int j = 0; j < temp.length; j++)
                            solution[j] += temp[j];
                    }
                }
            }
        }
        memo[amount] = solution;
        return solution;
    }

    public static int[] subproblem(int amount, int[] coins) {
        count++;

        if (amount < 0)
            return new int[]{-1};

        int[] solution = {-1};

        for (int i = 0; i < coins.length; i++) {

            if (amount - coins[i] == 0) {
                solution = new int[coins.length];
                solution[i] = 1;
                return solution;
            } else if (amount - coins[i] > 0) {

                int[] temp = subproblem(amount - coins[i], coins);
                if (countCoins(temp) > 0) {
                    if (countCoins(solution) < 0 || countCoins(solution) > countCoins(temp) + 1) {
                        solution = new int[coins.length];
                        solution[i] = 1;

                        for (int j = 0; j < temp.length; j++)
                            solution[j] += temp[j];
                    }
                }

            }

        }
        return solution;
    }

    public static int countCoins(int[] solution) {
        int total = 0;
        for (int j : solution) {
            total += j;
        }
        return total;
    }
}
