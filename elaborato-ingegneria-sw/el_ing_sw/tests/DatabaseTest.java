package tests;


import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import elaborato.DB.Database;

class DatabaseTest {
	
	@Test
	void testConnection() {
		try {
			Connection c = Database.getDatabase().getConnection();
			throw new Exception("AA");
		}catch(Exception e) {
			fail(e);
		}
	}

}
