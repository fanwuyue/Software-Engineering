$(document).ready(function() {
  $("#quit").click(function(){
    window.location.href="../home.html";
  });
var link='http://sw.womoe.top';
var uid;
$("#search").click(function(event) {
  var s=$("#type").find("option:selected").val();
  var key=$("#keyword").val();

    $.ajax({
      url: link+'/admin/getHr?type='+s+'&key='+key,
      type: 'GET',
      xhrFields:{
        withCredentials:true
      }
    })
    .done(function(data) {
      console.log(data.status);
      if(data.status=='success'){
        //console.log(data.hr);
        //console.log(data.hr.hrName);
        $("#id").val(data.hr.hrNumber);
        $("#name").val(data.hr.hrName);
        $("#username").val(data.hr.hrUsername);
        $("#password").val(data.hr.hrPassword);
        $("#phone").val(data.hr.hrTelephone);
        uid=data.hr.id;
        console.log(data.hr.hrSex);
        if(data.hr.hrSex=='男'){
          $("#sex1").click();
          console.log(data.hr.heSex);
        }else{
          $("#sex0").click();
        }
        $("#working_year").val(data.hr.hrSeniority);
      }
      else{
        console.log(data.reason);
        if(data.reason=='noSuchHr'){
          alert('没有此用户');
        }
        if(data.reason=='notLogged'){
          alert('没有登陆或cookie失效');
        }
      }
    })
    .fail(function() {
      console.log("error");
    })
    .always(function() {
    //  console.log("complete");
    });

});

$("#submit").click(function(event) {
  var id=$("#id").val();
  var name=$("#name").val();
  var username=$("#username").val();
  var password=$("#password").val();
  var sex;
  var obj=document.getElementsByName("sex");
  for (var i=0;i<obj.length;i++){ //遍历Radio
    if(obj[i].checked){
       sex=obj[i].value;
       if(sex=='0'){
         sex='女';
       }else{
         sex='男';
       }
    }
  }
  var phone=$("#phone").val();
  var wyear=$("#working_year").val();
  if(id==null||name==null||username==null||password==null||sex==null||phone==null||wyear==null){
    alert("信息不得为空");
    return ;
  }
//alert(name);
function check(id,name,phone,username,password){
  if(id<0||id>9999||isNaN(id)||id.length!=4)
  {
    alert('编号格式应为：4位数字 如0001');
    return false;
  }
  if(name.length>20){
    alert('姓名长度不能超过20');
    return false;
  }
  if(username.length<8||username.length>20){
    alert('用户名长度应在8~20之间');
    return false;
  }
  if(password.length<8||password.length>20){
    alert('密码长度应在8~20之间');
    return false;
  }
  if(phone.length!=11||isNaN(phone)){
    alert('电话号码为11位数字');
    return false;
  }
  if(!confirm('是否提交')){
    return  false;
  }
  return true;
}
if(!check(id,name,phone,username,password)){
  return ;
}
  var a = {};
  a.uid=uid;
  a.name = name;
  a.telephone = phone;
  a.username = username;
  a.password = password;
  a.sex = sex;
  a.seniority = wyear;
  a.number = id;

  $.ajax({
    url: link+'/admin/updateHr',
    type: 'POST',
    dataType: "json",
    contentType: "application/json",
    xhrFields:{
      withCredentials:true
    },
    data: JSON.stringify(a)
  }).done(function(data) {
  //console.log(data);
  if(data.status=='success'){
  alert("修改成功");
}else{
  console.log(data);
  if(data.reason=='numberAlreadyExists'){
      alert('编号已存在');
  }
  if(data.reason=='errorBody'){
    alert('请求体有误');
  }
  if(data.reason=='notLogged'){
    alert('没有登陆或cookie失效');
  }
  if(data.reason=='nameAlreadyExists'){
    alert('用户名已存在');
  }
}
})
.fail(function() {
  console.log("error");
})
.always(function() {
});


});

});
