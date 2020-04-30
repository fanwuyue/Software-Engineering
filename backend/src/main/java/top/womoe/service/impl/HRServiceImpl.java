package top.womoe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.womoe.mapper.HRMapper;
import top.womoe.model.HR;
import top.womoe.model.HRExample;
import top.womoe.service.HRService;

import java.util.List;

@Service
public class HRServiceImpl implements HRService {

    @Autowired
    private HRMapper hrMapper;

    public HR getHR(String username) {
        HRExample hrExample = new HRExample();
        hrExample.createCriteria().andHrUsernameEqualTo(username);
        List<HR> hrList = hrMapper.selectByExample(hrExample);
        if(hrList.size() != 1){
            return null;
        }
        return hrList.get(0);
    }

    public boolean verifyPassword(String username, String password){
        HRExample hrExample = new HRExample();
        hrExample.createCriteria().andHrUsernameEqualTo(username);
        List<HR> hrList = hrMapper.selectByExample(hrExample);
        if(hrList.size() != 0){
                return hrList.get(0).getHrPassword().equals(password);
        }
        return false;
    }

    public boolean verifyLogin(String username, String token) {
        return getHR(username).getHrToken().equals(token);
    }

    public boolean updateHR(HR hr) {
        return (1 == hrMapper.updateByPrimaryKey(hr));
    }

    public boolean updateToken(String username, String token) {
        HR hr = getHR(username);
        hr.setHrToken(token);
        return 1 == hrMapper.updateByPrimaryKey(hr);
    }
}
