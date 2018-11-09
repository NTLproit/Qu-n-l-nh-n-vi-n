package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.NhanVien;

public class DB {
	private Connection con;
	// String dbUrl = "jdbc:oracle:thin:@172.16.19.184:1521:CDMS";
	// String dbClass="oracle.jdbc.OracleDriver";
	// String username = "mtts";
	// String password = "newpass";

	String dbName = "QuanLyNhanVien";
	String username = "sa";
	String password = "123456";
	String dbUrl = "jdbc:sqlserver://localhost:1433; " + "databaseName=" + dbName + "; username=" + username
			+ ";password=" + password;
	String dbClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	public DB() {
		try {
			Class.forName(dbClass);
			con = DriverManager.getConnection(dbUrl, username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public NhanVien checkUser(String username, String password) {
		String sql = "SELECT *FROM tblNhanVien WHERE username = ? AND password = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				NhanVien nv = new NhanVien();
				nv.setId(rs.getInt("id"));
				nv.setName(rs.getString("name"));
				nv.setAge(rs.getInt("age"));
				nv.setAddress(rs.getString("address"));
				nv.setPosition(rs.getString("position"));
				nv.setDescription(rs.getString("description"));
				nv.setUsername(rs.getString("username"));
				nv.setPassword(rs.getString("password"));
				nv.setType(rs.getInt("type"));
				return nv;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<NhanVien> listNV() {
		ArrayList<NhanVien> list = new ArrayList<>();
		String sql = "SELECT *FROM tblNhanVien";

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				NhanVien nv = new NhanVien();
				nv.setId(rs.getInt("id"));
				nv.setName(rs.getString("name"));
				nv.setAge(rs.getInt("age"));
				nv.setAddress(rs.getString("address"));
				nv.setPosition(rs.getString("position"));
				nv.setDescription(rs.getString("description"));
				nv.setUsername(rs.getString("username"));
				nv.setPassword(rs.getString("password"));
				nv.setType(rs.getInt("type"));
				list.add(nv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<NhanVien> searchNVByName(String ten) {
		ArrayList<NhanVien> list = new ArrayList<>();
		String sql = "SELECT *FROM tblNhanVien WHERE name like '%" + ten + "%'";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// ps.setString(1, ten);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				NhanVien nv = new NhanVien();
				nv.setId(rs.getInt("id"));
				nv.setName(rs.getString("name"));
				nv.setAge(rs.getInt("age"));
				nv.setAddress(rs.getString("address"));
				nv.setPosition(rs.getString("position"));
				nv.setDescription(rs.getString("description"));
				nv.setUsername(rs.getString("username"));
				nv.setPassword(rs.getString("password"));
				nv.setType(rs.getInt("type"));
				list.add(nv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public NhanVien searchNVById(int id) {
		NhanVien nv = new NhanVien();
		String sql = "SELECT *FROM tblNhanVien WHERE id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				nv.setId(rs.getInt("id"));
				nv.setName(rs.getString("name"));
				nv.setAge(rs.getInt("age"));
				nv.setAddress(rs.getString("address"));
				nv.setPosition(rs.getString("position"));
				nv.setDescription(rs.getString("description"));
				nv.setUsername(rs.getString("username"));
				nv.setPassword(rs.getString("password"));
				nv.setType(rs.getInt("type"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nv;
	}

	public boolean addNV(NhanVien nv) {
		String sql = "INSERT INTO tblNhanVien(name,age,address,position,description,username,password,type) VALUES(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nv.getName());
			ps.setInt(2, nv.getAge());
			ps.setString(3, nv.getAddress());
			ps.setString(4, nv.getPosition());
			ps.setString(5, nv.getDescription());
			ps.setString(6, nv.getUsername());
			ps.setString(7, nv.getPassword());
			ps.setInt(8, nv.getType());
			ps.executeUpdate();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean checkUsername(String username) {
		String sql = "SELECT * FROM tblNhanVien WHERE username like ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public boolean updateNV(NhanVien nv) {
		String sql = "UPDATE tblNhanVien SET name= ? , age = ?, address = ?, position = ? ,description = ?, username = ?, password = ?, type = ? WHERE id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nv.getName());
			ps.setInt(2, nv.getAge());
			ps.setString(3, nv.getAddress());
			ps.setString(4, nv.getPosition());
			ps.setString(5, nv.getDescription());
			ps.setString(6, nv.getUsername());
			ps.setString(7, nv.getPassword());
			ps.setInt(8, nv.getType());
			ps.setInt(9, nv.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public void deleteNVById(int id) {
		String sql = "DELETE FROM tblNhanVien WHERE id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
