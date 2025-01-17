package com.hcl.bank;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class AccountsTestCase {
	@Test
	public void testWithDrawAccount(){
		assertEquals("amount debited",
				AccountBAL.withdrawAccountBal(3,3000));
		assertEquals("insufficient funds",
				AccountBAL.withdrawAccountBal(3,300000000));
		assertEquals("account not found....",
				AccountBAL.withdrawAccountBal(-3,3000));
		assertEquals("account closed...",
				AccountBAL.withdrawAccountBal(1,3000));
	}
	@Test
	public void testDepositAccount(){
		assertEquals("amount added.....",
				AccountBAL.depositaccountBal(3, 3000));
		assertEquals("account notfound.....",
				AccountBAL.depositaccountBal(-3, 3000));
		assertEquals("Account closed..",
				AccountBAL.depositaccountBal(1, 3000));

	}
	@Test
	public void testCloseAccount(){
		assertEquals("account closed...",
				AccountBAL.closeAccountBal(4));
		assertEquals("account no not found...",
				AccountBAL.closeAccountBal(-4));
	}
	@Test
	public void testUpdateaccount(){
		assertEquals("account updated",
				AccountBAL.updateAccountBal(2,"Chennai","TN"));
		assertEquals("account not found",
				AccountBAL.updateAccountBal(-2,"Chennai","TN"));
		assertEquals("account closed already",
				AccountBAL.updateAccountBal(1,"chennai","TN"));

	}
	@Test
	public void testSearchAccount(){
		assertNotNull(AccountBAL.searchAccountBal(1));
		assertNull(AccountBAL.searchAccountBal(-1));
	}
	@Test
	public void testCreateAccount(){
		Accounts objAccounts=new Accounts();
		int accno=AccountBAL.generateAccountBal();
		objAccounts.setAccountNo(accno);
		objAccounts.setFirstName("Bindhu");
		objAccounts.setLastName("Sree");
		objAccounts.setCity("Banglore");
		objAccounts.setState("KA");
		objAccounts.setAmount(99222);
		objAccounts.setCheqFacil("Yes");
		objAccounts.setAccountType("Savings");
		assertEquals("Account created sucessfully...",
				AccountBAL.createAccountBal(objAccounts));
	}
	@Test
	public void testDaoConnection(){
		assertNotNull(DaoConnection.getConnection());
	}
	@Test
	public void testGenerateAccountNo(){
		int accno=0;
		Connection con=DaoConnection.getConnection();
		String cmd="select max(accountNo)+1 accno from Accounts";
		try {
			PreparedStatement pst=con.prepareStatement(cmd);
			ResultSet rs=pst.executeQuery();
			rs.next();
			accno=rs.getInt("accno");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(accno,AccountBAL.generateAccountBal());
	}

	@Test
	public void testGettersAndSetters() {
		Accounts objAccounts=new Accounts();
		objAccounts.setAccountNo(1);
		objAccounts.setFirstName("Sai");
		objAccounts.setLastName("Krishna");
		objAccounts.setCity("Banglore");
		objAccounts.setState("KA");
		objAccounts.setAmount(88222);
		objAccounts.setCheqFacil("Yes");
		objAccounts.setAccountType("Savings");
		objAccounts.setStatus("active");
		
		assertEquals(1,objAccounts.getAccountNo());
		assertEquals("Sai",objAccounts.getFirstName());
		assertEquals("Krishna",objAccounts.getLastName());
		assertEquals("Banglore",objAccounts.getCity());
		assertEquals("KA",objAccounts.getState());
		assertEquals(88222,objAccounts.getAmount());
		assertEquals("Yes",objAccounts.getCheqFacil());
		assertEquals("Savings",objAccounts.getAccountType());
		assertEquals("active",objAccounts.getStatus());

}
}