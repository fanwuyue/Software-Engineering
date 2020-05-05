package top.womoe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.womoe.mapper.HrMapper;
import top.womoe.mapper.LogMapper;
import top.womoe.mapper.WorkerMapper;
import top.womoe.model.*;
import top.womoe.service.HrService;

import java.util.List;

@Service
public class HrServiceImpl implements HrService {

    @Autowired
    private HrMapper hrMapper;
    @Autowired
    private WorkerMapper workerMapper;
    @Autowired
    private LogMapper logMapper;

    public Hr getHr(String username) {
        HrExample hrExample = new HrExample();
        hrExample.createCriteria().andHrUsernameEqualTo(username);
        List<Hr> hrList = hrMapper.selectByExample(hrExample);
        if(hrList.size() != 1){
            return null;
        }
        return hrList.get(0);
    }

    public boolean verifyPassword(String username, String password){
        HrExample hrExample = new HrExample();
        hrExample.createCriteria().andHrUsernameEqualTo(username);
        List<Hr> hrList = hrMapper.selectByExample(hrExample);
        if(hrList.size() != 0){
                return hrList.get(0).getHrPassword().equals(password);
        }
        return false;
    }

    public boolean verifyLogin(String username, String token) {
        return getHr(username).getHrToken().equals(token);
    }

    public boolean updateToken(String username, String token) {
        Hr hr = getHr(username);
        hr.setHrToken(token);
        return 1 == hrMapper.updateByPrimaryKey(hr);
    }

    public boolean addWorker(Worker worker) {
        if(getWorker(0, worker.getWksNumber()).size() == 0)
            return workerMapper.insert(worker) > 0;
        return false;
    }

    // 1 成功 2 失败 3 无此用户
    public int deleteWorker(int type, String key) {
        List<Worker> workers = getWorker(type, key);
        for(Worker worker : workers){
            workerMapper.deleteByPrimaryKey(worker.getId());
        }
        return workers.size() > 0 ? 1:3;
    }

    // 1 成功 2 失败 3 存在此编号
    public int updateWorker(Worker worker) {
        List<Worker> workers = getWorker(0, worker.getWksNumber());
        if(workers.size() == 0){
            return workerMapper.updateByPrimaryKey(worker) > 0 ? 1:2;
        }
        if(workers.get(0).getId().equals(worker.getId())) {
            return workerMapper.updateByPrimaryKey(worker) > 0 ? 1:2;
        }
        return 3;
    }

    public List<Worker> getWorkers() {
        return workerMapper.selectByExample(new WorkerExample());
    }

    public boolean deleteAll() {
        return workerMapper.deleteByExample(new WorkerExample()) >= 0;
    }

    public List<Worker> getWorker(int type, String key) {
        WorkerExample workerExample = new WorkerExample();
        if(type == 0){
            workerExample.createCriteria().andWksNumberEqualTo(key);
        }
        else if(type == 1){
            workerExample.createCriteria().andWksNameEqualTo(key);
        } else {
            return null;
        }
        return workerMapper.selectByExample(workerExample);
    }

    @Override
    public Worker getWorker(int id) {
        return workerMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean addLog(Log log) {
        return logMapper.insert(log) > 0;
    }
}
