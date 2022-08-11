
package ru.company01.ilyagalkin.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class postgreSqlCreateTable {

	private Connection connectAndCreate() {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:8088/homies", "someuser", "somepass");
			System.out.println("Connection to postges:alpine image has been established.");
			conn.createStatement().executeQuery(
					"create table IF NOT EXISTS homies (\n" +
					"    id INT generated always as identity,\n" +
                    "    type VARCHAR(20),\n" +
					"    \"birthDate\" VARCHAR(80) not null,\n" +
					"    gender VARCHAR(20),\n" +
                    "    name VARCHAR(100) not null,\n" +
					"    primary key (id)\n" +
					");");
			System.out.println("Table has been created.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public static void main(String[] args) {
        postgreSqlCreateTable createTable = new postgreSqlCreateTable();
		createTable.connectAndCreate();
	}

}
//docker run -p 1080:1080 -p 1025:1025 maildev/maildev
//docker run --name postgres -p 8088:5432 -e POSTGRES_PASSWORD=somepass -e POSTGRES_USER=someuser -e POSTGRES_DB=homies -d postgres:alpine