import java.text.*;
//import org.apache.commons.lang.ArrayUtils ;
import java.util.*;
class MyString{
	public static void main(String[] args){
		int num = 10;
		double d = 1.2345;
		String fs = String.format("the number is = %d, decimal number is = %.2f", num, d);
		System.out.println(fs);
		double d1 = 342.34568;
		float f1 = 12.32233f;
     		DecimalFormat f = new DecimalFormat("##.000");
     		System.out.println(f.format(d1));
     		System.out.println(f.format(f1));

		String val = "123";
		int v = Integer.valueOf(val);
		int v2 = Integer.parseInt(val);
		System.out.println(v);
		System.out.println(v2);

		String val2 = "123.222222";
		double dval = Double.valueOf(val2);
		System.out.println(String.format("%.2f",dval));

		int[] ar1 = {111,2,43,4,50};
		Arrays.sort(ar1);
		System.out.println(Arrays.toString(ar1));
		System.out.println(Arrays.binarySearch(ar1, 50));
		System.out.println(Arrays.binarySearch(ar1, 500));
		List<Integer> alist = new ArrayList<Integer>();
		for(int i = 0; i < ar1.length; i++){
			alist.add(ar1[i]);
		}
		Collections.reverse(alist);
		System.out.println(alist.toString());
		int[] arr2 = new int[alist.size()];
		for(int i = 0; i < arr2.length; i++){
			arr2[i] = alist.get(i);
		}
		System.out.println(Arrays.toString(arr2));
	}
}
