package io.openshift.booster.java_rest_http_crud;

import java.net.URL;
import java.sql.DriverManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "io.openshift.booster.java_rest_http_crud")
public class BoosterApplication {

	public static void main(String[] args) throws Exception {
		URL url;
		String JDBC_URL;
		String DB_IP;
		String DB_PORT;
		String DB_NAME;
		try {
			DB_IP = System.getenv("DATABASE_IP");
			DB_PORT = System.getenv("DATABASE_PORT");
			DB_NAME = System.getenv("DATABASE_DBNAME");
			Class.forName("org.postgresql.Driver");
			JDBC_URL="jdbc:postgresql://"+DB_IP+":"+DB_PORT+"/"+DB_NAME;
			DriverManager.getConnection(JDBC_URL, System.getenv("DB_USER"),
					System.getenv("DB_PASSWORD"));
			// System.out.println("DB is available!!");
			url = BoosterApplication.class.getResource("/BOOT-INF/classes/db.properties");
		} catch (Exception e) {
			// System.out.printf("DB is no available!!: %s\n", e.getLocalizedMessage());
			url = BoosterApplication.class.getResource("/BOOT-INF/classes/no-db.properties");
		}

		System.setProperty("spring.config.location", url.toString());

		SpringApplication.run(BoosterApplication.class, args);
	}
}
