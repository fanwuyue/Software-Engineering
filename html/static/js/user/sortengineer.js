$(document).ready(function() {

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
  $("#quit").click(function(){
    window.location.href="../home.html";
  });
var link='http://sw.womoe.top';


  var tb = document.getElementById('table');
       var rowNum=tb.rows.length;
       for (i=1;i<rowNum;i++)
       {
           tb.deleteRow(i);
           rowNum=rowNum-1;
           i=i-1;
       }

    $.ajax({
      url: link+'/hr/getWorkers',
      type: 'GET',
      xhrFields:{
        withCredentials:true
      }
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

  $("#sort").click(function(){
    var oTable = document.getElementById('table');
        var oTbody = oTable.tBodies[0];
        console.log(oTable);
        var type=$('#type').val();
        //alert(type);
        var arr = [];//用来存放每一个tr
          var isAsc;
        if($('#sequence').val()=='0'){
          isAsc=true;
        }else{
          isAsc=false;
        }
        for (var i = 0; i < oTbody.rows.length; i++ ) {
                arr[i] = oTbody.rows[i+1];
                }
        if(type=='1')
            {
                 arr.sort(function (param1, param2) {
                   if(isAsc){
                       return (param1.cells[type].innerHTML).localeCompare(param2.cells[type].innerHTML,"zh");}
                    else{
                      return (param2.cells[type].innerHTML).localeCompare(param1.cells[type].innerHTML,"zh");
                         }
                  }
             );
         }else{
            arr.sort(function (td1, td2){
                if(isAsc) {
                    return parseInt(td1.cells[type].innerHTML) - parseInt(td2.cells[type].innerHTML);
                    } else {
                        return parseInt(td2.cells[type].innerHTML) - parseInt(td1.cells[type].innerHTML);
                        }
                });
            }
            //把排序后的tr 重新插入tbody
        for(var j =0; j < arr.length; j++ ) {
            oTbody.appendChild(arr[j]);
          }

});

});
