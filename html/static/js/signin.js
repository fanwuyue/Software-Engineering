$(document).ready(function() {
  var link='http://sw.womoe.top';

  $("#admin_login").click(function(event) {
    /* Act on the event */
    //alert(name);
    //alert(pwd);
    var name=$("#username").val();
    var pwd=$("#password").val();
    if(name==""||pwd==""){
      alert("用户名和密码不得为空");
    }else{

    $.ajax({
      url: link+'/admin/login?username='+name+'&password='+pwd,
      type: 'GET',
      xhrFields:{
        withCredentials:true
      }
    })
    .done(function(data) {
       if(data.status=='success'){
         var t=data.token;
         $.cookie('username', name, {
           domain: 'sw.womoe.top'
         });
           $.cookie('token', t, {
             domain: 'sw.womoe.top'
           });
           window.username=name;
           window.token=data.token;
      //  alert(document.cookie);
        window.location.href="./administrator/index.html";
       }else{
         alert("账号或密码有误");
       }
    })
    .fail(function() {
      console.log('error');
    })
    .always(function() {
      //console.log("complete");
    });
  }
  });
  $("#login").click(function(event) {
    /* Act on the event */
    //alert(name);
    //alert(pwd);
    var name=$("#username").val();
    var pwd=$("#password").val();
    if(name==""||pwd==""){
      alert("用户名和密码不得为空");
    }else{
    $.ajax({
      url: link+'/hr/login?username='+name+'&password='+pwd,
      type: 'GET'
    })
    .done(function(data) {
       if(data.status=='success'){
         alert("登陆成功");
         var t=data.token;
         $.cookie('username', name, {
           domain: 'sw.womoe.top'
         });
           $.cookie('token', t, {
             domain: 'sw.womoe.top'
           });
        //alert(document.cookie);
        window.location.href="./user/index.html";
       }else{
         alert("账号或密码有误");
       }
    })
    .fail(function() {
      console.log('error');
    })
    .always(function() {
      //console.log("complete");
    });
  }
  });



});
