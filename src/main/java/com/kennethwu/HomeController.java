package com.kennethwu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		System.out.println("calling home method");

		// Test JDBC
		Connection myConn = null;
		try {
			String jdbcUrl = "jdbc:mysql://localhost:3306/kenneth_alien?useSSL=false&serverTimezone=UTC";

			String user = "kenken";

			String pass = "12345678";

			System.out.println("Connect to database: " + jdbcUrl + "...");

			myConn = DriverManager.getConnection(jdbcUrl, user, pass);

			System.out.println("Connection successful!!!");

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (myConn != null) {
				try {
					myConn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return "index";
	}

}
