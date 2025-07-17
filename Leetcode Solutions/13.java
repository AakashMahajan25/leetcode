class Solution {
    public int romanToInt(String s) {
        
        int answer = 0;

        for (int i=s.length()-1; i>=0; i--) {
            char scannedElement = s.charAt(i);
            char beforeScannedElement = '\0';
            if (i!=0) {
                beforeScannedElement = s.charAt(i-1);
            }
            switch(scannedElement){
                case ('I') -> answer++;
                case ('V') ->
                {   if (i!=0 && beforeScannedElement=='I') {
                    answer+=4;
                    i--;
                    break;
                    }
                answer+=5;
                }
                case ('X') -> 
                {
                    if (i!=0 && beforeScannedElement=='I') {
                        answer+=9;
                        i--;
                        break;
                    }
                    answer+=10;
                }
                case ('L') -> 
                {
                    if (i!=0 && beforeScannedElement=='X') {
                        answer+=40;
                        i--;
                        break;
                    }
                    answer+=50;
                }
                case ('C') -> 
                {
                    if (i!=0 && beforeScannedElement=='X') {
                        answer+=90;
                        i--;
                        break;
                    }
                    answer+=100;
                }
                case ('D') -> {
                    if (i!=0 && beforeScannedElement=='C') {
                        answer+=400;
                        i--;
                        break;
                    }
                    answer+=500;
                }
                case ('M') -> {
                    if (i!=0 && beforeScannedElement=='C') {
                        answer+=900;
                        i--;
                        break;
                    }
                    answer+=1000;
                }
            }
        }

        return answer;

    }
}