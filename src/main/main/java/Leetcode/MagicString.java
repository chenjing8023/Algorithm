package Leetcode;

/**
 * Created by hadoop on 17-5-29.
 */
public class MagicString {
    public int magicalString(int n) {
        StringBuilder magic = new StringBuilder("1221121221221121122");
        int pt1 = 12, pt2 = magic.length(), count = 0;
        while(magic.length() < n){
            if(magic.charAt(pt1) == '1'){
                if(magic.charAt(pt2-1) == '1') magic.append(2);
                else magic.append(1);
                pt2++;
            }else{ //==2
                if(magic.charAt(pt2-1) == '1') magic.append(22);
                else magic.append(11);
                pt2+=2;
            }
            pt1++;
        }
        for(int i=0;i<n;i++)
            if(magic.charAt(i)=='1') count++;
        return count;


        /*if (n <= 0) return 0;
        if (n <= 3) return 1;
        String str = "122";
        int tail = 3;
        int head = 2;
        int num = 0;
        int number = 1;
        int result =1;
        while ( tail < n){
            num = str.charAt(head) - '0';
            for(int j = 0; j<num; j++){
                str += number;
                if(number == 1 && tail < n) {
                    result++;
                }

                ++tail;
            }
            number = number ^ 3;
            ++head;
        }
        return result;*/
    }
}
