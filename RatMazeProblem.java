public class RatMazeProblem   
{  
    // Size of the maze  
    static int R;  
    static int C;  
    // A utility method to display  
    // the outcome matrix result[R][C]   
    void displaySolution(int result[][])  
    {  
        System.out.println("The resultant matrix is: ");  
        for (int r = 0; r < R; r++)   
        {  
            for (int c = 0; c < C; c++)  
            {  
                System.out.print(" " + result[r][c] + " ");  
            }  
            System.out.println();  
        }  
    }  
    // A  method to validate whether r, c is the valid index for the R * C maze   
    boolean isValid(int maze[][], int r, int c)  
    {  
        // if (r, c is outside the maze, then return false  
        return (r >= 0 && r < R && c >= 0 && c < C && maze[r][c] == 0);  
    }    
    boolean findPathMaze(int maze[][])  
    {  
        int maz[][] = new int[R][C];  
        for(int r = 0; r < R; r++)  
        {  
            for(int c = 0; c < C; c++)  
            {  
                maz[r][c] = 1;  
            }  
        }  
        if (solveMazeUtility(maze, 0, 0, maz) == false)   
        {  
            System.out.print("Path from source to destination doesn't exist");  
            return false;  
        }  
        displaySolution(maz);  
        return true;  
    }  
    // A recursive utility method to find the solution of the Maze problem   
    boolean solveMazeUtility(int maze[][], int r, int c, int res[][])  
    {  
        // if r, c is the destination, then return true  
        if (r == R - 1 && c == C - 1 && maze[r][c] == 0)   
        {  
            res[r][c] = 0;  
            return true;  
        }  
        // Check if the maze[r][c] is valid  
        if (isValid(maze, r, c) == true)   
        {  
            // checking whether the current cell has been the part of the solution path or not  
            if (res[r][c] == 0)  
            {  
                return false;  
            }  
            // marking res(r, c) as the part of the solution path  
            res[r][c] = 0;  
            // Moving forward in the downward direction   
            if (solveMazeUtility(maze, r + 1, c, res))  
            {  
                return true;  
            }  
            // If moving in downward direction does not provide  
            // the soluTion then we move in the rightward direction  
            if (solveMazeUtility(maze, r, c + 1, res))  
            {  
                return true;  
            }  
            if (solveMazeUtility(maze, r - 1, c, res))  
            {  
                return true;  
            }  
            if (solveMazeUtility(maze, r, c - 1, res))  
            {  
                return true;  
            }  
            res[r][c] = 1;  
            return false;  
        }  
        return false;  
    }  
    public static void main(String argvs[])  
    {
        RatMazeProblem r = new RatMazeProblem();  
        int maze[][] = { { 0, 1, 1, 1 },  
                       { 0, 0, 0, 1 },  
                       { 0, 0, 0, 1 },  
                       { 1, 1, 0, 0 } };  
        R = maze.length;  
        C = maze[0].length;  
        r.findPathMaze(maze);  
    }  
}  