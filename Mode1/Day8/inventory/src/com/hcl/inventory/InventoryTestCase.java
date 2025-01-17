package com.hcl.inventory;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;



public class InventoryTestCase {
	PreparedStatement pst;
	Connection con;
	@Test
	public void testplaceorder(){
		assertEquals("order placed",
				InventoryBAL.orderInventoryBal("S003",1));
	//	assertEquals("quantity not available",
				//InventoryBAL.orderInventoryBal("S003", 8));
		//assertEquals("stockid not available",
			//	InventoryBAL.orderInventoryBal("S012", 2));
		
		
		
	}
	@Test
	public void testSearchAccount(){
		assertNotNull(InventoryBAL.searchInventory("S001"));
		assertNull(InventoryBAL.searchInventory("S400"));
	}
	@Test
	public void testCreateAccount(){
		Inventory objAccounts=new Inventory();
		String stid=InventoryBAL.generateStockId();
		objAccounts.setStockid(stid);
		objAccounts.setPrice(200);
		objAccounts.setQuantityAvail(4);
		objAccounts.setItemName("pen");
		assertEquals("created sucessfully",InventoryBAL.createInventory(objAccounts));
	}

	@Test
	public void testDaoConnection(){
		assertNotNull(DaoConnection.getConnection());
	}
	@Test
	public void testGeneratestockid(){
		con=DaoConnection.getConnection();
		String stockid;
		String stid="";
		String cmd="select max(stockid) sid from stock";
		try {
			pst=con.prepareStatement(cmd);
			ResultSet rs=pst.executeQuery();
			rs.next();
		
			stid=rs.getString("sid");
			int id=Integer.parseInt(stid.substring(1));
			id++;
			if(id>=1&&id<=9)
			{
				stid="S00"+id;
			}
			if(id>=10&&id<=99)
			{
				stid="S0"+id;
			}
			if(id>=100 &&id<=999)
			{
				stid="S"+id;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	assertEquals(stid,InventoryBAL.generateStockId());
		
	}
	
	@Test
	public void testGettersAndSetters(){
		Inventory objInventory=new Inventory();
		objInventory.setStockid("S00");
		objInventory.setPrice(200);
		objInventory.setQuantityAvail(4);
		objInventory.setItemName("pen");
		
		assertEquals("S00",objInventory.getStockid());
		assertEquals(200,objInventory.getPrice());
		assertEquals(4,objInventory.getQuantityAvail());
		assertEquals("pen",objInventory.getItemName());
	}
}

