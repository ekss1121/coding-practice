public class SimplifyFrac{
	public static void main(String[] args){
		long num = 48;
		System.out.println(LargestPrimeFactor(num));
	}

	public static long LargestPrimeFactor(long num){

		long return_value = 0;
		for (long i=num-1; i>0; i--){
			if (num % i == 0){
				return_value = i;
				break;
			}
		}

		return return_value;
	}
}