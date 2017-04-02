package cphbusiness.database.ex.Neo4JFirst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlController {

	Connection con = null;

	String url = "jdbc:mysql://localhost:3306/SocialNetwork";
	String user = "root";
	String password = "pwd";

	public ResultSet getEndorsesDepthOne(int id) {

		String query = "SELECT name FROM nodes WHERE nodes.id IN (select endorsed from t_endorsements where endorser = "
				+ id + ")";
		try {
			con = DriverManager.getConnection(url, user, password);
			return con.createStatement().executeQuery(query);

		} catch (SQLException ex) {
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
			}
		}
		return null;
	}

	public ResultSet getEndorsesDepthTwo(int id) {

		String query = "SELECT name FROM nodes WHERE nodes.id IN (select endorsed from endorser IN (SELECT endorsed from t_endorsements	where endorser = "
				+ id + ")";
		try {
			con = DriverManager.getConnection(url, user, password);
			return con.createStatement().executeQuery(query);

		} catch (SQLException ex) {
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
			}
		}
		return null;
	}

	public ResultSet getEndorsesDepthThree(int id) {

		String query = "SELECT name FROM nodes WHERE nodes.id IN (select endorsed from endorser IN (SELECT endorsed from t_endorsements	where IN (SELECT endorsed from t_endorsements	where endorser = "
				+ id + ")";
		try {
			con = DriverManager.getConnection(url, user, password);
			return con.createStatement().executeQuery(query);

		} catch (SQLException ex) {
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
			}
		}
		return null;
	}

	public ResultSet getEndorsesDepthFour(int id) {

		String query = "SELECT name FROM nodes WHERE nodes.id IN (select endorsed from endorser IN (SELECT endorsed from t_endorsements	where IN (SELECT endorsed from t_endorsements where IN (SELECT endorsed from t_endorsements where endorser = "
				+ id + ")";
		try {
			con = DriverManager.getConnection(url, user, password);
			return con.createStatement().executeQuery(query);

		} catch (SQLException ex) {
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
			}
		}
		return null;
	}

	public ResultSet getEndorsesDepthFive(int id) {

		String query = "SELECT name FROM nodes WHERE nodes.id IN (select endorsed from t_endorsements where endorser = "
				+ id + ")";
		try {
			con = DriverManager.getConnection(url, user, password);
			return con.createStatement().executeQuery(query);

		} catch (SQLException ex) {
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
			}
		}
		return null;
	}

}
