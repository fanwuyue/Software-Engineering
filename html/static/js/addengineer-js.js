$().ready(function(){
  var year = document.getElementById("year");
  var str = "";
  for(var i = 1900; i <= 2004; i++){
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
  for(var i = 1; i <= 31; i++){
    str += "<option value=" + i + ">" + i + "</option>";
  }
  day.innerHTML = str;

  var working_year = document.getElementById("working_year");
  str = "";
  for(var i = 1; i < 50; i++){
    str += "<option value=" + i + ">" + i + "</option>";
  }
  working_year.innerHTML = str;
});
