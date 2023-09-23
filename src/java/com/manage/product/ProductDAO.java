
package com.manage.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.manage.CP;

import com.mysql.cj.exceptions.StatementIsClosedException;
import com.mysql.cj.x.protobuf.MysqlxSql.StmtExecute;

public class ProductDAO {
	
	//Add a Product
	public static boolean insertProductToDB(Product pt)
	{
		boolean flag = false;
		try {
			Connection con = CP.createC();
			String query ="INSERT INTO products (pname,ptype,pbrand,pPlace,pwarranty,pPrice) VALUES(?,?,?,?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, pt.getProductName());
			pstmt.setString(2, pt.getProductType());
			pstmt.setString(3, pt.getProductBrand());
			pstmt.setString(4, pt.getProductPlace());
			pstmt.setInt(5, pt.getProductWarranty());
			pstmt.setDouble(6, pt.getProductPrice());
			
			pstmt.executeUpdate();
			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}
    //Delete a Product
	public static boolean deleteProduct ( int ProductId)
	{
		boolean flag = false;
		try {
			Connection con = CP.createC();
			
			String query = "DELETE FROM products WHERE pid = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1,ProductId);
			
			pstmt.executeUpdate();
			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	//show all Products 
	public  static void showAllProducts() {
		try {
			Connection con = CP.createC();
			String query = "SELECT * FROM products";
			
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(query);
			
			while(set.next())
			{
				int id = set.getInt("pid");
				String name  = set.getString("pname");
				String type  = set.getString("pPlace");
				String brand = set.getString("pbrand");
				String place = set.getString("pPlace");
				String warranty = set.getString("pwarranty");
				String price = set.getString("pPlace");	
				
				System.out.println("Id: " + id);
				System.out.println("Name: " + name);
				System.out.println("Type: " + type);
				System.out.println("Brand: " + brand);
				System.out.println("Place: " + place);
				System.out.println("Warranty: " + warranty);
				System.out.println("Price: " + price);
				System.out.println("**************************");
				
			}
			con.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	//Update a Product info
	public static boolean updateProduct(int productId, String newName, String newType, String newBrand, String newPlace, int newWarranty, double newPrice) {
	    boolean flag = false;
	    try {
	        Connection con = CP.createC();
	        String query = "UPDATE products SET pname=?, ptype=?, pbrand=?, pPlace=?, pwarranty=?, pPrice=? WHERE pid=?";
	        PreparedStatement pstmt = con.prepareStatement(query);

	        pstmt.setString(1, newName);
	        pstmt.setString(2, newType);
	        pstmt.setString(3, newBrand);
	        pstmt.setString(4, newPlace);
	        pstmt.setInt(5, newWarranty);
	        pstmt.setDouble(6, newPrice); 
	        pstmt.setInt(7, productId);

	        int rowsAffected = pstmt.executeUpdate();

	        if (rowsAffected > 0) {
	            flag = true;
	        }

	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return flag;
	}
	//To check if product exits before updating
	public static boolean inProductExists(int productId)
	{
		boolean exists = false;
		try {
			Connection con = CP.createC();
			
			String query = "SELECT COUNT (*) FROM PRODUCTS WHERE pid=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, productId);
			
			ResultSet resultSet = pstmt.executeQuery();
			resultSet.next();
			
			int count = resultSet.getInt(1);
			if(count > 0)
			{
				exists = true;
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exists;
	}
	//Get products by type and brand
	public static boolean getByTypeandBrand(String type1,String brand1)
	{
		boolean exists = false;
		try {
			Connection con  = CP.createC();
			String query  = "SELECT * FROM products WHERE ptype=? AND pbrand=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, type1);
			pstmt.setString(2, brand1);
			
			ResultSet set = pstmt.executeQuery(query);

				while(set.next())
				{
					int id = set.getInt("pid");
					String name  = set.getString("pname");
					String type  = set.getString("pPlace");
					String brand = set.getString("pbrand");
					String place = set.getString("pPlace");
					String warranty = set.getString("pwarranty");
					String price = set.getString("pPlace");	
					
					System.out.println("Id: " + id);
					System.out.println("Name: " + name);
					System.out.println("Type: " + type);
					System.out.println("Brand: " + brand);
					System.out.println("Place: " + place);
					System.out.println("Warranty: " + warranty);
					System.out.println("Price: " + price);
					System.out.println("**************************");
					
				}
			con.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return exists;
	}
	//Retrieve a single Product 
	public static boolean aSingleProduct(int pid)
	{
		boolean flag = false;
		try {
			Connection con = CP.createC();
			String query  = "SELECT * FROM products WHERE pid=?";
			
			PreparedStatement pstmt  = con.prepareStatement(query);
			pstmt.setInt(1, pid);
			ResultSet set = pstmt.executeQuery();

			while(set.next())
			{
				int id = set.getInt("pid");
				String name  = set.getString("pname");
				String type  = set.getString("pPlace");
				String brand = set.getString("pbrand");
				String place = set.getString("pPlace");
				String warranty = set.getString("pwarranty");
				String price = set.getString("pPlace");	
				
				System.out.println("Id: " + id);
				System.out.println("Name: " + name);
				System.out.println("Type: " + type);
				System.out.println("Brand: " + brand);
				System.out.println("Place: " + place);
				System.out.println("Warranty: " + warranty);
				System.out.println("Price: " + price);
				System.out.println("**************************");
				
			}
		con.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
    //Get all the products for a Type
	public static boolean getProductByType(String ptype)
	{
		boolean flag = false;
		try {
			Connection con  = CP.createC();
			String query ="SELECT * FROM products WHERE ptype =?";
			
			Statement  stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(query);
			
			while(set.next())
			{
				int id = set.getInt("pid");
				String name  = set.getString("pname");
				String type  = set.getString("pPlace");
				String brand = set.getString("pbrand");
				String place = set.getString("pPlace");
				String warranty = set.getString("pwarranty");
				String price = set.getString("pPlace");	
				
				System.out.println("Id: " + id);
				System.out.println("Name: " + name);
				System.out.println("Type: " + type);
				System.out.println("Brand: " + brand);
				System.out.println("Place: " + place);
				System.out.println("Warranty: " + warranty);
				System.out.println("Price: " + price);
				System.out.println("**************************");
				
			}
		con.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
		
	}
	
}
