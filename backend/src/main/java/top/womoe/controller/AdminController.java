package top.womoe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.womoe.service.AdminService;
import top.womoe.utils.Utils;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminService adminService = null;

    @RequestMapping("login")
    public Object adminLogin(@RequestParam("username") String username, @RequestParam("password") String password){
        Map<Object, Object> res = new HashMap<>();
        res.put("status", "failed");
        if(adminService.verifyPassword(username, password)){
            String Token = Utils.getRandomString(17);
            if(adminService.updateToken(username, Token)){
                res.put("status", "success");
                res.put("token", Token);
            }
        }
        return res;
    }

    @RequestMapping("/verifyLogin")
    public Object verifyLogin(@CookieValue("username") String username, @CookieValue("token") String token){
        Map<Object, Object> res = new HashMap<>();
        res.put("status", "failed");
        if(adminService.verifyLogin(username, token)){
            res.put("status", "success");
        }
        return res;
    }
}
