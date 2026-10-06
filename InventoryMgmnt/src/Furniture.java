//inherits from Product

public class Furniture extends Product {
	private String materialType;
	
	//nested static class for encapsulation
	public static class Builder extends Product.AbstractBuilder<Builder> {
		private String materialType = "";
		
		public Builder materialType(String material) {
			if (material != null) this.materialType = material;
			return this;
		}
		
		//keeps typing as furniture instead of 
		//switching back to Product
		@Override
		protected Builder self() {
			return this;
		}
		
		//uses input parameters to build the 
		//furniture product
		@Override
		public Furniture build() {
			return new Furniture(this);
		}
	}
	
	//constructor that assigns the builder
	//values to the actual electronics
	private Furniture(Builder builder) {
		super(builder);
		this.materialType = builder.materialType;
	}
	
	//getter
	public String getMaterialType() {
		return materialType;
	}
	
	//setter
	public void setMaterialType(String type) {
		if (type != null) this.materialType = type;
	}
	
	@Override
	public double calculateTotalValue() {
		return super.calculateTotalValue() * 1.05;
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format("\nMaterial used: %s", materialType);
	}
}