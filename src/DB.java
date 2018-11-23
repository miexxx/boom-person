import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Database {
	public boolean checkuser(String a, String b) {
		// TODO Auto-generated method stub
		// 驱动程序名
		String driver = "com.mysql.jdbc.Driver";
		// URL指向要访问的数据库名
		String url = "jdbc:mysql://127.0.0.1:3306/ch10";
		// 配置mysql有户名
		String user = "root";
		String password = "root";
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			if (!conn.isClosed()) {
				System.out.println("成功连接数据库");
			}
			Statement statement = conn.createStatement();
			String sql = "select user,password from student_system";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				if (rs.getString("user").equals(a) && rs.getString("password").equals(b)) {
					return true;
				}
			}
			rs.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
