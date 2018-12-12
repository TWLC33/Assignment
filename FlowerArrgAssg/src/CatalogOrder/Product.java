
package CatalogOrder;

class Product {
   
    private String productCode;                 //code of product
    private String productDesc;			//description of product
    private double productPrice;		//price of product
    
    public Product(String productCode, String productDesc, double productPrice)
    {
        this.productCode = productCode;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
    }   
       	
   	public String getProductCode(){
   		return productCode;
   	}
   	
   	public String getProductDesc(){
   		return productDesc;
   	}
        
   	public double getProductPrice(){
   		return productPrice;
   	}
   	           	
   	public void setProductCode(String productCode){
   		 this.productCode = productCode;
   	}
        
   	public void setProductDesc(String productDesc){
   		this.productDesc = productDesc;
   	}
   	
   	public void setProductPrice(double productPrice){
   		this.productPrice = productPrice;
   	}
}
