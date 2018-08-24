import java.util.*;
public class Computer{
	static HashSet<Integer> set = new HashSet<>();

	int id;
	public Computer(int id){
		while(set.contains(id)){
			id++;
		}
		set.add(id);
		this.id = id;
	}
}