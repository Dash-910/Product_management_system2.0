
package com.manage.product;


public class Product {
	    private String ProductName;
	    private String ProductType;
	    private String ProductPlace;
	    private String ProductBrand;
	    private double ProductPrice;
	    private int ProductWarranty;
	    
	    
		public Product(String productName, String productType, String productPlace, String productBrand,
				double productPrice, int productWarranty) {
			super();
			ProductName = productName;
			ProductType = productType;
			ProductPlace = productPlace;
			ProductBrand = productBrand;
			ProductPrice = productPrice;
			ProductWarranty = productWarranty;
		}


		public Product() {
			super();
			// TODO Auto-generated constructor stub
		}


		public String getProductName() {
			return ProductName;
		}


		public void setProductName(String productName) {
			ProductName = productName;
		}


		public String getProductType() {
			return ProductType;
		}


		public void setProductType(String productType) {
			ProductType = productType;
		}


		public String getProductPlace() {
			return ProductPlace;
		}


		public void setProductPlace(String productPlace) {
			ProductPlace = productPlace;
		}


		public String getProductBrand() {
			return ProductBrand;
		}


		public void setProductBrand(String productBrand) {
			ProductBrand = productBrand;
		}


		public double getProductPrice() {
			return ProductPrice;
		}


		public void setProductPrice(double productPrice) {
			ProductPrice = productPrice;
		}


		public int getProductWarranty() {
			return ProductWarranty;
		}


		public void setProductWarranty(int productWarranty) {
			ProductWarranty = productWarranty;
		}


		@Override
		public String toString() {
			return "Product [ProductName=" + ProductName + ", ProductType=" + ProductType + ", ProductPlace="
					+ ProductPlace + ", ProductBrand=" + ProductBrand + ", ProductPrice=" + ProductPrice
					+ ", ProductWarranty=" + ProductWarranty + "]";
		}    
}
