package notification;

import java.sql.Connection;
import java.sql.DriverManager;

public class Notification {
	
	private static final String PG_DRIVER = "org.postgresql.Driver";
	private static final String DB_PASSWORD = "";
	private static final String DB_USERNAME = "postgres";
	private static final String URL = "jdbc:postgresql://51.254.216.116:5432/gonenpru";

	public static void start() throws Throwable {
		Connection connection;
		String listenTo[] = { "planemovements_notify" };
		try {
			Class.forName(PG_DRIVER);
			connection = DriverManager.getConnection(URL, DB_USERNAME, DB_PASSWORD);
			SocketIO cl = new SocketIO(connection, listenTo);
			(new Thread(cl)).start();
			SocketIO.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void stop() throws Throwable {
		SocketIO.stop();
	}

	public static void sendNotification(String receivingGroup, String message) {
		SocketIO.sendNotification(receivingGroup, message);
	}
}
