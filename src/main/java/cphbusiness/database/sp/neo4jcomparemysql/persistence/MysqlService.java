package cphbusiness.database.sp.neo4jcomparemysql.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cphbusiness.database.sp.neo4jcomparemysql.entity.User;

public class MysqlService {

	private String url;
	private String username;
	private String password;
	private String driver;

	public MysqlService(String url, String username, String password, String driver) {
		this.url = url;
		this.username = username;
		this.password = password;
		this.driver = driver;
	}

	public Connection getConnection() throws Exception {
		Class.forName(this.driver);
		return DriverManager.getConnection(this.url, this.username, this.password);
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement(getAllUsersPS());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				users.add(
						new User(rs.getInt("id"), rs.getString("name"), rs.getString("job"), rs.getString("birthday")));
			}

		} catch (Exception e) {
			return null;
		}
		return users;

	}

	public int getDepthOneByUser(int id) {
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement(getAllEndorsmentsByUserPS(id));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;

	}

	public int getDepthTwoByUser(int id) {
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement(getDepthTwoByUserPS(id));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;

	}

	public int getDepthThreeByUser(int id) {
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement(getDepthThreeByUserrPS(id));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;

	}

	public int getDepthFourByUser(int id) {
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement(getDepthFourByUserPS(id));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;

	}

	public int getDepthFiveByUser(int id) {
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement(getDepthFiveByUserPS(id));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;

	}

	private String getAllUsersPS() {
		return "SELECT * FROM nodes";
	}

	private String getAllEndorsmentsByUserPS(int id) {
		return "SELECT count(DISTINCT target_node_id) FROM edges JOIN nodes ON nodes.id = source_node_id "
				+ "WHERE source_node_id =" + id;
	}

	private String getDepthTwoByUserPS(int id) {
		return "SELECT count(DISTINCT target_node_id) FROM edges JOIN nodes ON nodes.id = source_node_id "
				+ "WHERE source_node_id IN (SELECT target_node_id FROM edges JOIN nodes ON nodes.id = source_node_id "
				+ "WHERE source_node_id =" + id + ")";
	}

	private String getDepthThreeByUserrPS(int id) {
		return "SELECT count(DISTINCT target_node_id) FROM edges JOIN nodes ON nodes.id = source_node_id "
				+ "WHERE source_node_id IN (SELECT target_node_id FROM edges JOIN nodes ON nodes.id = source_node_id "
				+ "WHERE source_node_id IN (SELECT target_node_id FROM edges JOIN nodes ON nodes.id = source_node_id "
				+ "WHERE source_node_id =" + id + "))";
	}

	private String getDepthFourByUserPS(int id) {
		return "SELECT count(DISTINCT target_node_id) FROM edges JOIN nodes ON nodes.id = source_node_id "
				+ "WHERE source_node_id IN (SELECT target_node_id FROM edges JOIN nodes ON nodes.id = source_node_id "
				+ "WHERE source_node_id IN (SELECT target_node_id FROM edges JOIN nodes ON nodes.id = source_node_id "
				+ "WHERE source_node_id IN (SELECT target_node_id FROM edges JOIN nodes ON nodes.id = source_node_id "
				+ "WHERE source_node_id =" + id + ")))";
	}

	private String getDepthFiveByUserPS(int id) {
		return "SELECT count(DISTINCT target_node_id) FROM edges JOIN nodes ON nodes.id = source_node_id "
				+ "WHERE source_node_id IN (SELECT target_node_id FROM edges JOIN nodes ON nodes.id = source_node_id "
				+ "WHERE source_node_id IN (SELECT target_node_id FROM edges JOIN nodes ON nodes.id = source_node_id "
				+ "WHERE source_node_id IN (SELECT target_node_id FROM edges JOIN nodes ON nodes.id = source_node_id "
				+ "WHERE source_node_id IN (SELECT target_node_id FROM edges JOIN nodes ON nodes.id = source_node_id "
				+ "WHERE source_node_id =" + id + "))))";
	}

}
