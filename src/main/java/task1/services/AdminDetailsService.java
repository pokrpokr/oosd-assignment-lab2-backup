package task1.services;

import task1.dao.Admin;
import task1.dao.AdminDao;

public class AdminDetailsService {
    // TODO mockup session
    public static Admin CurrentUser;
    private AdminDao adminDao;

    public boolean ChangePassword(String password){
        if(CurrentUser == null) return false;
        return adminDao.updatePassword(CurrentUser, password);
    }
}
