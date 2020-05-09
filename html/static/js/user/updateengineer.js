$(document).ready(function() {
var link='http://sw.womoe.top';
var uid;
$("#quit").click(function(){
  window.location.href="../home.html";
});
$("#search").click(function(event) {
  var s=$("#type").find("option:selected").val();
  var key=$("#keyword").val();

    $.ajax({
      url: link+'/hr/getWorker?type='+s+'&key='+key,
      type: 'GET',
      xhrFields:{
        withCredentials:true
      }
    })
    .done(function(data){
      if(data.status=='success'){

        console.log(data.worker);
        var w=data.worker[0];
        if(w==null){
          alert('没有此用户');
        }else{
        uid=w.id;
        $("#id").val(w.wksNumber);
        $("#name").val(w.wksName);
       console.log(w.wksName);
        if(w.wksSex=='男'){
          $("#sex2").click();
          console.log(w.wksSex);
        }else{
            $("#sex1").click();
        }
        var b=w.wksBirthDate;
        $('#domicile').val(w.wksHometown);
        $('#address').val(w.wksAddress);
        $("#phone").val(w.wksTelephone);
        $('#salary').val(w.wksBasesalary);
        $("#working_year").val(w.wksSeniority);
      }
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
  //console.log(education);
//alert(name);
if(id.length==0||name.length==0||sex==null||phone.length==0||wyear==null||month==null||day==null||year==null||education==null||domicile.length==0||address.length==0){
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
  var a = {};
  a.uid=uid;
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
    url: link+'/hr/updateWorker',
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
  alert("修改成功");
}else{
  console.log(data);
  if(data.reason=='updateError'){
      alert('修改失败');
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
