/******************************
 * User: yuan
 * Date: 18-4-27 下午5:39
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package JobHunter;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class FindMidNum {
    int count = 0;
    // 大根堆
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    // 小根堆
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public void Insert(Integer num) {
        if (maxHeap.isEmpty())
            maxHeap.add(num);
        else if (maxHeap.size() > minHeap.size()){
            if (num >= maxHeap.peek())
                minHeap.add(num);
            else {
                Integer max = maxHeap.poll();
                minHeap.add(max);
                maxHeap.add(num);
            }
        }else if (maxHeap.size() <= minHeap.size()){
            if (num <= minHeap.peek())
                maxHeap.add(num);
            else {
                Integer min = minHeap.poll();
                maxHeap.add(min);
                minHeap.add(num);
            }
        }
        count ++;

    }

    /*public void printQueue(){
        for (int integer: maxHeap)
            System.out.printf("%d\t", integer);
    }*/

    public Double GetMedian() {
        if (count %2 == 0)
            return (maxHeap.peek() + minHeap.peek() + 0.0) / 2;
        else
            return maxHeap.peek() + 0.0;
    }

    public static void main(String[] args) {
        int[] input = {5,2,3,4,1,6,7,0,8};
        FindMidNum findMidNum = new FindMidNum();
        for (int item: input){
            findMidNum.Insert(item);
            System.out.println(findMidNum.GetMedian());
        }

    }

    /*
    int mid = 0;
    int mid1 = 0;
    LinkedList<Integer> nums = new LinkedList<>();
    public void Insert(Integer num) {
        if (nums.isEmpty())
            nums.add(num);
        else {
            int i = nums.size()-1;
            for (; i >= 0; i --){
                if (num > nums.get(i)){
                    nums.add(i+1, num);
                    break;
                }
            }
            if (i < 0)
                nums.add(0, num);
        }
        if (nums.size() %2 == 1){
            mid = nums.size() / 2;
            mid1 = mid;
        }else{
            mid = nums.size() / 2;
            mid1 = mid-1;
        }
    }

    public Double GetMedian() {
        return (nums.get(mid) + nums.get(mid1) + 0.0)/2;
    }

    public static void main(String[] args) {
        int[] input = {5,2,3,4,1,6,7,0,8};
        FindMidNum findMidNum = new FindMidNum();
        for (int item: input){
            findMidNum.Insert(item);
            System.out.println(findMidNum.GetMedian());
        }

    }
    */
}
