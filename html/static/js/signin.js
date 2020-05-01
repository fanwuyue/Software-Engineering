$(document).ready(function() {
  var link='http://sw.womoe.top';
// if($.cookie("username")!=null&&$.cookie("token")!=null){
//   //alert('有cookie'+document.cookie);
//   $.ajax({
//     url: link+'/admin/verifyLogin',
//     type: 'GET',
//     xhrFields: {
// 　　　　　　withCredentials: true
// 　　　　}
//   })
//   .done(function(status){
//     if(status=='success'){
//       alert("校验成功");
//     }else{
//       alert('校验失败');
//     }
//   })
// }

  $("button").click(function(event) {
    /* Act on the event */
     var name=$("input[name='username']").val();
     var pwd=$("input[name='password']").val()
    if(name==""||pwd==""){
      alert("用户名和密码不得为空");
    }else{
  
    $.ajax({
      url: link+'/admin/login?username='+name+'&password='+pwd,
      type: 'GET'
    })
    .done(function(data) {
       if(data.status=='success'){
         alert("登陆成功");
         var t=data.token;
         $.cookie('username', name);
           $.cookie('token', t);
        // console.log(document.cookie);
        //alert(document.cookie);
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

})
