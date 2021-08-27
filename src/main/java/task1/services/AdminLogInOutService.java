package task1.services;

import task1.dao.Admin;
import task1.dao.AdminDao;

public class AdminLogInOutService {
    // TODO mockup session
    public static Admin CurrentUser;
    private AdminDao adminDao;

    public void Login(String email, String password){
        CurrentUser = adminDao.findAdmin(email, password);
    }

    public void Logout() {
        CurrentUser = null;
    }
}
