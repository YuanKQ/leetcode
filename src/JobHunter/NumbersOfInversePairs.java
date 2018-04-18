/******************************
 * User: yuan
 * Date: 18-4-17 下午10:20
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package JobHunter;

public class NumbersOfInversePairs {
    static int base = 1000000007;
    public int InversePairs(int [] array) {
        if (array == null || array.length == 0)
            return 0;
        int[] copy = new int[array.length];
        return helpInversePairs(array, copy, 0, array.length-1);
    }

    private int helpInversePairs(int[] array, int[] copy, int low, int high) {
        if (low >= high)
            return 0;
        int mid = (low + high) >> 1;
        int leftCount = helpInversePairs(array, copy, low, mid) % base;
        int rightCount = helpInversePairs(array, copy, mid+1, high) % base;
        int icopy = high;
        int i = mid;
        int j = high;
        int count = 0;
        while (i >= low && j > mid){
            if (array[i] > array[j]){
                count += j - mid;
                copy[icopy --] = array[i --];
                if (count >= base)
                    count %= base;
            } else {
                copy[icopy --] = array[j --];
            }
        }
        for (; i >= low; i --)
            copy[icopy --] = array[i];
        for (; j > mid; j --)
            copy[icopy --] = array[j];
        for (int k = low; k <= high; k ++)
            array[k] = copy[k];
        return (leftCount + rightCount + count) % base;
    }

    public static void main(String[] args) {
        int[] ary = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        System.out.println(new NumbersOfInversePairs().InversePairs(ary));

    }
}
