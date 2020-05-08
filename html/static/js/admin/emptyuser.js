$(document).ready(function() {

var link='http://sw.womoe.top';
$("#empty").click(function(event) {
  if(!confirm("是否清空所有用户")){
    return ;
  }
    $.ajax({
      url: link+'/admin/deleteAll',
      type: 'GET',
      xhrFields: {
  　　　　　　withCredentials: true
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

$("#quit").click(function(){
  window.location.href="../home.html";
});


});
