package com.product.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.data.database;

public class ProductJDBCDAO implements ProductInterface{
	
	private final String INSERT = 
			"INSERT INTO"
			+ "PRODUCTTYPE (P_ID, P_NAME, P_PRICE, P_DETAIL, PT_ID, P_COUNT, P_ADDDATE, P_STATUS, M_ID) "
			+ "VALUES ('P' || LPAD(PRODUCT_SEQ.NEXTVAL, 5, 0), ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String UPDATE = 
			"UPDATE PRODUCT SET P_NAME = ?, P_PRICE = ?, P_DETAIL = ?, PT_ID = ?, P_COUNT = ?, P_ADDDATE = ?, P_STATUS = ? WHERE P_ID = ?";
	private final String DELETE =
			"DELETE FORM PRODUCT WHERE P_ID = ?";
	private final String FINDBYPNAME =
			"SELECT * FORM PRODUCT WHERE P_ID = ?";
	private final String FINDBYPNAMETPYE =
			"SELECT * FORM PRODUCT WHERE P_ID = ?, PT_ID = ?";
	private final String FINDBYPSTATUS =
			"SELECT * FORM PRODUCT WHERE P_STATUS= ?";
	private final String GETALL =
			"SELECT * FORM PRODUCT";
	
	@Override
	public void insert(ProductVO product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ProductVO product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String p_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductVO> findByProductName(String p_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductVO> findByProductName(String p_name, String pt_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductVO> findByStatus(String p_status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductVO> getAll() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName(database.DRIVER);
			con = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD);
			ps = con.prepareStatement(GETALL);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	


}
