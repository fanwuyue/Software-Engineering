package top.womoe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.womoe.service.HrService;
import top.womoe.utils.Utils;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(allowCredentials = "true")
@RestController
@RequestMapping("hr")
public class HrController {

    @Autowired
    HrService hrService = null;

    @RequestMapping("login")
    public Object hrLogin(@RequestParam("username") String username, @RequestParam("password") String password){
        Map<Object, Object> res = new HashMap<>();
        res.put("status", "failed");
        if(hrService.verifyPassword(username, password)){
            String Token = Utils.getRandomString(17);
            if(hrService.updateToken(username, Token)){
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
        if(hrService.verifyLogin(username, token)){
            res.put("status", "success");
        }
        return res;
    }
}
