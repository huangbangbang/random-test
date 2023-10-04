package com.ysb.algorihm;

public class Test5 {
    public static void main(String[] args) {
        Test5 aa = new Test5();
        aa.solve(new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}});
        System.out.println("=======");
    }

    public void solve(char[][] board) {
        for(int x=0;x<board.length;x++){
            for(int y=0;y<board[0].length;y++){
                if(board[x][y]=='O'){
                    int num = isNearBoundary(board,x,y);
                    if(num<=0){
                        dfs(board,x,y);
                    }
                }
            }
        }

        for(int x=0;x<board.length;x++){
            for(int y=0;y<board[0].length;y++){
                if(board[x][y]=='1'){
                    board[x][y]='O';
                }
            }
        }

        System.out.println("================");
    }

    private int isNearBoundary(char[][] board, int x, int y){

        if(!inArea(board,x,y)){
            return 1;
        }
        if(board[x][y]!='O'){
            return 0;
        }

        if(board[x][y]=='O'){
            board[x][y]='1';
        }
        return isNearBoundary(board,x-1,y)
                +isNearBoundary(board,x+1,y)
                +isNearBoundary(board,x,y-1)
                +isNearBoundary(board,x,y+1);

    }

    private int dfs(char[][] board, int x, int y){

        if(!inArea(board,x,y)){
            return 0;
        }

        if(board[x][y]!='1'){
            return 0;
        }

        if(board[x][y]=='1'){
            board[x][y]='X';
        }
        return
                1+dfs(board,x-1,y)
                        +dfs(board,x+1,y)
                        +dfs(board,x,y-1)
                        +dfs(board,x,y+1);

    }

    private boolean inArea(char[][] board,int x,int y){
        return   0<=x && x<board.length
                && 0<=y && y<board[0].length;
    }
}
