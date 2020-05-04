package top.womoe.service.impl;

import com.mysql.jdbc.exceptions.MySQLDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.NestedServletException;
import top.womoe.mapper.AdminMapper;
import top.womoe.mapper.HrMapper;
import top.womoe.model.Admin;
import top.womoe.model.AdminExample;
import top.womoe.model.Hr;
import top.womoe.model.HrExample;
import top.womoe.service.AdminService;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private HrMapper hrMapper;

    public Admin getAdmin(String username) {
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andAdminUsernameEqualTo(username);
        List<Admin> adminList = adminMapper.selectByExample(adminExample);
        if(adminList.size() != 1){
            return null;
        }
        return adminList.get(0);
    }

    public boolean verifyPassword(String username, String password){
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andAdminUsernameEqualTo(username);
        List<Admin> adminList = adminMapper.selectByExample(adminExample);
        if(adminList.size() != 0){
                return adminList.get(0).getAdminPassword().equals(password);
        }
        return false;
    }

    public boolean verifyLogin(String username, String token) {
        return getAdmin(username).getAdminToken().equals(token);
    }

    public boolean updateAdmin(Admin admin) {
        return (1 == adminMapper.updateByPrimaryKey(admin));
    }

    public boolean updateToken(String username, String token) {
        Admin admin = getAdmin(username);
        admin.setAdminToken(token);
        return 1 == adminMapper.updateByPrimaryKey(admin);
    }

    public boolean addHr(Hr hr) {
        HrExample hrExample = new HrExample();
        hrExample.createCriteria().andHrUsernameEqualTo(hr.getHrUsername());
        if(hrMapper.selectByExample(hrExample).size() != 0)
            return false;
        if(getHr(0, hr.getHrNumber()) == null)
            return hrMapper.insert(hr) > 0;
        return false;
    }

    // 1 成功 2 失败 3 无此用户
    public int deleteHr(int type, String key) {
        Hr hr = getHr(type, key);
        if(hr != null){
            return hrMapper.deleteByPrimaryKey(hr.getId()) > 0? 1:2;
        }
        return 3;
    }

    // 1 成功 2 失败 3 存在此编号
    public int updateHr(Hr hr) {
        Hr newHr = getHr(0, hr.getHrNumber());
        if(newHr == null){
            return hrMapper.updateByPrimaryKey(hr) > 0 ? 1:2;
        }
        if(newHr.getId().equals(hr.getId())) {
            return hrMapper.updateByPrimaryKey(hr) > 0 ? 1:2;
        }
        return 3;
    }

    public List<Hr> getHrs() {
        List<Hr> hrs = hrMapper.selectByExample(new HrExample());
        for (Hr hr : hrs) {
            hr.setHrToken("");
        }
        return hrs;
    }

    public boolean deleteAll() {
        return hrMapper.deleteByExample(new HrExample()) >= 0;
    }

    public Hr getHr(int type, String key) {
        HrExample hrExample = new HrExample();
        if(type == 0){
            hrExample.createCriteria().andHrNumberEqualTo(key);
        }
        else if(type == 1){
            hrExample.createCriteria().andHrNameEqualTo(key);
        } else {
            return null;
        }
        List<Hr> hrs = hrMapper.selectByExample(hrExample);
        if(hrs.size() == 1){
            Hr hr = hrs.get(0);
            hr.setHrToken("");
            return hr;
        }
        return null;
    }
}
