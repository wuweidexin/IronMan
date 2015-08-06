package conn;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class conn {
	private Context ctx = null;           
	private DataSource ds = null;
	private Connection conn = null;        
	private PreparedStatement stmt = null;   
	private ResultSet rs = null;

	// ****************��������**********************
	public conn() {
		try {
			
			ctx = new InitialContext();
		
			ds = (DataSource) ctx.lookup("java:/comp/env/sheji");  
		
			conn = ds.getConnection();
			
			System.out.println("���ݿ����ӳɹ�");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	// ********************��ѯ*********************
	public ResultSet query(String sql) {
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			return rs;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return rs;
	}
	// ******************���/�޸�/ɾ��*************************
	public int update(String sql) throws SQLException {
		try {
			stmt = conn.prepareStatement(sql);
			
			return stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	public void close() throws Exception{
		if(rs   != null) rs.close();
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
	}
	
	public static void main(String[] args){
	    conn connTest = new conn();
	    connTest.query("select * from student");
	}
}