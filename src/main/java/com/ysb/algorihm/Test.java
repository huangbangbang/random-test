package com.ysb.algorihm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Test {
    public static void main(String[] args) {

        String paypalishiring = convert("ABC", 3);
        fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20);

        isPalindrome("0P");


//        List<Integer> list = new ArrayList<>();
//
//        threeSum(new int[]{0,0,0,0});
//
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        List<Integer> res = findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"});
        System.out.println(res.toArray().toString());

        //System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        HashMap<Object, Object> map = new HashMap<>();
        System.out.println(isValidSudoku(new char[][]{
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}}
        ));

        spiralOrder(new int[][]{{1,2},{3,4}}
        );

        int[][] board = {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,1,1,1,0},{0,1,1,1,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}};

        int[][] rightBoard = {{0,0,0,0,0,0},{0,0,0,1,0,0},{0,1,0,0,1,0},{0,1,0,0,1,0},{0,0,1,0,0,0},{0,0,0,0,0,0}};
        printArray(board);
        gameOfLife(board);
        System.out.println("=====================");
        printArray(board);
        System.out.println("==========================");
        printArray(rightBoard);

    }

    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] backup = new int[m][n];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int current = board[i][j];
                if (current==1){
                    int aroundLive = getAroundLive(i, j, board);
                    if (aroundLive<2){
                        backup[i][j] = 1;
                    }else if(2<=aroundLive&&aroundLive<=3){

                    }else if (aroundLive>3){
                        backup[i][j] = 1;
                    }
                }else {
                    int aroundDead = getAroundLive(i, j, board);
                    if (aroundDead==3){
                        backup[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int change = backup[i][j];
                if (change==1){
                    if (board[i][j]==0){
                        board[i][j]=1;
                    }else {
                        board[i][j]=0;
                    }
            }
        }
    }
    }

    private static int getAroundLive(int i, int j, int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        if (isExsit(i-1,j,m,n)) count+=board[i-1][j];
        if (isExsit(i,j-1,m,n)) count+=board[i][j-1];
        if (isExsit(i+1,j,m,n)) count+=board[i+1][j];
        if (isExsit(i,j+1,m,n)) count+=board[i][j+1];

        if (isExsit(i-1,j,m,n)&&isExsit(i,j-1,m,n))count+=board[i-1][j-1];
        if (isExsit(i+1,j,m,n)&&isExsit(i,j+1,m,n))count+=board[i+1][j+1];
        if (isExsit(i-1,j,m,n)&&isExsit(i,j+1,m,n))count+=board[i-1][j+1];
        if (isExsit(i+1,j,m,n)&&isExsit(i,j-1,m,n))count+=board[i+1][j-1];
        return count;
    }

    private static int getAroundDead(int i, int j, int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        count+=isExsitDead(i-1,j,board);
        count+=isExsitDead(i,j-1,board);
        count+=isExsitDead(i+1,j,board);
        count+=isExsitDead(i,j+1,board);

        count+=isExsitDead(i-1,j-1,board);
        count+=isExsitDead(i+1,j+1,board);
        count+=isExsitDead(i-1,j+1,board);
        count+=isExsitDead(i+1,j-1,board);

        return count;
    }
    private static boolean isExsit(int i,int j,int m,int n){
        return (0<=i&&i<m) && (0<=j&&j<n);
    }

    private static int isExsitDead(int i,int j,int[][] board){
        if ((0<i&&i<board.length) && (0<j&&j<board[0].length)){
            if (board[i][j]==0){
                return 1;
            }
        }
        return 0;
    }



    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList();

        int row  = matrix.length;
        int column  = matrix[0].length;

        int left = 0;
        int right = column -1;
        int down = 0;
        int up = row -1;

        boolean toRitht = true;
        boolean toLeft = false;
        boolean toDown = false;
        boolean toUp = false;

        int i =0;
        int j =0;


        while(true){

            while(toRitht){

                res.add(matrix[i][j]);
                if(j<right){
                    j++;
                }else{
                    down++;
                    toRitht = false;
                    toUp = true;
                    if(down>up){
                        return res;
                    }
                    i++;
                }

            }

            while(toUp){

                res.add(matrix[i][j]);
                if(i<up){
                    i++;
                }else{
                    right--;
                    toUp = false;
                    toLeft = true;
                    if(right<left){
                        return res;
                    }
                    j--;
                }

            }

            while(toLeft){

                res.add(matrix[i][j]);
                if(j>left){
                    j--;
                }else{
                    up--;
                    toLeft = false;
                    toDown = true;
                    if(down>up){
                        return res;
                    }
                    i--;
                }

            }

            while(toDown){

                res.add(matrix[i][j]);
                if(i>down){
                    i--;
                }else{
                    left++;
                    toDown = false;
                    toRitht = true;
                    if(left>right){
                        return res;
                    }
                    j++;
                }

            }
        }

    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Map<Character,Integer> map = new HashMap<>();
            for (int j = 0; j < board.length; j++) {
                if (board[i][j]!='.'){
                    Integer integer = map.get(board[i][j]);
                    if (Objects.nonNull(integer)){
                        return false;
                    }else {
                        map.put(board[i][j],1);
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            Map<Character,Integer> map = new HashMap<>();
            for (int j = 0; j < board.length; j++) {
                char c = board[j][i];
                if (board[j][i]!=46){
                    Integer integer = map.get(board[j][i]);
                    if (Objects.nonNull(integer)){
                        return false;
                    }else {
                        map.put(board[j][i],1);
                    }
                }
            }
        }

        for (int n = 0;n<board.length;n=n+3){
        for (int i = 0; i < board.length; i=i+3) {
            Map<Character,Integer> map = new HashMap<>();
            for (int j= n ;j<n+3;j++){
                for (int k = i;k<i+3;k++){
                    if (board[j][k]!='.'){
                        Integer integer = map.get(board[j][k]);
                        if (Objects.nonNull(integer)){
                            return false;
                        }else {
                            map.put(board[j][k],1);
                        }
                    }
                }
            }
        }}
        return true;
    }


    public static String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        char[] target = t.toCharArray();
        char[] source = s.toCharArray();
        int sLength = source.length;
        int tLength = target.length;

        int left = 0;
        int right = 0;

        int minLength = Integer.MAX_VALUE;
        int index = -1;

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> record = new HashMap<>();
        for (char c : target) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            record.put(c, map.getOrDefault(c, 0) + 1);
        }

        while (true) {
            if (stillConsume(map)&&right<sLength) {

                char c = source[right];
                Integer integer = map.get(c);
                if (Objects.nonNull(integer)) {
                    map.put(c, map.get(c) - 1);
                }

                right++;


            } else if (!stillConsume(map)){
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    index = left;
                }
                char c = source[left];
                Integer integer = record.get(c);
                if (Objects.nonNull(integer)){
                    map.put(c, map.getOrDefault(c,0)+1);
                }
                left++;
                if (stillConsume(map)&&right==sLength-1){
                    break;
                }
            }else{
                break;
            }
        }
        if (index != -1) {
            return s.substring(index, index + minLength);
        } else {
            return "";
        }
    }




