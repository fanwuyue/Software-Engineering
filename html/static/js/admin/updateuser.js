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
      xhrFields: {
  　　　　　　withCredentials: true
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
//alert(name);
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
    url: 'http://sw.womoe.top'+'/admin/updateHr',
    type: 'POST',
    dataType: "json",
    contentType: "application/json",
    xhrFields: {
　　　　　　withCredentials: true
　　　　},
    data: JSON.stringify(a)
  }).done(function(data) {
  //console.log(data);
  if(data.status=='success'){
  alert("修改成功");
}else{
  console.log(data);
  if(data.reason=='insertError'){
      alert('插入失败(编号已存在)');
  }
  if(data.reason=='errorBody'){
    alert('请求体有误');
  }
  if(data.reason=='notLogged'){
    alert('没有登陆或cookie失效');
  }
  if(data.reason=='numberAlreadyExists'){
    alert('所填编号已存在');
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
