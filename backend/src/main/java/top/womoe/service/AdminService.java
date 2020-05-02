package top.womoe.service;

import org.springframework.stereotype.Service;
import top.womoe.model.Admin;
import top.womoe.model.Hr;

@Service
public interface AdminService {
    Admin getAdmin(String username);
    boolean addHr(Hr hr);
    boolean verifyPassword(String username, String password);
    boolean verifyLogin(String username, String token);
    boolean updateAdmin(Admin admin);
    boolean updateToken(String username, String Token);
}
