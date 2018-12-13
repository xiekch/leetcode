class Solution {
    public int romanToInt(String s) {
        String romanChar="IVXLCDM";
        int [] romanNum={1,5,10,50,100,500,1000};
        int result=0;
        
        for(int i=0;i<s.length()-1;i++){
            if(romanChar.indexOf(s.charAt(i))<romanChar.indexOf(s.charAt(i+1))){
                result-=romanNum[romanChar.indexOf(s.charAt(i))];
            }else{
                result+=romanNum[romanChar.indexOf(s.charAt(i))];
            }
                // System.out.println(result);
            
        }
        result+=romanNum[romanChar.indexOf(s.charAt(s.length()-1))];
                                           
        return result;
    }
}