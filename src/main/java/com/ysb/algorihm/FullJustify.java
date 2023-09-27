package com.ysb.algorihm;


import java.util.ArrayList;
import java.util.List;

public class FullJustify {
    public static void main(String[] args) {

        fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20);

    }

    public static List<String> fullJustify(String[] words, int maxWidth) {

        int length = words.length;
        List<String> res = new ArrayList<String>();
        int totalLength = words[0].length();
        int fromIndex = 0;

        for(int i = 0; i< length ; i++){
            if(i!=length-1){
                totalLength++;
                totalLength += words[i+1].length();
                if(totalLength>maxWidth){
                    //即拼接fromIndex -> i 这几个字符串
                    StringBuilder stringBuilder = new StringBuilder();
                    int currentLength = 0;
                    for(int j = fromIndex ; j<=i ; j++){
                        currentLength+=words[j].length();
                    }
                    int leftLength = maxWidth - currentLength;

                    int mod = 0;
                    int modLeft =  0;
                    if(i-fromIndex==0){
                        mod = maxWidth-words[i].length();
                        modLeft = 0;
                    }else{
                        mod = leftLength/(i-fromIndex);
                        modLeft =  leftLength%(i-fromIndex);
                    }


                    for(int j = fromIndex ; j<=i ; j++){
                        stringBuilder.append(words[j]);
                        if(j!=i){
                            for(int a= 0;a<mod;a++){
                                stringBuilder.append(" ");
                            }
                            if(modLeft!=0){
                                stringBuilder.append(" ");
                                modLeft--;
                            }

                        }
                    }
                    String str = stringBuilder.toString();
                    if(str.length()<maxWidth){
                        String whiteSpace = "";
                        for(int a=0;a<maxWidth-str.length();a++ ){
                            whiteSpace+=" ";
                        }
                        str+=whiteSpace;
                    }
                    res.add(str);
                    fromIndex = i+1;
                    totalLength = 0;
                    totalLength+=words[i+1].length();
                }else{

                }
            }else{
                //即拼接fromIndex -> i 这最后几个字符串
                //左端对其
                StringBuilder stringBuilder = new StringBuilder();
                for(int j = fromIndex ; j<=i ; j++){
                    stringBuilder.append(words[j]);
                    if(j!=i){
                        stringBuilder.append(" ");
                    }
                }
                String str = stringBuilder.toString();
                if(str.length()<maxWidth){
                    String whiteSpace = "";
                    for(int a=0;a<maxWidth-str.length();a++ ){
                        whiteSpace+=" ";
                    }
                    str+=whiteSpace;
                }

                res.add(str);
            }
        }
        return res;
    }}
