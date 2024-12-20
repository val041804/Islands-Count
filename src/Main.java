public class Main {
    static void print_2d_array(int[][] a){
        for (int[] ints : a) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(ints[j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void dfs(int[][] a, int i, int j){
        if(i < 0 || i >= a.length || j < 0 || j >= a[0].length || a[i][j] != 1){
            return;
        }
        a[i][j] = 0;
        dfs(a, i + 1, j);
        dfs(a, i - 1, j);
        dfs(a, i, j + 1);
        dfs(a, i, j - 1);
    }

    static int count_islands(int[][] a){
        int count = 0;

        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[0].length; j++){
                if(a[i][j] == 1) {
                    dfs(a, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        final int[][] abc = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0}
        };
        System.out.println(count_islands(abc)); // output: 3
    }
}