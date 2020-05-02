package top.womoe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.womoe.mapper.HrMapper;
import top.womoe.model.Hr;
import top.womoe.model.HrExample;
import top.womoe.service.HrService;

import java.util.List;

@Service
public class HrServiceImpl implements HrService {

    @Autowired
    private HrMapper hrMapper;

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

    public boolean updateHr(Hr hr) {
        return (1 == hrMapper.updateByPrimaryKey(hr));
    }

    public boolean updateToken(String username, String token) {
        Hr hr = getHr(username);
        hr.setHrToken(token);
        return 1 == hrMapper.updateByPrimaryKey(hr);
    }
}
