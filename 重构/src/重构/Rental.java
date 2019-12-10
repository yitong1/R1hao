package 重构;
//租赁
public class Rental {
	private Movie _movie;//影片名
	private int _daysRented;//租期
	
	public Rental(Movie movie,int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}
	
	public int getDaysRented() {
		return _daysRented;
	}
	
	public Movie getMovie() {
		return _movie;
	}
	
	double getCharge(){
	return _movie.getCharge(_daysRented);
	}
	int getFrequentRenterPoints() {
		return _movie.getFrequentRenterPoints(_daysRented);
	}
}
