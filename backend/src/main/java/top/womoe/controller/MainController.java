package top.womoe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.womoe.service.AdminService;
import top.womoe.utils.Utils;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class MainController {
    @Autowired
    AdminService adminService = null;

    @RequestMapping("/adminLogin")
    public Object adminLogin(@RequestParam("username") String username, @RequestParam("password") String password){
        Map<Object, Object> res = new HashMap<>();
        res.put("status", "failed");
        if(adminService.verifyAdmin(username, password)){
            String Token = Utils.getRandomString(17);
            if(adminService.updateToken(username, Token)){
                res.put("status", "success");
                res.put("token", Token);
            }
        }
        return res;
    }
}
