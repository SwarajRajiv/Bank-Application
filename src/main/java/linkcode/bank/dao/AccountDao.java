package linkcode.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import linkcode.bank.model.Account;
import linkcode.bank.model.Login;

public class AccountDao {

	Connection con = MyConnection.getConnection();
	
	public int savedata(Account accobj) {
		int i=0;
		try {
			PreparedStatement pstat= con.prepareStatement("insert into banklinkcode values (?,?,?,?,?)");
			pstat.setInt(1, accobj.getAccno());
			pstat.setString(2, accobj.getCname());
			pstat.setString(3, accobj.getUname());
			pstat.setString(4, accobj.getPass());
			pstat.setInt(5, accobj.getAccBall());
			i=pstat.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return i;
		
	}

	public boolean validateUser(Login logobj) {
		System.out.println("Enter username and password ");
		ResultSet rs=null;
		boolean b=false;
		con=MyConnection.getConnection();
			try {
				PreparedStatement pstat=con.prepareStatement("select * from banklinkcode where uname=? and pass=?");
				pstat.setString(1, logobj.getUname());
				pstat.setString(2, logobj.getPass());
				rs=pstat.executeQuery();
				if(rs.next()) {
					b=true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		return b;
	}
	public void DeleteData (int accno) {
		con=MyConnection.getConnection();
		int n=accno;
		try {
			PreparedStatement ps=con.prepareStatement("delete from banklinkcode where accno=?");
			ps.setInt(1, n);
			int i=ps.executeUpdate();
			if(i>0) {
				System.out.println("Record deleted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Account searchData(int accno) {
		int i=0;
		ResultSet rs = null;
		Account a=null;
		con=MyConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select * from banklinkcode where accno=?");
			ps.setInt(1, accno);
			rs=ps.executeQuery();
			if(i>0) {
				System.out.println("Record Found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(rs.next()) {
				a= new Account();
				a.setAccno(rs.getInt(1));
				a.setCname(rs.getString(2));
				a.setUname(rs.getString(3));
				a.setAccBall(rs.getInt(5));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
}
