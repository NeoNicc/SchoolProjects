//inherits from Product

public class Electronics extends Product {
	private int warrantyPeriod;
	
	//nested static class for encapsulation
	public static class Builder extends Product.AbstractBuilder<Builder> {
		private int warrantyPeriod = 0;
		
		public Builder warrantyPeriod(int months) {
			if (months > 0) this.warrantyPeriod = months;
			return this;
		}
		
		//keeps typing as electronics instead of 
		//switching back to Product
		@Override
		protected Builder self() {
			return this;
		}
		
		//uses input parameters to build the 
		//electronics product
		@Override
		public Electronics build() {
			return new Electronics(this);
		}
	}
	
	//constructor that assigns the builder
	//values to the actual electronics
	private Electronics(Builder builder) {
		super(builder);
		this.warrantyPeriod = builder.warrantyPeriod;
	}
	
	//getter
	public int getWarrantyPeriod() {
		return warrantyPeriod;
	}
	
	//setter
	public void setWarrantyPeriod(int months) {
		if (months >= 0) this.warrantyPeriod = months;
	}
	
	@Override
	public double calculateTotalValue() {
		return (getPrice() * 1.1) * getQuantity();
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format("\nWarranty Period (months): %d", warrantyPeriod);
	}
}
