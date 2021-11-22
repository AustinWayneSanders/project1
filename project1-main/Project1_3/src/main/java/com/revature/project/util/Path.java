package com.revature.project.util;

public class Path {

	public static class Web {
        public static final String INDEX = "/index";
        public static final String LOGIN = "/login";
        public static final String LOGOUT = "/logout";
        public static final String PRODUCTS = "/products";
        public static final String ONE_PRODUCT = "/products/\\{productName}";
    }

    public static class Template {
        public static final String INDEX = "/velocity/index/index.vm";
        public static final String LOGIN = "/velocity/login/login.vm";
        public static final String PRODUCTS_ALL = "/velocity/product/all.vm";
        public static final String PRODUCT_ONE = "/velocity/product/one.vm";
        public static final String NOT_FOUND = "/velocity/notFound.vm";
    }
	
	
}
