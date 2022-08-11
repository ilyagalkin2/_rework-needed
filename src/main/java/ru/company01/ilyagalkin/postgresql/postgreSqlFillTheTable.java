
package ru.company01.ilyagalkin.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class postgreSqlFillTheTable {

	private Connection connectAndFill() {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:8088/homies", "someuser", "somepass");
			System.out.println("Connection to postges:alpine image has been established.");
			conn.createStatement().executeQuery(
					"insert into homies (type, \"birthDate\", gender, name) values\n" +
							"('dog', 'we have found him', 'boy', 'Dogie'),\n" +
							"('husband', 'seems always have been here', 'man', 'Honey'),\n" +
							"('cat', 'lives here several years already', 'girl', 'Kitty'),\n" +
							"('cat', 'we have found him', 'boy', 'Qutie'),\n" +
							"('children', 'since the mess around or vice versa', 'man', 'Jack'),\n" +
							"('kinsfolk', 'along comes ...and drinks', 'man', 'GrandPa'),\n" +
							"('children', 'made him during that baby boom', 'woman', 'Mary');"
					);
			System.out.println("Table has been filled with values.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public static void main(String[] args) {
        postgreSqlFillTheTable createTableAndFill = new postgreSqlFillTheTable();
		createTableAndFill.connectAndFill();
	}

}
//docker run -p 1080:1080 -p 1025:1025 maildev/maildev
//docker run --name postgres -p 8088:5432 -e POSTGRES_PASSWORD=somepass -e POSTGRES_USER=someuser -e POSTGRES_DB=homies -d postgres:alpine