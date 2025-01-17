package com.hcl.bank;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {
PreparedStatement pst;
Connection con;
public String withdrawAccountDao(int accountNo,int withdrawAmount){
	con=DaoConnection.getConnection();
	String result=" ";
	Accounts objAccounts=searchAccountDao(accountNo);
	if(objAccounts!=null){
		int amount=objAccounts.getAmount();
		String status=objAccounts.getStatus();
		if(status.equalsIgnoreCase("inactive"))
		{
			result="account closed...";
		}else {
		if(amount-withdrawAmount>=1000)
		{
			String cmd="update accounts set amount=amount-? where accountno=?";
			
			try {
				pst=con.prepareStatement(cmd);
				pst.setInt(1, withdrawAmount);
				pst.setInt(2, accountNo);
				pst.executeUpdate();
				cmd="insert into trans(accountno,transamount,transtype) values(?,?,?)";
				pst=con.prepareStatement(cmd);
				pst.setInt(1, accountNo);
				pst.setInt(2, withdrawAmount);
				pst.setString(3, "D");
				pst.executeUpdate();
				result="amount debited";
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result=e.getMessage();
			
			}
		}else
		{
			result="insufficient funds";
		}
		}
	}
	else{
		result="account not found....";
	}
	return result;
}
public String depositAccountDao(int accountNo,int depAmount){
	con=DaoConnection.getConnection();
	String result="";
	String cmd= "update accounts set amount=amount+? where accountno=?";
	Accounts objAccounts=searchAccountDao(accountNo);
	if(objAccounts==null)
	{
		result="account notfound.....";
	}else{
		String status=objAccounts.getStatus();
		if(status.equalsIgnoreCase("inactive")){
			result="Account closed..";
		}else{
	try {
		pst=con.prepareStatement(cmd);
		pst.setInt(1,depAmount);
		pst.setInt(2, accountNo);
		pst.executeUpdate();
		cmd="insert into trans(accountno,transamount,transtype) values(?,?,?)";
		pst=con.prepareStatement(cmd);
		pst.setInt(1,accountNo);
		pst.setInt(2, depAmount);
		
		pst.setString(3, "c");
		pst.executeUpdate();
		result="amount added.....";
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		result=e.getMessage();
	}
	}
	}
	return result;
}

public String closeAccountDao(int accountNo){
	con=DaoConnection.getConnection();
	String result="";
	Accounts objAccounts=searchAccountDao(accountNo);
	if(objAccounts==null){
		result="account no not found...";
	}else{
		
	String cmd="Update accounts set status='inactive' where accountno=?";
    try {
		pst=con.prepareStatement(cmd);
		pst.setInt(1, accountNo);
		pst.executeUpdate();
		result="account closed...";
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		result=e.getMessage();
	}
	}
    return result;

}

public String updateAccountDao(int accountNo,String city,String state)
{
	con=DaoConnection.getConnection();
	Accounts objAccounts=searchAccountDao(accountNo);
	String cmd="update accounts set city=?, state=? where accountno=? ";
	String result=" ";
	if(objAccounts==null){
		result="account not found";
	}else {
		String status=objAccounts.getStatus();
		if(status.equals("inactive")){
			result="account closed already";
		}
		else{
	try {
		pst=con.prepareStatement(cmd);
		pst.setString(1, city);
		pst.setString(2, state);
		pst.setInt(3, accountNo);
		pst.executeUpdate();
		result="account updated";
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		result=e.getMessage();
	}
	
		}
}
	return result;
}
public Accounts searchAccountDao(int accountNo){
	con=DaoConnection.getConnection();
	String cmd="select * from accounts where accountno=?";
	Accounts objAccounts=null;
	try {
		pst=con.prepareStatement(cmd);
		pst.setInt(1, accountNo);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			objAccounts=new Accounts();
			objAccounts.setFirstName(rs.getString("firstName"));
			objAccounts.setLastName(rs.getString("lastName"));
			objAccounts.setCity(rs.getString("city"));
			objAccounts.setState(rs.getString("state"));
			objAccounts.setAmount(rs.getInt("amount"));
			objAccounts.setCheqFacil(rs.getString("cheqfacil"));
			objAccounts.setAccountType(rs.getString("Accounttype"));
			objAccounts.setStatus(rs.getString("status"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return objAccounts;
}
public String createAccountDao(Accounts objAccounts){
	con=DaoConnection.getConnection();
	String cmd="Insert into Accounts(accountNo,FirstName,"
			+ "LastName,City,state,Amount,CheqFacil,AccountType)" 
+"values(?,?,?,?,?,?,?,?)";
	String result="";
	try {
		pst=con.prepareStatement(cmd);
		pst.setInt(1, objAccounts.getAccountNo());
		pst.setString(2, objAccounts.getFirstName());
		pst.setString(3, objAccounts.getLastName());
		pst.setString(4, objAccounts.getCity());
		pst.setString(5, objAccounts.getState());
		pst.setInt(6, objAccounts.getAmount());
		pst.setString(7, objAccounts.getCheqFacil());
		pst.setString(8, objAccounts.getAccountType());
		pst.executeUpdate();
		result="Account created sucessfully...";
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
}

public int generateAccountNoDao(){
con=DaoConnection.getConnection();
int accno=0;
String cmd="select case when max(accountNo) is null then 1 "
+ "else max(accountNo)+1 end accno from accounts";
try {
pst=con.prepareStatement(cmd);
ResultSet rs=pst.executeQuery();
rs.next();
accno=rs.getInt("accno");
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
return accno;
}



}

