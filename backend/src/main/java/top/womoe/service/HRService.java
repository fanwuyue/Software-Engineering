package top.womoe.service;

import org.springframework.stereotype.Service;
import top.womoe.model.HR;

@Service
public interface HRService {
    HR getHR(String username);
    boolean verifyPassword(String username, String password);
    boolean verifyLogin(String username, String token);
    boolean updateHR(HR hr);
    boolean updateToken(String username, String Token);
}
