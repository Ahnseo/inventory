package domain;

public class Product {
	private String productId;
	private String productBrand;
	private String productName;
	private String BoxUnit;
	private String BoxEA;
	
	private int mainStorage;
	private int subStorage1;
	private int subStorage2;
	private int posStorage;
	private int drinkStorage;
	private int sum;
	
	private double price;
	private double multiplication;
	
	
	public String getBoxUnit() {
		return BoxUnit;
	}
	public void setBoxUnit(String boxUnit) {
		BoxUnit = boxUnit;
	}
	public String getBoxEA() {
		return BoxEA;
	}
	public void setBoxEA(String boxEA) {
		BoxEA = boxEA;
	}
	public double getMultiplication() {
		return multiplication;
	}
	public void setMultiplication(double multiplication) {
		this.multiplication = multiplication;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getMainStorage() {
		return mainStorage;
	}
	public void setMainStorage(int mainStorage) {
		this.mainStorage = mainStorage;
	}
	public int getSubStorage1() {
		return subStorage1;
	}
	public void setSubStorage1(int subStorage1) {
		this.subStorage1 = subStorage1;
	}
	public int getSubStorage2() {
		return subStorage2;
	}
	public void setSubStorage2(int subStorage2) {
		this.subStorage2 = subStorage2;
	}
	public int getPosStorage() {
		return posStorage;
	}
	public void setPosStorage(int posStorage) {
		this.posStorage = posStorage;
	}
	public int getDrinkStorage() {
		return drinkStorage;
	}
	public void setDrinkStorage(int drinkStorage) {
		this.drinkStorage = drinkStorage;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	
	
	

	
	
	
}
