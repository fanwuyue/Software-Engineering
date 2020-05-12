$().ready(function(){

  day.innerHTML = str;

  var working_year = document.getElementById("working_year");
  str = "";
  for(var i = 1; i <= 50; i++){
    str += "<option value=" + i + ">" + i + "</option>";
  }
  working_year.innerHTML = str;
});
