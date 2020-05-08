package top.womoe.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.womoe.model.Hr;
import top.womoe.model.Log;
import top.womoe.model.Worker;
import top.womoe.service.HrService;
import top.womoe.utils.Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(allowCredentials = "true")
@RestController
@RequestMapping("hr")
public class HrController {

    boolean ifLog = false;
    DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm");

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
    public Object verifyLogin( @CookieValue(name = "username", required = false) String username, @CookieValue(name = "token", required = false) String token){
        Map<Object, Object> res = new HashMap<>();
        res.put("status", "failed");
/*        if(hrService.verifyLogin(username, token)){
            res.put("status", "success");
        }*/
        return res;
    }

    @RequestMapping(path="/addWorker", method = RequestMethod.POST)
    public Object addWorker( @CookieValue(name = "username", required = false) String username, @CookieValue(name = "token", required = false) String token, @RequestBody String body){
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
        /*
        if(!hrService.verifyLogin(username, token)){
            res.put("reason", "notLogged");
            return res;
        }
        */
        Worker worker = new Worker();
        worker.setWksName(jsonObject.getString("name"));
        worker.setWksAddress(jsonObject.getString("address"));
        worker.setWksBirthdate(jsonObject.getDate("birthDate"));
        worker.setWksNumber(jsonObject.getString("number"));
        worker.setWksBasesalary(jsonObject.getInteger("baseSalary"));
        worker.setWksHometown(jsonObject.getString("hometown"));
        worker.setWksSeniority(jsonObject.getInteger("seniority"));
        worker.setWksSex(jsonObject.getString("sex"));
        worker.setWksTelephone(jsonObject.getString("telephone"));
        worker.setWksEdu(jsonObject.getInteger("edu"));
        if(hrService.addWorker(worker)) {
            Log log = new Log();
            log.setHrId(hrService.getHr(username).getId());
            log.setMessage("时间: " + df.format( new Date()) + "   事件：添加工程师信息 信息如下: " + worker.toString());
            hrService.addLog(log);
            res.put("status", "success");
        }
        else
            res.put("reason", "insertError");
        return res;
    }

    @RequestMapping(path="/deleteWorker", method = RequestMethod.GET)
    public Object addWorker( @CookieValue(name = "username", required = false) String username, @CookieValue(name = "token", required = false) String token,
            @RequestParam("type") Integer type, @RequestParam("key") String key){
        Map<Object, Object> res = new HashMap<>();
        res.put("status", "failed");
        /*
        if(!hrService.verifyLogin(username, token)){
            res.put("reason", "notLogged");
            return res;
        }
        */
        if(hrService.deleteWorker(type, key) == 1) {
            res.put("status", "success");
            Log log = new Log();
            log.setHrId(hrService.getHr(username).getId());
            log.setMessage("时间: " + df.format( new Date()) + "   事件：删除工程师信息 信息如下: 删除方式: " + (type == 0 ? "编号": "姓名") + "  关键字：" + key);
            hrService.addLog(log);
        }
        else if (hrService.deleteWorker(type, key) == 2)
            res.put("reason", "deleteError");
        else
            res.put("reason", "noSuchWorker");
        return res;

    }

    @RequestMapping(path="/getWorker", method = RequestMethod.GET)
    public Object getWorker( @CookieValue(name = "username", required = false) String username, @CookieValue(name = "token", required = false) String token,
            @RequestParam("type") Integer type, @RequestParam("key") String key){
        Map<Object, Object> res = new HashMap<>();
        res.put("status", "failed");
        /*
        if(!hrService.verifyLogin(username, token)){
            res.put("reason", "notLogged");
            return res;
        }
        */
        List<Worker> worker = hrService.getWorker(type, key);
        if(worker != null)
        {
            res.put("status", "success");
            res.put("worker", worker);
        }
        else
            res.put("reason", "noSuchWorker");
        return res;
    }

    @RequestMapping(path="/getWorkers", method = RequestMethod.GET)
    public Object getWorkers( @CookieValue(name = "username", required = false) String username, @CookieValue(name = "token", required = false) String token){
        Map<Object, Object> res = new HashMap<>();
        res.put("status", "failed");
        /*
        if(!hrService.verifyLogin(username, token)){
            res.put("reason", "notLogged");
            return res;
        }
        */
        res.put("workers", hrService.getWorkers());
        res.put("status", "success");
        return res;
    }

    @RequestMapping(path="/deleteAll", method = RequestMethod.GET)
    public Object deleteAll( @CookieValue(name = "username", required = false) String username, @CookieValue(name = "token", required = false) String token){
        Map<Object, Object> res = new HashMap<>();
        res.put("status", "failed");
        /*
        if(!hrService.verifyLogin(username, token)){
            res.put("reason", "notLogged");
            return res;
        }
        */
        if(hrService.deleteAll()) {
            if(ifLog) {
                Log log = new Log();
                log.setHrId(hrService.getHr(username).getId());
                log.setMessage("时间: " + df.format( new Date() ) + "   事件：删除所有工程师信息");
                hrService.addLog(log);
            }
            res.put("status", "success");
        }
        return res;
    }

    @RequestMapping(path="/updateWorker", method = RequestMethod.POST)
    public Object updateWorker( @CookieValue(name = "username", required = false) String username, @CookieValue(name = "token", required = false) String token,
                                @RequestBody String body){
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
        if(!hrService.verifyLogin(username, token)){
            res.put("reason", "notLogged");
            return res;
        }
        */

        Worker oldWorker = hrService.getWorker(jsonObject.getInteger("uid"));
        Worker worker = new Worker();
        worker.setWksName(jsonObject.getString("name"));
        worker.setWksAddress(jsonObject.getString("address"));
        worker.setWksBirthdate(jsonObject.getDate("birthDate"));
        worker.setWksNumber(jsonObject.getString("number"));
        worker.setWksBasesalary(jsonObject.getInteger("baseSalary"));
        worker.setId(jsonObject.getIntValue("uid"));
        worker.setWksHometown(jsonObject.getString("hometown"));
        worker.setWksSeniority(jsonObject.getInteger("seniority"));
        worker.setWksSex(jsonObject.getString("sex"));
        worker.setWksTelephone(jsonObject.getString("telephone"));
        worker.setWksEdu(jsonObject.getInteger("edu"));
        if(hrService.updateWorker(worker) == 1) {
            if(ifLog) {
                Log log = new Log();
                log.setHrId(hrService.getHr(username).getId());
                log.setMessage("时间: " + df.format( new Date()) + "   事件：更新工程师信息 原信息如下:" + oldWorker.toString() + "  更新后信息如下: " + worker.toString());
                hrService.addLog(log);
            }
            res.put("status", "success");
        }
        else if(hrService.updateWorker(worker) == 2)
            res.put("reason", "updateError");
        else
            res.put("reason", "numberAlreadyExists");
        return res;
    }

}
