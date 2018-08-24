public class FactorialSum{
	public static void main(String[] args){
		long results = 0;
		long f = 1;
		for (int i=1; i<=10; i++){
			f = f * i;
			results += f;
		}

		System.out.println("1!+2!+3!+......10! = " + results);
	}
}