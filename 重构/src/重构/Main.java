package �ع�;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Movie movie = new Movie("���ƶ�����",0);
		Rental rental = new Rental(movie,2);
		Customer customer = new Customer("����ͮ");
		customer.addRental(rental);
		System.out.println(customer.statement());
	}

}
