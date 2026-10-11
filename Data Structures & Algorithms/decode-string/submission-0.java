class Solution {
    public String decodeString(String s) {
        Stack<Integer> stkNum = new Stack<>();
        Stack<StringBuilder> stkStr = new Stack<>();

        int number = 0;
        StringBuilder current = new StringBuilder();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                number = number*10+(ch-'0');
            }else if(ch=='['){
                stkNum.push(number);
                stkStr.push(current);

                number = 0;
                current = new StringBuilder();
            }else if(ch==']'){
                int count = stkNum.pop();
                StringBuilder previous = stkStr.pop();
                while(count>0){
                    previous.append(current);
                    count--;
                }
                current=previous;
            }else{
                current.append(ch);
            }
        } 
        return current.toString();
    }
}