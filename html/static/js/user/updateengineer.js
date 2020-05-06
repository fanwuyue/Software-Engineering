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
    })
    .done(function(data){
      if(data.status=='success'){

        console.log(data.worker);
        var w=data.worker[0];
        if(w==null){
          alert('没有此用户');
        }else{
        //uid=w.id;
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
  console.log(education);
//alert(name);
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
    url: 'http://sw.womoe.top'+'/hr/updateWorker',
    type: 'POST',
    dataType: "json",
    contentType: "application/json",
    data: JSON.stringify(a)
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
