package com.globant.finalproject.enumerates;

public final class ApiEndpoints {

	public final static String SHOPPINGCART = "/shoppingCart";

	public final static String CUSTOMER_REGISTRATION = "/customer/registration";
	public final static String CUSTOMER_GET_CUSTOMER = "/customer/getCustomer";
	public final static String CUSTOMER_DELETE_CUSTOMER = "/customer/deleteCustomer";
	public final static String CUSTOMER_GET_ALLCUSTOMER = "/customer/getAllCustomers";
	public final static String CUSTOMER_BUY_CART = "/customer/buyCart";

	public final static String PRODUCT_REGISTRATION = "/product/productRegistration";
	public final static String PRODUCT_DELETE = "/product/deleteProduct";
	public final static String PRODUCT_GET_ALLPRODUCT = "/product/getAllProducts";
	public final static String PRODUCT_GET_PRODUCT = "/product/getProduct";
	public final static String PRODUCT_GET_BYCATEGORY = "/product/getBycategory";
	public final static String PRODUCT_GET_BYNAME = "/product/getByname";

	public final static String CART_ADD = "/cart/addCart";
	public final static String CART_GET = "/cart/getCart";

	public final static String CARTITEM_ADD = "/cart/cartItems/addProduct";
	public final static String CARTITEM_REMOVE = "/cart/cartItems/removeProduct";
	public final static String CARTITEM_GET = "/cart/cartItems/getCartItem";	
	
	private ApiEndpoints() {
		
	}	

}
