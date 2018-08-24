import java.util.*;

public class IndeedOA {
        public static void main(String[] argv){
                System.out.println("Please enter: ");
        Scanner scanner = new Scanner(System.in);
        List<Integer> rateAry = new ArrayList<>();
        //List<Integer> midAry = new ArrayList<>();
        Map<Integer, List<Integer>> idMap = new HashMap<>();
        int rootId = -1;
        int id = 0;
        while(scanner.hasNextInt()) {
            int curRate = scanner.nextInt();
            int curMid = scanner.nextInt();
            rateAry.add(curRate);
            //midAry.add(curMid);
            idMap.putIfAbsent(curMid, new ArrayList<>());
            idMap.get(curMid).add(id);
            if(curMid == -1) {
                rootId = id;
            }
            id++;
        }
        scanner.close();
        
        for(int rate : rateAry) {
                        System.out.println("Rate is: " + rate);
        }
        System.out.println("---------------------------------");
        Queue<Integer> q = new LinkedList<>();
        q.add(rootId);
        while(!q.isEmpty()) {
            int cur = q.poll();
            if(idMap.containsKey(cur)) {
                int curRate = rateAry.get(cur);
                for(int child : idMap.get(cur)) {
                    if(rateAry.get(child) > curRate) {
                        rateAry.set(child, curRate);
                    }
                    q.offer(child);
                }
            }
        }
            int sum = 0;
            for(int rate : rateAry) {
                sum += rate;
                System.out.println("Rate is: " + rate);
            }

            System.out.println("Total rate is: " + sum);
    }
}