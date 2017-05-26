package cphbusiness.database.sp.neo4jcomparemysql.persistence;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Neo4jServiceTest {

	private Neo4jService neo4j = new Neo4jService();

	long millis;
	long result;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllEndorsmentsByUser() {
		millis = System.currentTimeMillis();
		int result = neo4j.firstDepth(45);
		System.out.println("Timer One Ended at:" + (System.currentTimeMillis() - millis));
		assertThat(result, is(24));

	}

	@Test
	public void testDepthTwoByUser() {

		millis = System.currentTimeMillis();
		int result = neo4j.secondDepth(45);
		System.out.println("Timer teo Ended at:" + (System.currentTimeMillis() - millis));
		assertThat(result, is(416));

	}

	@Test
	public void testDepthThreeByUser() {
		millis = System.currentTimeMillis();
		int result = neo4j.thirdDepth(45);
		System.out.println("Timer three Ended at:" + (System.currentTimeMillis() - millis));
		assertThat(result, is(9625));

	}

	@Test
	public void testDepthFourByUser() {
		millis = System.currentTimeMillis();
		int result = neo4j.fourthDepth(45);
		System.out.println("Timer four Ended at:" + (System.currentTimeMillis() - millis));
		assertThat(result, is(177517));

	}

	@Test
	public void testDepthFiveByUser() {
		millis = System.currentTimeMillis();
		int result = neo4j.fifthDepth(45);
		System.out.println("Timer five Ended at:" + (System.currentTimeMillis() - millis));
		assertThat(result, is(177517));

	}

}
