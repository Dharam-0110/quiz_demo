package com.project.interfaces;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public interface DbConnection {
	public abstract Connection getConnection() throws SQLException, IOException;

}
