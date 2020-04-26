package top.womoe.service;

import org.springframework.stereotype.Service;
import top.womoe.model.Admin;

@Service
public interface AdminService {
    public Admin getAdmin(int id);
    public boolean verifyAdmin(String username, String password);
}
