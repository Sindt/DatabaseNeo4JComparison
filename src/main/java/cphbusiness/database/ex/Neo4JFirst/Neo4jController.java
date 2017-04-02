package cphbusiness.database.ex.Neo4JFirst;

import org.neo4j.driver.v1.*;

public class Neo4jController {

	private Driver driver;
	private Session session;

	private void init() {
		driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "class"));
		session = driver.session();

	}

	public StatementResult getEndorsesDepthOne(int id) {
		init();
		return session.run("MATCH (a:Person {id:" + id + "})-[r:ENDORSES*1]->(b:Person) RETURN r, a, b");
	}

	public StatementResult getEndorsesDepthTwo(int id) {
		init();
		return session.run("MATCH (a:Person {id:" + id + "})-[r:ENDORSES*1..2]->(b:Person) RETURN r, a, b");
	}

	public StatementResult getEndorsesDepthThree(int id) {
		init();
		return session.run("MATCH (a:Person {id:" + id + "})-[r:ENDORSES*1..3]->(b:Person) RETURN r, a, b");
	}

	public StatementResult getEndorsesDepthFour(int id) {
		init();
		return session.run("MATCH (a:Person {id: " + id + "})-[r:ENDORSES*1..4]->(b:Person) RETURN r, a, b");
	}

	public StatementResult getEndorsesDepthFive(int id) {
		init();
		return session.run("MATCH (a:Person {id: " + id + "})-[r:ENDORSES*1..5]->(b:Person) RETURN r, a, b");
	}

	public void close() {
		if (session != null) {
			session.close();
		}
	}
}
