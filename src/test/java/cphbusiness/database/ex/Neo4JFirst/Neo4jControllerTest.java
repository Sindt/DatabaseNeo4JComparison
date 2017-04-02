package cphbusiness.database.ex.Neo4JFirst;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.neo4j.driver.v1.StatementResult;

public class Neo4jControllerTest {

	private Neo4jController neo4j;
	private List<Float> times = new ArrayList();
	private Random rand = new Random();

	@Before
	public void setup() {
		neo4j = new Neo4jController();
	}


	@Test
	public void getEndorsesDepthOneTest() {
		

		int sum = 0;

		for (int i = 0; i < 10; i++) {
			int id = rand.nextInt(500000);
			long startTime = System.currentTimeMillis();
			StatementResult result = neo4j.getEndorsesDepthOne(id);
			long endTime = System.currentTimeMillis();
			float estimatedTime = (endTime - startTime) / 1000.0f;
			times.add(estimatedTime);
			neo4j.close();
		}

		for (Float time : times) {
			System.out.println(time);
			sum += time;
		}
		System.out.println("Depth one Result= " + (sum / 10));

	}

	@Test
	public void getEndorsesDepthTwoTest() {

		int sum = 0;

		for (int i = 0; i < 10; i++) {
			int id = rand.nextInt(500000);
			long startTime = System.currentTimeMillis();
			StatementResult result = neo4j.getEndorsesDepthTwo(id);
			long endTime = System.currentTimeMillis();
			float tempEstimatedTime = (endTime - startTime) / 1000.0f;
			times.add(tempEstimatedTime);
			neo4j.close();
		}

		for (Float time : times) {
			System.out.println(time);
			sum += time;
		}
		System.out.println("Depth two Result= " + (sum / 10));

	}

	@Test
	public void getEndorsesDepthThreeTest() {

		int sum = 0;

		for (int i = 0; i < 10; i++) {
			int id = rand.nextInt(500000);
			long startTime = System.currentTimeMillis();
			neo4j.getEndorsesDepthThree(id);
			long endTime = System.currentTimeMillis();
			float tempEstimatedTime = (endTime - startTime) / 1000.0f;
			times.add(tempEstimatedTime);
			neo4j.close();
		}

		for (Float time : times) {
			System.out.println(time);
			sum += time;
		}
		System.out.println("Depth three Result= " + (sum / 10));

	}

	@Test
	public void getEndorsesDepthFourTest() {

		int sum = 0;

		for (int i = 0; i < 10; i++) {
			int id = rand.nextInt(500000);
			long startTime = System.currentTimeMillis();
			neo4j.getEndorsesDepthFour(id);
			long endTime = System.currentTimeMillis();
			float tempEstimatedTime = (endTime - startTime) / 1000.0f;
			times.add(tempEstimatedTime);
			neo4j.close();
		}

		for (Float time : times) {
			sum += time;
			System.out.println(time);
		}
		System.out.println("Depth four Result= " + (sum / 10));

	}

	@Test
	@Ignore
	public void getEndorsesDepthFiveTest() {

		int sum = 0;

		for (int i = 0; i < 10; i++) {
			int id = rand.nextInt(500000);
			long startTime = System.currentTimeMillis();
			neo4j.getEndorsesDepthFive(id);
			long endTime = System.currentTimeMillis();
			float tempEstimatedTime = (endTime - startTime) / 1000.0f;
			times.add(tempEstimatedTime);
			neo4j.close();
		}

		for (Float time : times) {
			sum += time;
			System.out.println(time);
		}
		System.out.println("Depth Five Result= " + (sum / 10));

	}

}
