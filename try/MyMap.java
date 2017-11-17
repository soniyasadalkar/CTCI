import java.util.*;
class MyMap{
	public static void main(String[] args){
		String[] keys = new String[]{"hi", "my", "name", "is", "Soniya"};
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(String s : keys){
			if(map.containsKey(s)){
				map.put(s, map.get(s) + 1);
			}else
				map.put(s, 1);
		}

		for(Map.Entry entry : map.entrySet()){
			System.out.println(entry.getKey()+" "+entry.getValue());
		}

		System.out.println("\nwith iterator");
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry pair = (Map.Entry)it.next();
			System.out.println(pair.getKey()+" "+pair.getValue());
		}
		System.out.println("\nwith iterator");
		Iterator<Map.Entry<String, Integer>> it1 = map.entrySet().iterator();
		while(it1.hasNext()){
			Map.Entry<String, Integer> pair = it1.next();
			System.out.println(pair.getKey()+" "+pair.getValue());
		}
	}
}
