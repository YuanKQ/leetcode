/******************************
 * User: yuan
 * Date: 18-4-25 下午10:37
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package JobHunter;

public class StringIsNumber {
    public boolean isNumeric(char[] str) {
        boolean isPoint = false;
        for (int i = 0; i < str.length; i ++) {
            if (isOperator(str[i])){
                if (i == str.length-1 )
                    return false;
                else if (i == 0 || (i-1 > 0 && (str[i-1] == 'e' || str[i-1] == 'E')))
                    continue;
                else
                    return false;
            }else if (isExponent(str[i])){
                if (i-1 >= 0 && isNumber(str[i-1])){
                    if (i+1 < str.length && (isNumber(str[i+1]) || isOperator(str[i+1]))) {
                        isPoint = false;
                        continue;
                    }
                }
                return false;
            }else if (str[i] == '.'){
                if (i != 0 && i-1 >= 0 && i+1 < str.length && (isNumber(str[i-1])||isOperator(str[i-1])) && isNumber(str[i+1]))
                    continue;
                return false;
            }else if (isNumber(str[i]))
                continue;
            else return false;
        }

        return true;
    }

    boolean isNumber(char ch){
        if (ch >= '0' && ch <= '9')
            return true;
        else return false;
    }

    boolean isOperator(char ch){
        if (ch == '-' ||ch == '+')
            return true;
        else return false;
    }

    boolean isExponent(char ch){
        if (ch == 'e' || ch == 'E')
            return true;
        else return false;
    }

    public static void main(String[] args) {
        char[] nums = {'1', '2', 'e'};
        System.out.println(new StringIsNumber().isNumeric(nums));

    }
}
