package com.hunter;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private View view;
    private ChessBoard chessBoard;
    private Scanner scanner;

    public Game(){
        this.view=new View();
        this.chessBoard=new ChessBoard();
        this.scanner=new Scanner(System.in);
    }

    //开始游戏
    public void start(){
        boolean gameContinue=true;
        while (gameContinue){
            view.showFirstToolTips();
            int whoFirst=scanner.nextInt();
            if (whoFirst==1||whoFirst==2){
                startGame(whoFirst);
            }else {
                System.out.println("输入数据错误，请重新输入！");
                continue;
            }
            System.out.println("是否继续游戏? 继续请输入1，退出游戏请输入2！");
            int next=scanner.nextInt();
            while (!(next==1 || next==2)){
                System.out.println("输入数据错误，请重新输入！");
                next=scanner.nextInt();
            }
            if (next==1){
                chessBoard.clearChessBoard();
            }else{
                gameContinue=false;
                System.out.println("感谢您的游玩，再见！");
            }
        }
    }

    //开始一局游戏
    public void startGame(int first){
        if (first==2){
            int[] pos={0,2,6,8};
            Random random=new Random();
            chessBoard.chess[pos[random.nextInt(3)+1]]=1;
            System.out.println("电脑回合:");
            view.showChessBoard(chessBoard.chess);
        }
        boolean over=false;
        while (!over){
            if (userRound()){
                break;
            }
            over=robotRound();
        }
    }

    //玩家回合
    public boolean userRound(){
        view.showUserToolTips();
        int pos=scanner.nextInt();
        //判断玩家输入是否合法
        while (chessBoard.chess[pos-1]!=0){
            System.out.println("此位置已有棋子，请重新选择！");
            pos=scanner.nextInt();
        }
        chessBoard.chess[pos-1]=-1;
        view.showChessBoard(chessBoard.chess);
        return result();
    }

    //电脑回合
    public boolean robotRound(){
        chessBoard.chess[Algorithm.abPruneNode(chessBoard.chess,-1000,1000,true)[0]]=1;
        System.out.println("电脑回合:");
        view.showChessBoard(chessBoard.chess);
        return result();
    }

    //判断是否结束
    public boolean result(){
        int result=Algorithm.result(chessBoard.chess);
        switch (result){
            case 1:
                System.out.println("电脑赢得了本次对局");
                break;
            case 0:
                System.out.println("平局，再来一局吧");
                break;
            case -1:
                System.out.println("恭喜您赢得了本次对局");
                break;
        }
        return result != 2;
    }
}
