$(document).ready(function() {
  $("#quit").click(function(){
    window.location.href="../home.html";
  });
var link='http://sw.womoe.top';
var uid;
  $.ajax({
      url: link+'/admin/getLogs',
      type: 'GET',
    })
    .done(function(data) {
      console.log(data.status);
      if(data.status=='success'){
         console.log(data.logs);
         var x=data.logs.length;
         for(var i=1;i<=x;i++){
           var t=data.logs[i-1];
           console.log(t);
           var ta=document.getElementById('table').insertRow(i);
             var te=ta.insertCell(0);
                 te.innerHTML=t.id;
              te=ta.insertCell(1);
              te.innerHTML=t.hrName;
              te=ta.insertCell(2);
              te.innerHTML=t.hrNumber;
              te=ta.insertCell(3);
              te.innerHTML=t.message;
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
