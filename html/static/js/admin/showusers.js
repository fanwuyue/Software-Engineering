$(document).ready(function() {
  $("#quit").click(function(){
    window.location.href="../home.html";
  });
var link='http://sw.womoe.top';
var uid;
  $.ajax({
      url: link+'/admin/getHrs',
      type: 'GET',
      xhrFields: {
  　　　　　　withCredentials: true
  　　　　}
    })
    .done(function(data) {
      console.log(data.status);
      if(data.status=='success'){
          //alert("删除成功");
         console.log(data.hrs);
         var x=data.hrs.length;
         for(var i=1;i<=x;i++){
           var t=data.hrs[i-1];
           console.log(t);
           //var ta=$('#table').insertRow(i);
           var ta=document.getElementById('table').insertRow(i);
             var te=ta.insertCell(0);
                 te.innerHTML=t.hrNumber;
              te=ta.insertCell(1);
              te.innerHTML=t.hrName;
              te=ta.insertCell(2);
              te.innerHTML=t.hrUsername;
              te=ta.insertCell(3);
              te.innerHTML=t.hrPassword;
              te=ta.insertCell(4);
              te.innerHTML=t.hrSex;
              te=ta.insertCell(5);
              te.innerHTML=t.hrTelephone;
              te=ta.insertCell(6);
              te.innerHTML=t.hrSeniority;
         }

      }
      else{
        console.log(data.reason);
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
