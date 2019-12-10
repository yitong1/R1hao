package 重构;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Movie movie = new Movie("王牌对王牌",0);
		Rental rental = new Rental(movie,2);
		Customer customer = new Customer("李艺彤");
		customer.addRental(rental);
		System.out.println(customer.statement());
	}

}
