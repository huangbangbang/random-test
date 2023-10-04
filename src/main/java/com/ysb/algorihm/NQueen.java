package com.ysb.algorihm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueen {
    public static void main(String[] args) {
        NQueen aa = new NQueen();
        System.out.println(aa.totalNQueens(4));


        backtrace(3,0,0,new StringBuffer(),new ArrayList<>());

    }

    private static void backtrace(int n, int left, int right, StringBuffer stringBuffer, List<String> res) {
        String s = stringBuffer.toString();
        int length = s.length();
        if (s.length() == 2 * n) {
            res.add(s);
            return;
        }

        if (left < n) {
            stringBuffer.append("(");
            left++;
            backtrace(n, left, right, stringBuffer, res);
            stringBuffer.deleteCharAt(length);
        }

        if (left < n) {
            stringBuffer.append("(");
            left++;
            backtrace(n, left, right, stringBuffer, res);
            stringBuffer.deleteCharAt(length);
        }


    }
    public int totalNQueens(int n) {

        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();

        return backtrace(n,0,columns,diagonals1,diagonals2);

    }

    private int backtrace(int n, int row , Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row==n){
            return 1;
        }else {
            int count = 0;
            for (int i = 0; i < n; i++) {

                if (columns.contains(i)){
                    continue;
                }
                int diagonal1 = row -1 ;
                if (diagonals1.contains(diagonal1)){
                    continue;
                }
                int diagonal2 = row +1 ;
                if (diagonals2.contains(diagonal2)){
                    continue;
                }

                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                count += backtrace(n,row+1,columns,diagonals1,diagonals2);
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);

            }
            return count;
        }
    }

//    private void backtrace(List<List<int[]>> res, int n, List<int[]> intList, int index,int nqueen){
//        boolean nQueen = isNQueen(intList);
//        if(nQueen&&nqueen==0){
//            res.add(new ArrayList<>(intList));
//            return ;
//        }else if(!nQueen){
//            return;
//        }else{
//            for(int i=index;i<n*n;i++){
//                intList.add(new int[]{i/n,i%n});
//                backtrace(res,n,intList,i+1,nqueen-1);
//                intList.remove(intList.size()-1);
//            }
//        }
//    }
//    private boolean isNQueen(List<int[]> intList){
//        for(int i=0;i<intList.size();i++){
//            for(int j=i+1;j<intList.size();j++){
//                int[] first = intList.get(i);
//                int[] second = intList.get(j);
//                if(first[0]-second[0]==0 || first[1]-second[1]==0 ||(Math.abs(first[0]-second[0])==Math.abs(first[1]-second[1]))){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
}
