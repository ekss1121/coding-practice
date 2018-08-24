public class Maze{
    public static String solution(char[][] maze){
        if(maze == null || maze.length == 0) return "";
        if(maze[0] == null || maze[0].length == 0) return "";

        int i = 0;
        int j = 0;
        for(i=0; i<maze.length; i++){
            for(j=0; j<maze[0].length; j++){
                if(maze[i][j] == 's') break;
            }
        }

        StringBuilder sb = new StringBuilder();
        dfs(maze, i,j, sb);

        return sb.toString();
    }

    private static void dfs(char[][] maze, int i, int j, StringBuilder sb){
        StringBuilder tmp = new StringBuilder();
        if(sb.size() > 0) return;

        if(i == maze.length || i < 0 || j == maze[0].length || j < 0
            || maze[i][j] == 'x'){
            return;
        }
        if(maze[i][j] == 'e'){
            sb.append(tmp.toString());
            return;
        }

        // going down
        tmp.append('d');
        dfs(maze, i+1, j, sb);
        tmp.remove(tmp.size()-1);
        // going up
        tmp.append('u');
        dfs(maze, i-1, j, sb);
        tmp.remove(tmp.size()-1);
        // going left
        tmp.append('l');
        dfs(maze, i, j-1, sb);
        tmp.remove(tmp.size()-1);
        // going right
        tmp.append('r');
        dfs(maze, i, j+1, sb);
        tmp.remove(tmp.size()-1);


    }

    public static void main(String[] args){
        /*
        [s,o,o,o,o
         o,x,o,x,o
         x,o,o,o,o
         o,x,o,x,e]


        */
    }
}
