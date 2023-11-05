package co.com.brayanscompany.appanalizatest.factory;


// These import statements are used to import necessary classes and interfaces from different packages
// in Java.
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @version 1.0
 * @author BRAYAN
 */
/**
 * The ConnectionFactory class provides a method to retrieve a connection to a
 * MySQL database using a
 * ComboPooledDataSource.
 */
public class ConnectionFactory {

    // The line `private DataSource dataSource;` declares a private instance
    // variable named
    // `dataSource` of type `DataSource`. This variable is used to store a reference
    // to a data source
    // object that provides connections to a database.
    private final DataSource dataSource;

    // The `public ConnectionFactory()` method is a constructor for the
    // `ConnectionFactory` class.
    public ConnectionFactory() {
        var comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/appanalizatest?useTimeZone=true&serverTimeZone=UTC");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("Bm010803");

        this.dataSource = comboPooledDataSource;
    }

    /**
     * The function recuperaConexion() returns a Connection object by getting a
     * connection from a
     * dataSource.
     * 
     * @return The method is returning a Connection object.
     */
    public Connection recuperaConexion() {
        try {
            return this.dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
