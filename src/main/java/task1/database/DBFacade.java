package task1.database;

import java.sql.ResultSet;
import java.util.HashMap;

public class DBFacade {
    public HashMap<String, Object> create(String sql) {
        DB db = new DB(new ConnectionConfig());
        // TODO the example format of HashMap is { "message": "success", "data": resultSet}
        //  the reason why using Object here its for storing multiple type of class(polymorphism): e.g. String and ResultSet
        //  using casting for reading this data
        HashMap<String, Object> result = new HashMap<String, Object>();
        ResultSet resultSet = null;
        try {
            db.connect();
            resultSet = db.insert(sql);
            db.close();
            result.put("message", "request success");
            result.put("data", resultSet);
        } catch (Exception e){
            // TODO add log
            result.put("message", "request failed");
            result.put("data", resultSet);
        }
        return result;
    }

    public HashMap<String, Object> read(String sql) {
        DB db = new DB(new ConnectionConfig());
        HashMap<String, Object> result = new HashMap<String, Object>();
        ResultSet resultSet = null;
        try {
            db.connect();
            // TODO here is search() method
            resultSet = db.search(sql);
            db.close();
            result.put("message", "request success");
            result.put("data", resultSet);
        } catch (Exception e){
            // TODO add log
            result.put("message", "request failed");
            result.put("data", resultSet);
        }
        return result;
    }

    public  HashMap<String, Object> update(String sql) {
        DB db = new DB(new ConnectionConfig());
        HashMap<String, Object> result = new HashMap<String, Object>();
        boolean resultSet = false;
        try {
            db.connect();
            // TODO here is update() method
            resultSet = db.update(sql);
            db.close();
            result.put("message", "request success");
            result.put("data", resultSet);
        } catch (Exception e){
            // TODO add log
            result.put("message", "request failed");
            result.put("data", resultSet);
        }
        return result;
    }

    public HashMap<String, Object> delete(String sql) {
        DB db = new DB(new ConnectionConfig());
        HashMap<String, Object> result = new HashMap<String, Object>();
        boolean resultSet = false;
        try {
            db.connect();
            // TODO here is delete() method
            resultSet = db.delete(sql);
            db.close();
            result.put("message", "request success");
            result.put("data", resultSet);
        } catch (Exception e){
            // TODO add log
            result.put("message", "request failed");
            result.put("data", resultSet);
        }
        return result;
    }
}
