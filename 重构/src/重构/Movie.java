package 重构;
//影片
public class Movie {
	public static final int CHILDRENS = 0;
	public static final int NEW_RELEASE = 0;

	public Movie(String title,int priceCode) {
		_title = _title;
		setPriceCode(priceCode);
	}
	
	public static final int CHILDRENDS =2;//儿童片
	public static final int REGULAR = 0;//普通片
	public static final int NEW_RELEASE = 1;//新片
	
	private String _title;//影片类型
	private int _priceCode;//影片价格
	
	public Movie(String title, int priceCode) {
		_title = title;
		_priceCode = priceCode;
	}
	
	public int getPriceCode() {
		return _priceCode;
	}
	
	public void setPriceCode(int arg) {
		_priceCode = arg;
	}
	
	public String getTitle() {
		return _title;
	}
	double getCharge(int daysRented){
		double result = 0;
		//determine amounts for each line
		switch (getPriceCode()) {
		case Movie.REGULAR:
			result +=2;
			if(daysRented() >2)
				result += (daysRented() - 2)*1.5;
			break;
		case Movie.NEW_RELEASE:
			result += daysRented() * 3;
			break;
		case Movie.CHILDRENDS:
			result += 1.5;
			if(daysRented() >3)
				result += (daysRented() - 3) * 1.5;
			break;
		
	  }
	return result;
	}
	int getFrequentRenterPoints() {
		if((getPriceCode() == Movie.NEW_RELEASE)
				&&daysRented() > 1) return 2;
		else
			return 1;
	}

	private int daysRented() {
		// TODO Auto-generated method stub
		return 0;
	}


	private void setPriceCode(int priceCode) {
		// TODO Auto-generated method stub
		
	}
	
}
