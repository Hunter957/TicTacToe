package com.hunter;

public class View {

    public View(){
        System.out.println("欢迎游玩井字棋游戏");
        System.out.println("您的棋子符号为“X”，电脑棋子符号为“O”");
    }

    //显示棋盘信息，玩家棋子为‘X’，电脑棋子为‘O’
    public void showChessBoard(int[] chessBoard){
        char[] chess=new char[9];
        for (int i=0;i<9;i++){
            if (chessBoard[i]==-1){
                chess[i]='X';
            }else if (chessBoard[i]==0){
                chess[i]='-';
            }else {
                chess[i]='O';
            }
        }
        System.out.println("----------------------------");
        System.out.println("|"+chess[0]+"|"+chess[1]+"|"+chess[2]+"|");
        System.out.println("|"+chess[3]+"|"+chess[4]+"|"+chess[5]+"|");
        System.out.println("|"+chess[6]+"|"+chess[7]+"|"+chess[8]+"|");
        System.out.println("----------------------------");
    }

    //显示用户输入提示信息
    public void showUserToolTips(){
        System.out.println("----------------------------");
        System.out.println("1 2 3");
        System.out.println("4 5 6");
        System.out.println("7 8 9");
        System.out.print("到您的回合了，请输入棋子位置:");
    }

    //显示是否先手提示信息
    public void showFirstToolTips(){
        System.out.println("是否先手? 先手请输入数字1，否则请输入数字2!");
    }
}
