/******************************
 * User: yuan
 * Date: 18-4-24 上午11:51
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package JobHunter;

public class FindDuplicateNumber {
    public boolean findDuplicateNumber(int numbers[],int length,int [] duplication){
        for (int i = 0; i < length; i ++){
            if (numbers[i] < 0 || numbers[i] >= length)
                return false;
            while (numbers[i] != i){
                int m = numbers[i];
                if (numbers[i] == numbers[m]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                int temp = numbers[m];
                numbers[m] = numbers[i];
                numbers[i] = temp;
            }
        }
        return false;
    }
}
