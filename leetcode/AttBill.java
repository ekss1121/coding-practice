import java.util.*;

public class AttBill{
	public double[] calculate(double[] usage, double money){
		List<Double> rst = new ArrayList<>();

		if(usage == null || usage.length == 0) return null;
		double[] over = new double[usage.length];
		double sum = 0;
		for(int i=0; i<usage.length; i++){
			over[i] = usage[i] - 1.5;
			sum += over[i];
		}
		for(int i=0; i<over.length;i++){
			rst.add(over[i]/sum * money);
		}

		for(int i=0; i<rst.size(); i++){
			usage[i] = rst.get(i);
		}

		return usage;

	}

	public static void main(String[] args){
		AttBill myBill = new AttBill();
		String[] number = new String[] {"404-226-3602", "404-310-2387", 
										"404-376-8876", "404-414-8149",
										"404-434-9620", "404-580-0451",
										"678-910-8687"};
		double[] usage = new double[] {2.94, 2.11, 2.09, 2.84, 4.30, 1.95, 2.56};
		double[] moneys = myBill.calculate(usage, 90);

		for(int i=0; i<moneys.length; i++){
			System.out.print(number[i] + ": " + moneys[i] + "\n");
		}
	}
}