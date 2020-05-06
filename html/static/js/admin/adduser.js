$(document).ready(function() {
var link='http://sw.womoe.top';
$("#quit").click(function(){
  window.location.href="../home.html";
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
       if(sex=='1'){
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
  }
//alert(name);
  var a = {};
  a.name = name;
  a.telephone = phone;
  a.username = username;
  a.password = password;
  a.sex = sex;
  a.seniority = wyear;
  a.number = id;

  $.ajax({
    url: 'http://sw.womoe.top'+'/admin/addHr',
    type: 'POST',
    dataType: "json",
    contentType: "application/json",
    data: JSON.stringify(a)
  }).done(function(data) {
  //console.log(data);
  if(data.status=='success'){
  alert("添加成功");
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
}
})
.fail(function() {
  console.log("error");
})
.always(function() {
});


});

});
