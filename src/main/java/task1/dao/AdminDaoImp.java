package task1.dao;

import task1.database.DBFacade;

import java.sql.ResultSet;
import java.util.HashMap;

public class AdminDaoImp implements AdminDao {

    public Admin findAdmin(String email, String password){
        // TODO Dummy code
        Admin admin = new Admin();
        String sql = "" + email + "" + password;
        // Facade pattern
        DBFacade db = new DBFacade();
        HashMap<String, Object> result = db.read(sql);
        if (result.get("message").equals("success")){
            try{
                ResultSet results = (ResultSet) result.get("data");
                while (results.next()){
                    admin = new Admin();
                    admin.setEmail(results.getString("email"));
                    admin.setPassword(results.getString("password"));
                    return admin;
                }
            }catch (Exception e){
                return admin;
            }
        }
        return admin;
    }

    public boolean updatePassword(Admin admin, String password){
        // TODO Dummy code
        String sql = "" + admin.getEmail()+ "" + password;
        DBFacade db = new DBFacade();
        HashMap<String, Object> result = db.update(sql);
        return (Boolean)result.get("data");
    }
}
