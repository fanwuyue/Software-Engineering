package top.womoe.service;

import org.springframework.stereotype.Service;
import top.womoe.model.Admin;

@Service
public interface AdminService {
    Admin getAdmin(String username);
    boolean verifyAdmin(String username, String password);
    boolean updateAdmin(Admin admin);
    boolean updateToken(String username, String Token);
}
