package top.womoe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.womoe.mapper.AdminMapper;
import top.womoe.model.Admin;
import top.womoe.model.AdminExample;
import top.womoe.service.AdminService;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

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
}
