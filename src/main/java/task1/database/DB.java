package task1.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    private Connection con = null;
    private Statement stmt = null;
    private ConnectionConfig config = null;

    public DB(ConnectionConfig config) {
        this.config = config;
    }

    public void connect() throws SQLException, ClassNotFoundException {
        this.con = config.getConnection();
        this.stmt = con.createStatement();
    }

    public void close() throws SQLException {
        this.con.close();
    }

    public ResultSet insert(String sql) throws Exception {
        // TODO Using JDBC transaction to roll back data when exception is raised
        // TODO The code here is just for an example
        ResultSet resultSet = null;
        try
        {
            con.setAutoCommit(false);
            int result = stmt.executeUpdate(sql);
            con.commit();
            if (result == 0){
                // TODO throw an exception
            }
            // TODO this is for aftering insert into the database return ID from database and updating Employee Object
            resultSet = stmt.executeQuery("CALL IDENTITY();");
        } catch (SQLException se) {
            if (con != null){
                con.rollback();
            }
            throw se;
        } catch (Exception e){
            // TODO custom other exceptions here
        }
        return resultSet;
    }

    public  ResultSet search(String sql ) throws SQLException {
        // TODO Logic quite same with insert() method except this is a select sql, without transaction
        ResultSet resultSet = null;
        return resultSet;
    }

    public boolean update(String sql) throws Exception {
        // TODO Using transaction here (Memento Pattern)
        // TODO The code here is just for an example
        int result = 0;
        try
        {
            con.setAutoCommit(false);
            result = stmt.executeUpdate(sql);
            con.commit();
        } catch (Exception e){
            con.rollback();
            return false;
        }

        if (result <= 0){
            return false;
        } else {
            return true;
        }
    }

    public boolean delete(String sql) throws SQLException {
        // TODO Logic quite same with update() method
        return true;
    }
}
