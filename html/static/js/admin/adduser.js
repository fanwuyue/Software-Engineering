$(document).ready(function() {
var link='http://sw.womoe.top';

$("#submit").click(function(event) {
  var id=$("#id").val();
  var name=$("#name").val();
  var sex=null;
  var obj=document.getElementsByName("sex");
  for (var i=0;i<obj.length;i++){ //遍历Radio
    if(obj[i].checked){
       sex=obj[i].value;
    }
  }
 if(sex==1){
   sex='女';
 }else{
   sex='男';
 }
  var phone=$("#phone").val();
  var wyear=$("#working_year").val();
  var a = {};
  a.name = name;
  a.telephone = phone;
  a.username = 'username';
  a.password = 'password';
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
  alert(data.reason);
}
})
.fail(function() {
  console.log("error");
})
.always(function() {
});


})

})
