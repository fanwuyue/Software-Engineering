package top.womoe.service;

import org.springframework.stereotype.Service;
import top.womoe.model.Admin;
import top.womoe.model.Hr;

import java.util.List;

@Service
public interface AdminService {
    Admin getAdmin(String username);
    boolean verifyPassword(String username, String password);
    boolean verifyLogin(String username, String token);
    boolean updateToken(String username, String Token);
    boolean addHr(Hr hr);
    int deleteHr(int type, String key);
    int updateHr(Hr hr);
    List<Hr> getHrs();
    boolean deleteAll();
    Hr getHr(int type, String key);
}
