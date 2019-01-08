package dataBaseManager;

/**
 *Class for inserting and getting product data in data base 
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import product.Product;

public class DataBaseManager {
	private String url = "jdbc:mysql://localhost:3306/";
	private String driver = "com.mysql.jdbc.Driver";
	private String db = "my_db";
	private String user = "root";
	private String password = "root";
	ArrayList<Product> list;
	
	public DataBaseManager() throws Exception {
		super();
		list = new ArrayList<Product>();
	}
	
	//method for inserting new product in database
	public int insertProduct (Product product) throws Exception {
		int ind = 0;
		Class.forName(driver);
		try (Connection connect = DriverManager.getConnection(url+db+"?useUnicode=yes&characterEncoding=UTF-8&useSSL=false", user, password);
			PreparedStatement pstm = connect.prepareStatement("INSERT  INTO products (name, brand, color, description, price) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);) {
			pstm.setString(1, product.getName());
			pstm.setString(2, product.getBrand());
			pstm.setString(3, product.getColor());
			pstm.setString(4, product.getDescription());
			pstm.setDouble(5, product.getPrice());
			pstm.executeUpdate();
			ResultSet rs = pstm.getGeneratedKeys();
			while (rs.next()) {
				ind = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ind;
}
	
	//method for getting product data from data base (in view of  list)
	public ArrayList<Product> getProducts (Product product) throws Exception {
		String sql = "SELECT*FROM products";
		String params = "";
		if (product.getName()!=null&&!product.getName().isEmpty()) {
			params += "name='"+product.getName() +"' AND ";
		}
		if (product.getBrand()!=null&&!product.getBrand().isEmpty()) {
			params += "brand='"+product.getBrand() + "' AND ";
		}
		if (product.getColor()!=null&&!product.getColor().isEmpty()) {
			params += "color='"+product.getColor() + "' AND ";
		}
		if (product.getMinPrice()!=0) {
			params += "price>="+product.getMinPrice() + " AND ";
		}
		if (product.getMaxPrice()!=0) {
			params += "price<="+product.getMaxPrice()+" AND ";
		}
		if (!params.isEmpty()) {
			sql += " WHERE "+params;
			sql = sql.substring(0, sql.lastIndexOf(" AND "));
		}
		Class.forName(driver);
		try (Connection connect =  DriverManager.getConnection(url+db+"?useUnicode=yes&characterEncoding=UTF-8&useSSL=false", user, password);
			Statement stm = connect.createStatement();){
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				Product prod = new Product();
				prod.setId(rs.getInt(1));
				prod.setName(rs.getString(2));
				prod.setBrand(rs.getString(3));
				prod.setColor(rs.getString(4));
				prod.setDescription(rs.getString(5));
				prod.setPrice(rs.getDouble(6));
				list.add(prod);
			}
		}
		return list;
	}
}
