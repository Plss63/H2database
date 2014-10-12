package h2;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionSource {
    
    public Connection getConnection() throws SQLException; 
    
}
