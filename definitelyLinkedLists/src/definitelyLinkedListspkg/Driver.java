package definitelyLinkedListspkg;

import java.util.LinkedList;

public class Driver {
	
	public static void main(String[] args) {
		
		LinkedList link = new LinkedList();
		
		link.add("Link");
		link.add("Zelda");
		link.add("Ganon");
		link.add(2);
		
		link.remove();
		
		System.out.println(link);
		
	}

}
