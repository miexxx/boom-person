import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Database {
	public boolean checkuser(String a, String b) {
		// TODO Auto-generated method stub
		// ����������
		String driver = "com.mysql.jdbc.Driver";
		// URLָ��Ҫ���ʵ����ݿ���
		String url = "jdbc:mysql://127.0.0.1:3306/ch10";
		// ����mysql�л���
		String user = "root";
		String password = "root";
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			if (!conn.isClosed()) {
				System.out.println("�ɹ��������ݿ�");
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
