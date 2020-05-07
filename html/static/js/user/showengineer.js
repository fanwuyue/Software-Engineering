$(document).ready(function() {
  $("#quit").click(function(){
    window.location.href="../home.html";
  });
var link='http://sw.womoe.top';


    $.ajax({
      url: link+'/hr/getWorkers',
      type: 'GET',
    })
    .done(function(data){
      //console.log(data);
      if(data.status=='success'){
        //console.log(data.worker);
        var w=data.workers[0];
        if(w==null){
          alert('没有工程师');
        }else{
        //uid=w.id;
        var x=data.workers.length;
        for(var i=1;i<=x;i++){
          var t=data.workers[i-1];
          //console.log(t);
          //var ta=$('#table').insertRow(i);
          var ta=document.getElementById('table').insertRow(i);
            var te=ta.insertCell(0);
                te.innerHTML=t.wksNumber;
             te=ta.insertCell(1);
             te.innerHTML=t.wksName;
             te=ta.insertCell(2);
             te.innerHTML=t.wksSex;
             te=ta.insertCell(3);
             te.innerHTML=t.wksBirthDate;
             te=ta.insertCell(4);
             te.innerHTML=t.wksEdu;
             te=ta.insertCell(5);
             te.innerHTML=t.wksHometown;
             te=ta.insertCell(6);
             te.innerHTML=t.wksAddress;
             te=ta.insertCell(7);
             te.innerHTML=t.wksTelephone;
             te=ta.insertCell(8);
             te.innerHTML=t.wksSeniority;
             te=ta.insertCell(9);
             te.innerHTML=t.wksBasesalary;
        }
      }
      }
      else{
        //console.log(data.reason);
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
