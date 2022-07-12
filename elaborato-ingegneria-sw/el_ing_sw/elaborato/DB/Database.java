package elaborato.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

	private static Database instance = null;
	private Connection connection = null;

	private Database() {
		try {
			if (connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres",
						"postgres");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Connection getConnection() {
		return this.connection;
	}

	public static Database getDatabase() {
		if (instance == null) {
			instance = new Database();
		}

		return instance;
	}

}
