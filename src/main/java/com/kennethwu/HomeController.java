package com.kennethwu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(ModelMap model) {

		// Test JDBC
		Connection myConn = null;
		try {
			String jdbcUrl = "jdbc:mysql://localhost:3306/kenneth_alien?useSSL=false&serverTimezone=UTC";

			String dbUser = "kenken";

			String dbPass = "12345678";

			myConn = DriverManager.getConnection(jdbcUrl, dbUser, dbPass);

			model.addAttribute("jdbcUrl", jdbcUrl);

			model.addAttribute("dbUser", dbUser);

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
