$(document).ready(function() {
  $("#quit").click(function(){
    window.location.href="../home.html";
  });

  function getMyDate(str) {
      var oDate = new Date(str),
      oYear = oDate.getFullYear(),
      oMonth = oDate.getMonth()+1,
      oDay = oDate.getDate(),
    
      oTime = oYear +'-'+ addZero(oMonth) +'-'+ addZero(oDay) ;
      return oTime;
  }

  function addZero(num){
      if(parseInt(num) < 10){
          num = '0'+num;
      }
      return num;
  }

  function getedu(str){
    if(str=='0'){
      return '高中';
    }
    if(str=='1'){
      return '学士';
    }
    if(str=='2'){
      return '硕士';
    }
    if(str=='3'){
      return '博士';
    }
    if(str=='4'){
      return '其它';
    }
  }
var link='http://sw.womoe.top';
$("#search").click(function(event) {

  var tb = document.getElementById('table');
       var rowNum=tb.rows.length;
       for (i=1;i<rowNum;i++)
       {
           tb.deleteRow(i);
           rowNum=rowNum-1;
           i=i-1;
       }



  var s=$("#type").find("option:selected").val();
  var key=$("#keyword").val();

    $.ajax({
      url: link+'/hr/getWorker?type='+s+'&key='+key,
      type: 'GET',
      xhrFields: {
  　　　　　　withCredentials: true
  　　　　}
    })
    .done(function(data){
      if(data.status=='success'){
        console.log(data.worker);
        var w=data.worker[0];
        if(w==null){
          alert('没有此用户');
        }else{
        //uid=w.id;
        var x=data.worker.length;
        for(var i=1;i<=x;i++){
          var t=data.worker[i-1];
          console.log(t);
          //var ta=$('#table').insertRow(i);
          var ta=document.getElementById('table').insertRow(i);
            var te=ta.insertCell(0);
                te.innerHTML=t.wksNumber;
             te=ta.insertCell(1);
             te.innerHTML=t.wksName;
             te=ta.insertCell(2);
             te.innerHTML=t.wksSex;
             te=ta.insertCell(3);
             te.innerHTML=getMyDate(t.wksBirthdate);
             te=ta.insertCell(4);
             te.innerHTML=getedu(t.wksEdu);
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

});
