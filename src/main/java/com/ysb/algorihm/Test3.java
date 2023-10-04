package com.ysb.algorihm;

import java.util.Deque;
import java.util.LinkedList;

public class Test3 {
    public static void main(String[] args) {
        Test3 aa = new Test3();
        System.out.println(aa.evalRPN(new String[]{"2","1","+","3","*"}));
        System.out.println(aa.evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println(aa.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
        System.out.println("=======================");
        //System.out.println(aa.calculate("1 + 1"));
        //System.out.println(aa.calculate(" 2-1 + 2 "));
        //System.out.println(aa.calculate("(1+(4+5+2)-3)+(6+8)"));


    }

    public int calculate(String s) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        int res = 0;
        int flag = 1;

        int  i =0 ;
        while (i<length){
            if (charArray[i]==' '){
                i++;
            }else if (charArray[i]=='+'){
                flag = stack.peek();
                i++;
            }else if (charArray[i]=='-'){
                flag = -stack.peek();
                i++;
            }else if (charArray[i]=='('){
                stack.push(flag);
                i++;
            }else if (charArray[i]=='+'){
                stack.pop();
                i++;
            }else {
                int num = 0;
                while (i<length&&Character.isDigit(charArray[i])){
                    num = num*10 +charArray[i] - '0';
                }
                res += flag*num;
            }
        }
        return res;
    }

//    public int calculate(String s) {
//        LinkedList<Integer> numStack = new LinkedList<>();
//        LinkedList<Character> operationStack = new LinkedList<>();
//
//        char[] charArray = s.toCharArray();
//
//        for (int i = charArray.length - 1; i >= 0; i--) {
//            if (charArray[i]=='+'||
//                    charArray[i]=='-'||
//                    charArray[i]=='*'||
//                    charArray[i]=='/'||
//                    charArray[i]=='('||
//                    charArray[i]==')'
//            ){
//                operationStack.addLast(charArray[i]);
//            } else if (charArray[i]==' ') {
//
//            } else {
//                numStack.addLast(charArray[i]-'0');
//            }
//        }
//
//        return getResult(numStack,operationStack);
//    }

//    private int getResult(LinkedList<Integer> numStack,LinkedList<Character> operationStack){
//        while (operationStack.size()>0){
//            Character character = operationStack.getLast();
//            if (character=='('){
//                LinkedList<Integer> num = new LinkedList<>();
//                LinkedList<Character> operation = new LinkedList<>();
//                operationStack.removeLast();
//                num.addFirst(numStack.removeLast());
//                int count =0;
//                while (true){
//                    if (operationStack.getLast()==')'&&count==0){
//                        operationStack.removeLast();
//                        break;
//                    }else {
//                        if (operationStack.getLast()=='('){
//                            count++;
//                            operation.addFirst(operationStack.removeLast());
//                        }
//                         else if (operationStack.getLast()==')'){
//                            count--;
//                            operation.addFirst(operationStack.removeLast());
//                        }else {
//                            operation.addFirst(operationStack.removeLast());
//                            num.addFirst(numStack.removeLast());
//                        }
//
//                    }
//                }
//                int result = getResult(num, operation);
//                num.addLast(result);
//            }else {
//                Integer res = 0;
//                Character token = operationStack.removeLast();
//                Integer num1 = numStack.removeLast();
//                Character next = null;
//                if (operationStack.size()>0){
//                    next = operationStack.getLast();
//                }
//
//                Integer num2 = 0;
//                if (null==next||next != '('){
//                    if (numStack.size()>0){
//                        num2 = numStack.removeLast();
//                    }
//                }else {
//                    num2 = getResult(numStack,operationStack);
//                }
//                if (token == '+'){
//                    res = num1 + num2;
//                    numStack.addLast(res);
//                }else if (token == '-'){
//                    if (num2==0){
//                        res = num2 - num1;
//                    }else {
//                        res = num1 - num2;
//                    }
//
//                    numStack.addLast(res);
//                }else if (token == '*'){
//                    res = num1 * num2;
//                    numStack.addLast(res);
//                }else if (token == '/'){
//                    res = num1 / num2;
//                    numStack.addLast(res);
//                }
//
//            }
//        }
//
//        return numStack.removeLast();
//    }
    public int evalRPN(String[] tokens) {
        LinkedList<String> stack = new LinkedList<>();

        for (String token : tokens) {

            Integer res = 0;
            if (token.equals("+")){
                String num1 = stack.removeLast();
                String num2 = stack.removeLast();
                res = Integer.valueOf(num2) + Integer.valueOf(num1);
                stack.addLast(res.toString());
            }else if (token.equals("-")){
                String num1 = stack.removeLast();
                String num2 = stack.removeLast();
                res = Integer.valueOf(num2) - Integer.valueOf(num1);
                stack.addLast(res.toString());
            }else if (token.equals("*")){
                String num1 = stack.removeLast();
                String num2 = stack.removeLast();
                res = Integer.valueOf(num2) * Integer.valueOf(num1);
                stack.addLast(res.toString());
            }else if (token.equals("/")){
                String num1 = stack.removeLast();
                String num2 = stack.removeLast();
                res = Integer.valueOf(num2) / Integer.valueOf(num1);
                stack.addLast(res.toString());
            }else {
                stack.addLast(token);
            }

        }

        return Integer.valueOf(stack.removeLast());
    }
}
