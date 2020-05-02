package top.womoe.service;

import org.springframework.stereotype.Service;
import top.womoe.model.Hr;

@Service
public interface HrService {
    Hr getHr(String username);
    boolean verifyPassword(String username, String password);
    boolean verifyLogin(String username, String token);
    boolean updateHr(Hr hr);
    boolean updateToken(String username, String Token);
}
