package com.hunter;

public class ChessBoard {
    //默认值为0，玩家棋子为-1，电脑棋子为1
    public int[] chess;

    public ChessBoard(){
        clearChessBoard();
    }

    //重置棋盘
    public void clearChessBoard(){
        chess=new int[9];
    }
}
