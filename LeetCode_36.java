public class LeetCode_36
{
    public boolean isValidSudoku(char[][] board)
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                char c=board[i][j];
                if(c>='0' && c<='9' && !isvalid(board,i,j))
                return false;
            }
        }
    return true;
    }
    public static boolean isvalid(char board[][],int row,int col)
    {
        for(int i=0;i<9;i++)//check repeated value in respective row and column
        {
            if(row!=i && board[i][col]==board[row][col])//check row wise
                return false;
            if(col!=i && board[row][i]==board[row][col])//check col wise
                return false;
        }
        int r=3*(row/3);
        int c=3*(col/3);
        for(int i=r;i<r+3;i++)//checking repeated values in a box of 3X3
        {
            for(int j=c;j<c+3;j++)
            {
                if(i!=row && j!=col && board[i][j]==board[row][col])
                    return false;
            }
        }
    return true;
    }
    public static void main(String[] args) {
        // Example usage:
        char[][] sudokuBoard = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        LeetCode_36 sudokuSolver = new LeetCode_36();
        boolean isValid = sudokuSolver.isValidSudoku(sudokuBoard);

        if (isValid) {
            System.out.println("The Sudoku board is valid.");
        } else {
            System.out.println("The Sudoku board is not valid.");
        }
    }
}
