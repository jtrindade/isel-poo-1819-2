import java.util.*;

public class Colls {

	public static void main(String[] args) {
		
		Map<String, Integer> objs = new HashMap<String, Integer>();
		
		for (String arg : args) {
			
			if (objs.containsKey(arg)) {
				objs.put(arg, objs.get(arg) + 1);
			} else {
				objs.put(arg, 1);
			}
			
		}
		
		Set<String> keys = objs.keySet();
		for (String key : keys) {
			System.out.println(key + " : " + objs.get(key));
		}
	}
	
}
