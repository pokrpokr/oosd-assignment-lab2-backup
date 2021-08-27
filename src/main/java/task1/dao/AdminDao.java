package task1.dao;

public interface AdminDao {
    Admin findAdmin(String email, String password);
    boolean updatePassword(Admin admin, String password);
}
