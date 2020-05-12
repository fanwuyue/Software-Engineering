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
  console.log((sex==null));
  var date=$('#year').val();
  var education=$('#education option:selected').val();
  var domicile=$("#domicile").val();
  var address=$("#address").val();
  var phone=$("#phone").val();
  var wyear=$("#working_year").val();
  var salary=$("#salary").val();
  if(id.length==0||name.length==0||sex==null||phone.length==0||wyear==null||date==null||education==null||domicile.length==0||address.length==0){
    alert("信息不得为空");
    return ;
  }
  //console.log(education);
  function check(id,name,phonem,domicile,address,salary){
    if(id<0||id>9999||isNaN(id)||id.length!=4)
    {
      alert('编号格式应为：4位数字 如0001');
      return false;
    }
    if(name.length>20){
      alert('姓名长度不能超过20');
      return false;
    }
    if(phone.length!=11||isNaN(phone)){
      alert('电话号码为11位数字');
      return ;
    }
    if(domicile.length>10){
      alert('籍贯长度不能超过10个字符');
      return ;
    }
    if(address.length>30){
      alert('地址长度不能超过30个字符');
      return ;
    }
    if(salary.length==0){
      alert('工资不能为空');
      return ;
    }
    if(salary<=0){
      alert('工资不能小于等于0');
      return ;
    }
    if(!confirm('是否提交')){
      return  false;
    }
    return true;
  }
  if(!check(id,name,phone,domicile,address,salary)){
    return ;
  }
//alert(name);
  var a = {};
  a.name = name;
  a.telephone = phone;
  a.sex = sex;
  a.seniority =parseInt(wyear);
  a.number = id;
  a.address=address;
  a.birthDate=date;
  a.baseSalary=parseFloat(salary);
  a.hometown=domicile;
  a.edu=parseInt(education);
  //console.log(sex);
  console.log(a);
  $.ajax({
    url: link+'/hr/addWorker',
    type: 'POST',
    dataType: "json",
    contentType: "application/json",
    data: JSON.stringify(a),
    xhrFields:{
      withCredentials:true
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
