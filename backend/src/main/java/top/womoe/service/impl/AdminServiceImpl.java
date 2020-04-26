package top.womoe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.womoe.mapper.AdminMapper;
import top.womoe.model.Admin;
import top.womoe.model.AdminExample;
import top.womoe.service.AdminService;

import javax.swing.text.StringContent;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public Admin getAdmin(int id){
        return adminMapper.selectByPrimaryKey(id);
    }
    public boolean verifyAdmin(String username, String password){
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andAdminUsernameEqualTo(username);
        List<Admin> adminList = adminMapper.selectByExample(adminExample);
        if(adminList.size() != 0){
                return adminList.get(0).getAdminPassword().equals(password);
        }
        return false;
    }
}
