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
    public Object verifyLogin( @CookieValue(name = "username", required = false) String username, @CookieValue(name = "token", required = false) String token){
        Map<Object, Object> res = new HashMap<>();
        res.put("status", "failed");
        if(adminService.verifyLogin(username, token)){
            res.put("status", "success");
        }
        return res;
    }

    @RequestMapping(path="/addHr", method = RequestMethod.POST)
    public Object addHr( @CookieValue(name = "username", required = false) String username, @CookieValue(name = "token", required = false) String token, @RequestBody String body){
        Map<Object, Object> res = new HashMap<>();
        res.put("status", "failed");
        JSONObject jsonObject;
        System.out.println(body);
        try {
            jsonObject = JSON.parseObject(body);
        } catch (JSONException je){
            res.put("reason", "errorBody");
            return res;
        }
        /*if(!adminService.verifyLogin(username, token)){
            res.put("reason", "notLogged");
            return res;
        }*/
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

    @RequestMapping(path="/deleteHr", method = RequestMethod.GET)
    public Object deleteHr( @CookieValue(name = "username", required = false) String username, @CookieValue(name = "token", required = false) String token,
                        @RequestParam("type") Integer type, @RequestParam("key") String key){
        Map<Object, Object> res = new HashMap<>();
        res.put("status", "failed");
        /*
        if(!adminService.verifyLogin(username, token)){
            res.put("reason", "notLogged");
            return res;
        }
        */
        if(adminService.deleteHr(type, key) == 1)
            res.put("status", "success");
        else if (adminService.deleteHr(type, key) == 2)
            res.put("reason", "deleteError");
        else
            res.put("reason", "noSuchHr");
        return res;

    }

    @RequestMapping(path="/getHr", method = RequestMethod.GET)
    public Object getHr( @CookieValue(name = "username", required = false) String username, @CookieValue(name = "token", required = false) String token,
                        @RequestParam("type") Integer type, @RequestParam("key") String key){
        Map<Object, Object> res = new HashMap<>();
        res.put("status", "failed");
        /*
        if(!adminService.verifyLogin(username, token)){
            res.put("reason", "notLogged");
            return res;
        }
        */
        Hr hr = adminService.getHr(type, key);
        if(hr != null)
        {
            res.put("status", "success");
            res.put("hr", hr);
        }
        else
            res.put("reason", "noSuchHr");
        return res;
    }

    @RequestMapping(path="/getHrs", method = RequestMethod.GET)
    public Object getHrs( @CookieValue(name = "username", required = false) String username, @CookieValue(name = "token", required = false) String token){
        Map<Object, Object> res = new HashMap<>();
        res.put("status", "failed");
        /*
        if(!adminService.verifyLogin(username, token)){
            res.put("reason", "notLogged");
            return res;
        }
        */
        res.put("hrs", adminService.getHrs());
        res.put("status", "success");
        return res;
    }

    @RequestMapping(path="/deleteAll", method = RequestMethod.GET)
    public Object deleteAll( @CookieValue(name = "username", required = false) String username, @CookieValue(name = "token", required = false) String token){
        Map<Object, Object> res = new HashMap<>();
        res.put("status", "failed");
        /*
        if(!adminService.verifyLogin(username, token)){
            res.put("reason", "notLogged");
            return res;
        }
        */
        if(adminService.deleteAll())
            res.put("status", "success");
        return res;
    }

    @RequestMapping(path="/updateHr", method = RequestMethod.POST)
    public Object updateHr( @CookieValue(name = "username", required = false) String username, @CookieValue(name = "token", required = false) String token, @RequestBody String body){
        Map<Object, Object> res = new HashMap<>();
        res.put("status", "failed");
        JSONObject jsonObject;
        try {
            jsonObject = JSON.parseObject(body);
        } catch (JSONException je){
            res.put("reason", "errorBody");
            return res;
        }
        /*
        if(!adminService.verifyLogin(username, token)){
            res.put("reason", "notLogged");
            return res;
        }
        */
        Hr hr = new Hr();
        hr.setId(jsonObject.getIntValue("uid"));
        hr.setHrName(jsonObject.getString("name"));
        hr.setHrNumber(jsonObject.getString("number"));
        hr.setHrPassword(jsonObject.getString("password"));
        hr.setHrSeniority(jsonObject.getInteger("seniority"));
        hr.setHrSex(jsonObject.getString("sex"));
        hr.setHrUsername(jsonObject.getString("username"));
        hr.setHrTelephone(jsonObject.getString("telephone"));
        if(adminService.updateHr(hr) == 1)
            res.put("status", "success");
        else if(adminService.updateHr(hr) == 2)
            res.put("reason", "updateError");
        else
            res.put("reason", "numberAlreadyExists");
        return res;
    }

    @RequestMapping(path="/getLogs", method = RequestMethod.GET)
    public Object getLogs( @CookieValue(name = "username", required = false) String username, @CookieValue(name = "token", required = false) String token){
        Map<Object, Object> res = new HashMap<>();
        res.put("status", "failed");
        /*
        if(!adminService.verifyLogin(username, token)){
            res.put("reason", "notLogged");
            return res;
        }
        */
        res.put("status", "success");
        res.put("logs", adminService.getLogs());
        return res;
    }

}
