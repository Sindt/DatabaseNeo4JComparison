package cphbusiness.database.sp.neo4jcomparemysql.persistence;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

public class Neo4jService {

	Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "class"));

	public int firstDepth(int id) {
		Session session = driver.session();
		String query = "MATCH(:Person{id:" + id + "})-[:ENDORSES]->(p:Person) RETURN count(distinct(p));";
		StatementResult result = session.run(query);
		int amount = 0;
		while (result.hasNext()) {
			Record record = result.next();
			amount = record.get("count(distinct(p))").asInt();
		}
		return amount;
	}

	public int secondDepth(int id) {
		Session session = driver.session();
		String query = "MATCH(:Person{id:" + id
				+ "})-[:ENDORSES]->(:Person)-[:ENDORSES]->(p:Person) RETURN count(distinct(p));";
		StatementResult result = session.run(query);
		int amount = 0;
		while (result.hasNext()) {
			Record record = result.next();
			amount = record.get("count(distinct(p))").asInt();
		}
		return amount;
	}

	public int thirdDepth(int id) {
		Session session = driver.session();
		String query = "MATCH(:Person{id:" + id
				+ "})-[:ENDORSES]->(:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(p:Person) RETURN count(distinct(p));";
		StatementResult result = session.run(query);
		int amount = 0;
		while (result.hasNext()) {
			Record record = result.next();
			amount = record.get("count(distinct(p))").asInt();
		}
		return amount;
	}

	public int fourthDepth(int id) {
		Session session = driver.session();
		String query = "MATCH(:Person{id:" + id
				+ "})-[:ENDORSES]->(:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(p:Person) RETURN count(distinct(p));";
		StatementResult result = session.run(query);
		int amount = 0;
		while (result.hasNext()) {
			Record record = result.next();
			amount = record.get("count(distinct(p))").asInt();
		}
		return amount;
	}

	public int fifthDepth(int id) {
		Session session = driver.session();
		String query = "MATCH(:Person{id:" + id
				+ "})-[:ENDORSES]->(:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(p:Person) RETURN count(distinct(p));";
		StatementResult result = session.run(query);
		int amount = 0;
		while (result.hasNext()) {
			Record record = result.next();
			amount = record.get("count(distinct(p))").asInt();
		}
		return amount;
	}

}
