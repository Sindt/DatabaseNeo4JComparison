package cphbusiness.database.sp.neo4jcomparemysql.persistence;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.Timer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cphbusiness.database.sp.neo4jcomparemysql.entity.User;

public class MysqlServiceTest {

	private MysqlService service = new MysqlService("jdbc:mysql://localhost:3306/SocialNetwork", "root", "pwd",
			"com.mysql.jdbc.Driver");

	long millis;
	long result;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

		List<User> result = service.getAllUsers();

		assertThat(result.isEmpty(), is(false));

	}

	@Test
	public void testGetAllEndorsmentsByUser() {
		millis = System.currentTimeMillis();
		int result = service.getDepthOneByUser(45);
		System.out.println("Timer One Ended at:" + (System.currentTimeMillis() - millis));
		assertThat(result, is(24));

	}

	@Test
	public void testDepthTwoByUser() {

		millis = System.currentTimeMillis();
		int result = service.getDepthTwoByUser(45);
		System.out.println("Timer teo Ended at:" + (System.currentTimeMillis() - millis));
		assertThat(result, is(416));

	}

	@Test
	public void testDepthThreeByUser() {
		millis = System.currentTimeMillis();
		int result = service.getDepthThreeByUser(45);
		System.out.println("Timer three Ended at:" + (System.currentTimeMillis() - millis));
		assertThat(result, is(9625));

	}

	@Test
	public void testDepthFourByUser() {
		millis = System.currentTimeMillis();
		int result = service.getDepthFourByUser(45);
		System.out.println("Timer four Ended at:" + (System.currentTimeMillis() - millis));
		assertThat(result, is(177517));

	}
	@Test
	public void testDepthFiveByUser() {
		millis = System.currentTimeMillis();
		int result = service.getDepthFiveByUser(45);
		System.out.println("Timer five Ended at:" + (System.currentTimeMillis() - millis));
		assertThat(result, is(177517));
		
	}

}
