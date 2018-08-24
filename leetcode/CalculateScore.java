import java.util.*;

public class CalculateScore{
	public static void main(String[] args){

		System.out.println("Please enter: Score Manager id:" );
		Scanner input = new Scanner(System.in);

		List<Integer> score = new ArrayList<>();
		//List<Integer> manager = new ArrayList<>();

		Map<Integer, List<Integer>> map = new HashMap<>();

		int rootId = -1;
		int id = 0;

		while(input.hasNextInt()){
			int scr = input.nextInt();
			int mid = input.nextInt();
			score.add(scr);
			//manager.add(mid);
			map.putIfAbsent(mid, new ArrayList<>());
			map.get(mid).add(id);
			if(mid  == -1){
				rootId = id;
			}

			id++;
		}

		input.close();

		for(int i=0; i<score.size(); i++){
			System.out.println("Score is: " + score.get(i));
		}
		System.out.println("----------------------------");

		// BFS to setup the score based on its's manager

		Queue<Integer> q = new LinkedList<>();
		q.offer(rootId);
		while(!q.isEmpty()){
			int cur = q.poll();
			int curScore = score.get(cur);
			List<Integer> team = map.get(cur);
			if(team != null){
				for(int i=0; i<team.size(); i++){
					if(score.get(team.get(i)) > curScore){
						score.set(team.get(i), curScore);
					}
					q.offer(team.get(i));
				}
			}
		}

		for(int i=0; i<score.size(); i++){
			System.out.println("New socre is: "+ score.get(i));
		}

		int sum = 0;
		for(int s : score){
			sum += s;
		}

		System.out.println("Sum = " + sum);
	}
}