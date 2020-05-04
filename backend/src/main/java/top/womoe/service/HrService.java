package top.womoe.service;

import org.springframework.stereotype.Service;
import top.womoe.model.Hr;
import top.womoe.model.Worker;

import java.util.List;

@Service
public interface HrService {
    Hr getHr(String username);
    boolean verifyPassword(String username, String password);
    boolean verifyLogin(String username, String token);
    boolean updateToken(String username, String Token);
    boolean addWorker(Worker worker);
    int deleteWorker(int type, String key);
    int updateWorker(Worker worker);
    List<Worker> getWorkers();
    boolean deleteAll();
    List<Worker> getWorker(int type, String key);
}
