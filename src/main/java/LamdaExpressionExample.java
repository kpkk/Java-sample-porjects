import java.util.ArrayList;
import java.util.Collections;

public class LamdaExpressionExample {

	public static void main(String[] args) {
		
		LambdaExpressions ll=()->{
			System.out.println("draw method implementation");
		
		};
			
			ll.draw();
			
			ArrayList<String> list=new ArrayList<String>();
			list.add("pradeep");
			list.add("roger");
			list.add("rafa");
			list.add("abc");
			
			list.forEach((n)->System.out.println(n));
			
			System.out.println("printing the names in sorting order by name");
			Collections.sort(list,(p1,p2)->{
				return p1.compareTo(p2);
						});
			
			//System.out.println("after sort");
			
			list.forEach(m->System.out.println(m));
	}
	
		
	}


