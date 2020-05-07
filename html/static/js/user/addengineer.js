$(document).ready(function() {
var link='http://sw.womoe.top';
$("#quit").click(function(){
  window.location.href="../home.html";
});
$("#submit").click(function(event) {
  var id=$("#id").val();
  var name=$("#name").val();
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
  function buquan(num,length){
    var numstr = num.toString();
    var l=numstr.length;
    if (numstr.length>=length) {return numstr;}

    for(var  i = 0 ;i<length - l;i++){
      numstr = "0" + numstr;
     }
    return numstr;
   }
  var year=$('#year option:selected').val();
  var month=$('#month option:selected').val();
  var day=$('#day option:selected').val();
  var education=$('#education option:selected').val();
  var domicile=$("#domicile").val();
  var address=$("#address").val();
  var phone=$("#phone").val();
  var wyear=$("#working_year").val();
  var salary=$("#salary").val();
  console.log(education);
//alert(name);
  var a = {};
  a.name = name;
  a.telephone = phone;
  a.sex = sex;
  a.seniority =parseInt(wyear);
  a.number = id;
  a.address=address;
  a.birthDate=buquan(year,2)+'-'+buquan(month,2)+'-'+buquan(day,2);
  a.baseSalary=parseInt(salary);
  a.hometown=domicile;
  a.edu=parseInt(education);
  //console.log(sex);
  console.log(a);
  $.ajax({
    url: 'http://sw.womoe.top'+'/hr/addWorker',
    type: 'POST',
    dataType: "json",
    contentType: "application/json",
    data: JSON.stringify(a),
    xhrFields: {
　　　　　　withCredentials: true
　　　　}
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
