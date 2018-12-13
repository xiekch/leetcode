class Solution {
    public String multiply(String num1, String num2) {
        int one=Integer.valueOf(num1);
        int two=Integer.valueOf(num2);

        return Integer.toString(one*two);
    }
}

class Solution {
    public String multiply(String num1, String num2) {
        int len1=num1.length(),len2=num2.length();
        int []pos=new int[len1+len2];

        for(int i=len1-1;i>=0;i--){
            for(int j=len2-1;j>=0;j--){
                int mul=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int ten=i+j,one=i+j+1;
                int sum= mul+pos[one];

                pos[ten]+=sum/10;
                pos[one]=sum%10;
            }
        }

        StringBuffer sb=new StringBuffer();
        for(int t:pos){//from high to low
            if(!(sb.length()==0&&t==0))sb.append(t);
        }
        return sb.length()==0?"0":sb.toString();
    }
}