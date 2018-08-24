import java.io.*;
import java.util.*;

public class SudokuSolver{
    int[][] prob;
    int[][] sol;
    boolean foundSol;

    SudokuSolver(String filePath){
        this.prob = new int[9][9];
        this.sol = new int[9][9];
        this.foundSol = false;
        try{
            BufferedReader in  = new BufferedReader(new FileReader(filePath));
            for(int i=0; i<9 ;i++){
                String line = in.readLine();
                String[] row = line.split(",");
                for(int j=0; j<9; j++){
                    prob[i][j] = Integer.parseInt(row[j]);
                    sol[i][j] = Integer.parseInt(row[j]);
                    
                }
            }
            in.close();
        } catch(IOException e){
            System.out.println(e);
        }

        solver();
    }

    private void solver(){
        // fill the position start at (i,j)
        dfs(0,0);
    }

    private void dfs(int i, int j){
        if(i == 9 || foundSol){
            foundSol = true;
            return;
        }
        if(prob[i][j] > 0){
            if(j < 8){
                dfs(i,j+1);
            }else{
                dfs(i+1, 0);
            }
        }else{
            for(int k=1; k<=9; k++){
                if(rowValid(i,k) && colValid(j,k) && nearValid(i,j,k)){
                    sol[i][j] = k;
                    if(j < 8){
                        dfs(i,j+1);
                    }else{
                        dfs(i+1, 0);
                    }
                }
    
            }

        }
    }

    private boolean rowValid(int i, int k){
        for(int col =0; col<9; col++){
            if(sol[i][col] == k) return false;
        }

        return true;
    }

    private boolean colValid(int j, int k){
        for(int row=0; row<9; row++){
            if(sol[row][j] == k) return false;
        }

        return true;
    }

    private boolean nearValid(int i, int j, int k){
        int r = (i / 3) * 3;
        int c = (j / 3) * 3;
        for(int row = r; row<3; row++){
            for(int col = c; col<3; col++){
                if(sol[row][col] == k) return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        SudokuSolver ss = new SudokuSolver("./problem.in");
        for(int i=0; i< 9; i++){
            for(int j=0; j<9; j++){
                System.out.print(ss.sol[i][j] + (j==8 ? "" : ","));
            }
            System.out.println("");
        }
    }
}
