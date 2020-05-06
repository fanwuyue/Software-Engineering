$(document).ready(function() {

var link='http://sw.womoe.top';
$("#empty").click(function(event) {
  alert('1');
    $.ajax({
      url: link+'/hr/deleteAlll',
      type: 'GET',
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
