package top.womoe.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.womoe.model.Hr;
import top.womoe.service.AdminService;
import top.womoe.utils.Utils;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(allowCredentials = "true")
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

    @RequestMapping(path="/addHr", method = RequestMethod.POST)
    public Object addHr(@CookieValue("username") String username, @CookieValue("token") String token, @RequestBody String body){
        Map<Object, Object> res = new HashMap<>();
        res.put("status", "failed");
        JSONObject jsonObject;
        try {
            jsonObject = JSON.parseObject(body);
        } catch (JSONException je){
            res.put("reason", "errorBody");
            return res;
        }
        if(!adminService.verifyLogin(username, token)){
            res.put("reason", "notLogged");
            return res;
        }
        Hr hr = new Hr();
        hr.setHrName(jsonObject.getString("name"));
        hr.setHrNumber(jsonObject.getString("number"));
        hr.setHrPassword(jsonObject.getString("password"));
        hr.setHrSeniority(jsonObject.getInteger("seniority"));
        hr.setHrSex(jsonObject.getString("sex"));
        hr.setHrUsername(jsonObject.getString("username"));
        hr.setHrTelephone(jsonObject.getString("telephone"));
        if(adminService.addHr(hr))
            res.put("status", "success");
        else
            res.put("reason", "insertError");
        return res;

    }
}
