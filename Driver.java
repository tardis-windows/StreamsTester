 
import java.util.stream.IntStream; 
import java.security.SecureRandom; 
import java.util.stream.Collectors;

public class Driver {
	
	public static void main(String[] args) {
	System.out.printf("Sum of 1 through 10 is: %d%n:", IntStream.rangeClosed(1,10).sum());
	
	System.out.printf("count: %d%n:", IntStream.rangeClosed(1,10).count());
	
	/*
	 * Mapping -> transform stream's elements to new values 
	 */
	
	// for loop 
	
	System.out.printf("Sum of the even ints from 2 through 20 is: %d%n", IntStream.rangeClosed(1, 10).map((int x)->{return x*2;}).sum());
	
	// .map((int x)->{return x*2;}  this is a lambda expression methods treated as data
	
	// (parameterList)->{statements}
	
	// also (x)->{return x*2;}     (x)->x*2; 
	
	System.out.printf("Sum of thre triples of the even ints from 2 through 10 is: %d%n",
			IntStream.rangeClosed(1, 10).filter(x -> x%2==0).map(x -> x*3).sum());
	
	IntStream.rangeClosed(1, 10).filter(x->{System.out.printf("%nfilter: %d%n",x);
	return x%2==0;}).map(x->{System.out.println("map: "+x);return x*3;
	}).sum();
	
	SecureRandom randomNumbers = new SecureRandom(); 
	
	System.out.println("Random numbers on separate lines: ");
	randomNumbers.ints(10,1,7).forEach(System.out::println);  // 10 random numbers from 1-7
	
	String numbers = randomNumbers.ints(10,1,7).mapToObj(String::valueOf).collect(Collectors.joining(" "));
	
	System.out.printf("%nRandom numbers on one line: %s%n",numbers);
	
	
	}
}