$().ready(function(){
  var year = document.getElementById("year");
  var str = "";
  for(var i = 1970; i <= 2004; i++){
    str += "<option value=" + i + ">" + i + "</option>";
  }
  year.innerHTML = str;

  var month = document.getElementById("month");
  str = "";
  for(var i = 1; i <= 12; i++){
    str += "<option value=" + i + ">" + i + "</option>";
  }
  month.innerHTML = str;

  var day = document.getElementById("day");
  str = "";
  var table = [31,28,31,30,31,30,31,31,30,31,30,31];
  if(year%4==0&&year%400!=0){
    table[1]=29;
  }
  for(var i = 1; i <= table[parseInt(month)-1]; i++){
    str += "<option value=" + i + ">" + i + "</option>";
  }
  day.innerHTML = str;

  var working_year = document.getElementById("working_year");
  str = "";
  for(var i = 1; i <= 50; i++){
    str += "<option value=" + i + ">" + i + "</option>";
  }
  working_year.innerHTML = str;
});
