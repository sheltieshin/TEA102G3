package com.product.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
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
			"SELECT * FORM PRODUCT WHERE P_NAME = ?";
	private final String FINDBYPNAMETPYE =
			"SELECT * FORM PRODUCT WHERE P_NAME = ?, PT_ID = ?";
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
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName(database.DRIVER);
			con = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD);
			ps = con.prepareStatement(DELETE);
			
			ps.setString(1, p_id);
			
			ps.executeUpdate();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<ProductVO> findByProductName(String p_name) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductVO> list = new LinkedList<ProductVO>();
		
		try {
			Class.forName(database.DRIVER);
			con = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD);
			ps = con.prepareStatement(FINDBYPNAME);
			ps.setString(1, p_name);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ProductVO pVO = new ProductVO();
				pVO.setP_id(rs.getString("p_id"));
				pVO.setP_name(rs.getString("p_name"));
				pVO.setP_price(rs.getInt("p_price"));
				pVO.setP_detail(rs.getString("p_detail"));
				pVO.setPt_id(rs.getString("pt_id"));
				pVO.setP_count(rs.getInt("p_count"));
				pVO.setP_addDate(rs.getTimestamp("p_addDate"));
				pVO.setP_reviseDate(rs.getTimestamp("p_reviseDate"));
				pVO.setP_status(rs.getInt("p_status"));
				pVO.setM_id(rs.getString("m_id"));
				
				list.add(pVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ProductVO> findByProductName(String p_name, String pt_id) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductVO> list = new LinkedList<ProductVO>();
		
		try {
			Class.forName(database.DRIVER);
			con = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD);
			ps = con.prepareStatement(FINDBYPNAMETPYE);
			
			ps.setString(1, p_name);
			ps.setString(1, pt_id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ProductVO pVO = new ProductVO();
				pVO.setP_id(rs.getString("p_id"));
				pVO.setP_name(rs.getString("p_name"));
				pVO.setP_price(rs.getInt("p_price"));
				pVO.setP_detail(rs.getString("p_detail"));
				pVO.setPt_id(rs.getString("pt_id"));
				pVO.setP_count(rs.getInt("p_count"));
				pVO.setP_addDate(rs.getTimestamp("p_addDate"));
				pVO.setP_reviseDate(rs.getTimestamp("p_reviseDate"));
				pVO.setP_status(rs.getInt("p_status"));
				pVO.setM_id(rs.getString("m_id"));
				
				list.add(pVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ProductVO> findByStatus(Integer p_status) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductVO> list = new LinkedList<ProductVO>();
		
		try {
			Class.forName(database.DRIVER);
			con = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD);
			ps = con.prepareStatement(FINDBYPSTATUS);
			
			ps.setInt(1, p_status);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ProductVO pVO = new ProductVO();
				pVO.setP_id(rs.getString("p_id"));
				pVO.setP_name(rs.getString("p_name"));
				pVO.setP_price(rs.getInt("p_price"));
				pVO.setP_detail(rs.getString("p_detail"));
				pVO.setPt_id(rs.getString("pt_id"));
				pVO.setP_count(rs.getInt("p_count"));
				pVO.setP_addDate(rs.getTimestamp("p_addDate"));
				pVO.setP_reviseDate(rs.getTimestamp("p_reviseDate"));
				pVO.setP_status(rs.getInt("p_status"));
				pVO.setM_id(rs.getString("m_id"));
				
				list.add(pVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ProductVO> getAll() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductVO> list = new LinkedList<ProductVO>();
		
		try {
			Class.forName(database.DRIVER);
			con = DriverManager.getConnection(database.URL, database.USER, database.PASSWORD);
			ps = con.prepareStatement(GETALL);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ProductVO pVO = new ProductVO();
				pVO.setP_id(rs.getString("p_id"));
				pVO.setP_name(rs.getString("p_name"));
				pVO.setP_price(rs.getInt("p_price"));
				pVO.setP_detail(rs.getString("p_detail"));
				pVO.setPt_id(rs.getString("pt_id"));
				pVO.setP_count(rs.getInt("p_count"));
				pVO.setP_addDate(rs.getTimestamp("p_addDate"));
				pVO.setP_reviseDate(rs.getTimestamp("p_reviseDate"));
				pVO.setP_status(rs.getInt("p_status"));
				pVO.setM_id(rs.getString("m_id"));
				
				list.add(pVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	


}
