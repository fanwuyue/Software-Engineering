$(document).ready(function() {

  $("#quit").click(function(){
    window.location.href="../home.html";
  });
var link='http://sw.womoe.top';
var uid;
$("#delete").click(function(event) {
  var s=$("#type").find("option:selected").val();
  var key=$("#keyword").val().toString();
  if(!confirm("是否删除用户")){
    return ;
  }
    $.ajax({
      url: link+'/admin/deleteHr?type='+s+'&key='+key,
      type: 'GET',
      xhrFields:{
        withCredentials:true
      }
    })
    .done(function(data) {
      console.log(data.status);
      if(data.status=='success'){
          alert("删除成功");
      }
      else{
        console.log(data.reason);
        if(data.reason=='deleteError'){
            alert('删除失败');
        }
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
});