//    public static String minWindow(String s, String t) {
//
//        if (t.length() > s.length()) {
//            return "";
//        }
//
//        char[] target = t.toCharArray();
//        char[] source = s.toCharArray();
//        int sLength = source.length;
//        int tLength = target.length;
//
//        int left = 0;
//        int right = -1;
//
//        int minLength = Integer.MAX_VALUE;
//        int index = -1;
//
//        Map<Character, Integer> map = new HashMap<>();
//        Map<Character, Integer> record = new HashMap<>();
//        for (char c : target) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//            record.put(c, map.getOrDefault(c, 0) + 1);
//        }
//
//        while (true) {
//            if (stillConsume(map)&&right<sLength-1) {
//                right++;
//                char c = source[right];
//                Integer integer = map.get(c);
//                if (Objects.nonNull(integer)) {
//                    map.put(c, map.get(c) - 1);
//                }
//            }
//            if (!stillConsume(map)){
//                if (right - left + 1 < minLength) {
//                    minLength = right - left + 1;
//                    index = left;
//                }
//                char c = source[left];
//                Integer integer = record.get(c);
//                if (Objects.nonNull(integer)){
//                    map.put(c, map.getOrDefault(c,0)+1);
//                }
//                left++;
//                if (stillConsume(map)&&right==sLength-1){
//                    break;
//                }
//            }
//        }
//        if (index != -1) {
//            return s.substring(index, index + minLength);
//        } else {
//            return "";
//        }
//    }
    private static boolean stillConsume(Map<Character,Integer> map){
        for (Integer value : map.values()) {
            if (value>0){
                return true;
            }
        }
        return false;
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int wordLength = words[0].length();
        int wordNum = words.length;
        int totalLength = wordNum * wordLength;
        int sLength = s.length();
        if (totalLength > sLength) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < wordLength; i++) {
            if (i + totalLength > sLength) {
                return res;
            }
            for (int j = 0; j < wordNum; j++) {
                String word = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) - 1);
                if (map.get(word) == 0) {
                    map.remove(word);
                }
            }

            for (int start = i; start < sLength - totalLength + 1; start += wordLength) {
                if (start != i) {
                    String word = s.substring(start + totalLength - wordLength, start + totalLength);
                    map.put(word, map.getOrDefault(word, 0) + 1);
                    if (map.get(word) == 0) {
                        map.remove(word);
                    }

                    word = s.substring(start - wordLength, start);
                    map.put(word, map.getOrDefault(word, 0) - 1);
                    if (map.get(word) == 0) {
                        map.remove(word);
                    }
                }
                if (map.isEmpty()) {
                    res.add(start);
                }
            }
        }
        return res;
    }

    public static int lengthOfLongestSubstring(String s) {

        char[] charArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap();

        int left = 0;
        int rigth = 0;
        int count = 0;

        while (rigth < charArray.length) {
            if (map.get(charArray[rigth]) == null) {
                count = Math.max(count, rigth - left + 1);
                map.put(charArray[rigth], 1);
                rigth++;
            } else {
                map.remove(charArray[left]);
                left++;
            }

        }

        return count;
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> res = new ArrayList();
        if (nums.length < 3 || nums[0] > 0) {
            return res;
        }
        int left = 0;
        int right = length - 1;
        for (int i = 0; i < length - 2; i++) {
            if (i > 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            left = i + 1;
            right = length - 1;
            while (left < right) {
                int currentTotal = nums[i] + nums[left] + nums[right];
                if (currentTotal == 0) {
                    List<Integer> list = new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    do {
                        right--;
                    } while (right > 0 && nums[right] == nums[right + 1]);
                    do {
                        left++;
                    } while (left < length - 1 && nums[left] == nums[left - 1]);
                } else if (currentTotal > 0) {
                    do {
                        right--;
                    } while (right > 0 && nums[right] == nums[right + 1]);
                } else {
                    do {
                        left++;
                    } while (left < length - 1 && nums[left] == nums[left - 1]);
                }
            }
        }

        // for(int i = 0;i<length;i++){
        //     for(int j = i+1;j<length;j++){
        //         for(int k = j+1;k<length;k++){
        //             if(nums[i]+nums[j]+nums[k]==0){
        //                 List<Integer> list = new ArrayList();
        //                 List<Integer> temp = new ArrayList();

        //                 boolean flag = true;

        //              for(List<Integer> existList:res){
        //                 temp.add(nums[i]);
        //                 temp.add(nums[j]);
        //                 temp.add(nums[k]);
        //                  for(Integer integer:existList){
        //                      temp.remove((Integer)integer);
        //                  }
        //                    if(temp.size()==0){
        //                        flag = false;
        //                    }else{
        //                        temp.clear();
        //                    }
        //                }
        //                if(flag){
        //                 list.add(nums[i]);
        //                 list.add(nums[j]);
        //                 list.add(nums[k]);
        //                 res.add(list);
        //                }

        //             }
        // }
        // }
        // }
        return res;
    }

    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.replaceAll("\\s+", "");
        s = s.toLowerCase();
        boolean isPalindrome = true;
        if (s.length() <= 1) {
            return true;
        }
        for (int i = 0; i < (s.length() + 1) / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static String convert(String s, int numRows) {

        //经过分析：
        //第一行是 2*numRows-2 , 2*numRows-2的字符所在位置
        //第二行是 2*numRows-1 , 2*numRows+1的字符所在位置
        //第一行是 2*numRows   , 2*numRows  的字符所在位置
        //第一行是 2*numRows+1 , 2*numRows-1 的字符所在位置


        if (numRows < 2) {
            return s;
        }
        int length = s.length();
        char[] charArray = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < numRows; i++) {

            if (i == 0) {
                for (int j = 0; j < length; j = j + 2 * numRows - 2) {
                    stringBuilder.append(charArray[j]);
                }
            } else if (i == numRows - 1) {
                for (int j = i; j < length; j = j + 2 * numRows - 2) {
                    stringBuilder.append(charArray[j]);
                }
            } else {
                for (int j = i; j < length; j = j + 2 * numRows - 2) {
                    stringBuilder.append(charArray[j]);
                    if ((j + 2 * numRows - 2 - 2 * j % (2 * numRows - 2)) < length) {
                        stringBuilder.append(
                                charArray[
                                        (j + 2 * numRows - 2 - 2 * j % (2 * numRows - 2))
                                        ]);
                    }
                }

            }
        }

        return stringBuilder.toString();
    }


    public static List<String> fullJustify(String[] words, int maxWidth) {

        int length = words.length;
        List<String> res = new ArrayList<String>();
        int totalLength = words[0].length();
        int fromIndex = 0;

        for (int i = 0; i < length; i++) {
            if (i != length - 1) {
                totalLength++;
                totalLength += words[i + 1].length();
                if (totalLength > maxWidth) {
                    //即拼接fromIndex -> i 这几个字符串
                    StringBuilder stringBuilder = new StringBuilder();
                    int currentLength = 0;
                    for (int j = fromIndex; j <= i; j++) {
                        currentLength += words[j].length();
                    }
                    int leftLength = maxWidth - currentLength;

                    int mod = 0;
                    int modLeft = 0;
                    if (i - fromIndex == 0) {
                        mod = maxWidth - words[i].length();
                        modLeft = 0;
                    } else {
                        mod = leftLength / (i - fromIndex);
                        modLeft = leftLength % (i - fromIndex);
                    }


                    for (int j = fromIndex; j <= i; j++) {
                        stringBuilder.append(words[j]);
                        if (j != i) {
                            for (int a = 0; a < mod; a++) {
                                stringBuilder.append(" ");
                            }
                            if (modLeft != 0) {
                                stringBuilder.append(" ");
                                modLeft--;
                            }

                        }
                    }
                    String str = stringBuilder.toString();
                    if (str.length() < maxWidth) {
                        String whiteSpace = "";
                        for (int a = 0; a < maxWidth - str.length(); a++) {
                            whiteSpace += " ";
                        }
                        str += whiteSpace;
                    }
                    res.add(str);
                    fromIndex = i + 1;
                    totalLength = 0;
                    totalLength += words[i + 1].length();
                } else {

                }
            } else {
                //即拼接fromIndex -> i 这最后几个字符串
                //左端对其
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = fromIndex; j <= i; j++) {
                    stringBuilder.append(words[j]);
                    if (j != i) {
                        stringBuilder.append(" ");
                    }
                }
                String str = stringBuilder.toString();
                if (str.length() < maxWidth) {
                    String whiteSpace = "";
                    for (int a = 0; a < maxWidth - str.length(); a++) {
                        whiteSpace += " ";
                    }
                    str += whiteSpace;
                }

                res.add(str);
            }
        }
        return res;
    }

    public static void printArray(int[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
                System.out.printf(" ");
            }
            System.out.println();
        }
    }
}
