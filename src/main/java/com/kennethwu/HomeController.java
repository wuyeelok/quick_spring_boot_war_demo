package com.kennethwu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	private final String jdbcUrl;
	private final String dbUser;
	private final String dbPass;

	public HomeController(@Value("${spring.datasource.url}") String jdbcUrl,
			@Value("${spring.datasource.username}") String dbUser,
			@Value("${spring.datasource.password}") String dbPass) {

		// Values are defined in application.properties

		this.jdbcUrl = jdbcUrl;
		this.dbUser = dbUser;
		this.dbPass = dbPass;
	}

	@GetMapping("/")
	public String home(ModelMap model) {

		// Test JDBC
		Connection myConn = null;
		try {

			myConn = DriverManager.getConnection(this.jdbcUrl, this.dbUser, this.dbPass);

			model.addAttribute("jdbcUrl", this.jdbcUrl);

			model.addAttribute("dbUser", this.dbUser);

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
