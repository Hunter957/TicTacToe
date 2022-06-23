package com.hunter;

import java.util.ArrayList;

public class Algorithm {

    //α-β剪枝算法节点，返回的数组包含值与位置信息
    public static int[] abPruneNode(int[] chess,int a,int b,boolean isMAX){
        //统计空余的棋盘位置
        ArrayList<Integer> pos=new ArrayList<>();
        for (int i=0;i< chess.length;i++){
            if (chess[i]==0){
                pos.add(i);
            }
        }
        //遍历每个空位的情况，当b<=a时，结束尝试
        int[] result=new int[2];
        for (Integer po : pos) {
            //尝试下一步棋
            if (isMAX) {
                chess[po] = 1;
            } else {
                chess[po] = -1;
            }
            //获取尝试下一步棋之后的结果
            int value = result(chess);
            //对局未结束，递归遍历博弈树
            if (value == 2) {
                value = abPruneNode(chess, a, b, !isMAX)[1];
            }
            //根据获取的返回值修改a或b的值
            if (isMAX) {
                if (a < value) {
                    a = value;
                    result[0] = po;
                }
            } else {
                if (b > value) {
                    b = value;
                    result[0] = po;
                }
            }
            //回退一步尝试的下一步棋
            chess[po] = 0;
            //Beta<=Alpha，结束剩余博弈树的遍历(剪枝)
            if (b <= a) {
                break;
            }
        }
        //设置当前节点的返回值
        if (isMAX){
            result[1]=a;
        }else {
            result[1]=b;
        }
        return result;
    }

    //判断是否分出胜负
    //玩家胜出返回-1，平局返回0，电脑胜出返回1，游戏还未结束返回2
    public static int result(int[] chess){
        //玩家或者电脑胜出
        if (chess[0]==chess[1] && chess[1]==chess[2] && chess[0]!=0){
            return chess[0];
        }else if (chess[3]==chess[4] && chess[4]==chess[5] && chess[3]!=0){
            return chess[3];
        }else if (chess[6]==chess[7] && chess[7]==chess[8] && chess[6]!=0){
            return chess[6];
        }else if (chess[0]==chess[3] && chess[3]==chess[6] && chess[0]!=0){
            return chess[0];
        }else if (chess[1]==chess[4] && chess[4]==chess[7] && chess[1]!=0){
            return chess[1];
        }else if (chess[2]==chess[5] && chess[5]==chess[8] && chess[2]!=0){
            return chess[2];
        }else if (chess[0]==chess[4] && chess[4]==chess[8] && chess[0]!=0){
            return chess[0];
        }else if (chess[2]==chess[4] && chess[4]==chess[6] && chess[2]!=0){
            return chess[2];
        }
        //对局没有结束
        for(int i:chess){
            if (i==0){
                return 2;
            }
        }
        //游戏平局
        return 0;
    }
}
