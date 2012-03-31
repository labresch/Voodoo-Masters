package database;

import java.io.*;
import java.sql.*;

public class ScriptRunner {
	private static final String DEFAULT_DELIMITER = ";";
	private Connection connection;
	private String delimiter = DEFAULT_DELIMITER;

    public ScriptRunner(Connection conn) {
    	this.connection = conn;
    }

	public void run(Reader reader) throws IOException, SQLException {
		try {
			boolean originalAutoCommit = connection.getAutoCommit();
			try {
				connection.setAutoCommit(true);
				runScript(reader);
			} finally {
				connection.setAutoCommit(originalAutoCommit);
			}
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException("Error running script. Cause: " + e, e);
		}
	}

	private void runScript(Reader reader) throws IOException, SQLException {
		StringBuffer command = null;
		LineNumberReader lineReader = new LineNumberReader(reader);

		String line = null;
		try{
			while ((line = lineReader.readLine()) != null){
				if (command == null) {
					command = new StringBuffer();
				}

				String tLine = line.trim();
				while(!tLine.endsWith(getDelimiter())){
					if (tLine.startsWith("--")) {
						System.out.println(tLine);
					} else if (tLine.length() < 1
							|| tLine.startsWith("//")) {
					}else{
						command.append(tLine);
					}

					line = lineReader.readLine();
					tLine = line.trim();
				}
				command.append(tLine.substring(0,
					line.lastIndexOf(getDelimiter())));
				System.out.println("\n" + command);

				execute(command.toString());
				command = null;
			}
		}catch(IOException e){
			throw e;
		}catch(SQLException e){
			throw e;
		}finally{
			connection.rollback();
		}
	}

	private void execute(String comm) throws SQLException{
		Statement s = connection.createStatement();

		if(!comm.substring(0, 4).equals("drop")){
			try {
				s.executeUpdate(comm);
			}catch(SQLException e){
				throw e;
			}
		}else{
			try {
				s.executeUpdate(comm);
			}catch(SQLException e){
				// Ignore drop failures
			}
		}
		connection.commit();

		s.close();
		Thread.yield();
	}

	private String getDelimiter() {
		return delimiter;
	}
}