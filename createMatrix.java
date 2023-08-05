import java.util.Random;

 class createMatrix {


     protected  int[][] keypad(int rows, int cols) {
        int[][] keypad = new int[rows][cols];
        int[] numbers = new int[rows * cols];

        // Initialize an array containing numbers from 1 to rows*cols
        for (int i = 0; i < rows * cols; i++) {
            numbers[i] = i + 1;
        }

    
        Random random = new Random();
        for (int i = numbers.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = numbers[index];
            numbers[index] = numbers[i];
            numbers[i] = temp;
        }

    
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                keypad[i][j] = numbers[k];
                k++;
            }
        }

        return keypad;
    }

    protected  void displayKeypad(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }




    protected int returnTheValue(int[][] matrix , int row , int col ){
            return matrix[row][col];
    }

}
