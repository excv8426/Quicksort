import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Quicksort {
	public static List<Integer> numbers=new ArrayList<>();

	public static void main(String[] args) {
		generatenumbers();
		//printnumbers(numbers);
		Date date1=new Date();
		sort(numbers,0,4999999);
		Date date2=new Date();
		//printnumbers(numbers);
		System.out.println("time:"+Long.toString(date2.getTime()-date1.getTime()));
	}
	
	public static void generatenumbers(){
		Random rd=new Random();
		for (int i = 0; i < 5000000; i++) {
			numbers.add(rd.nextInt());
		}
	}
	
	public static void printnumbers(List<Integer> nums){
		for (int i = 0; i < nums.size(); i++) {
			System.out.println(nums.get(i));
		}
		System.out.println("************************");
	}
	
	public static void sort(List<Integer> nums,Integer startindex,Integer endindex){
		Integer temnum=0;
		Integer startnum=nums.get(startindex);
		Integer centerindex=startindex;
		int i = startindex+1,j=endindex;
		
		for (; i <= j; i++) {
			centerindex=i;
			if (nums.get(i)>startnum) {
				centerindex=i-1;
				for (; j > i; j--) {
					if (nums.get(j)<startnum) {
						temnum=nums.get(i);
						nums.set(i, nums.get(j));
						nums.set(j, temnum);
						centerindex=i;
						break;
					}
				}
			}

		}

		nums.set(startindex, nums.get(centerindex));
		nums.set(centerindex, startnum);
		
		//System.out.println("centerindex"+centerindex);
		
		if ((centerindex-startindex)>1) {
			sort(nums, startindex, centerindex-1);
		}
		if ((endindex-centerindex)>1) {
			sort(nums, centerindex+1, endindex);
		}
	}
}
