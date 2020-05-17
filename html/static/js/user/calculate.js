$(document).ready(function() {
  $("#quit").click(function(){
    window.location.href="../home.html";
  });
$('#calculate').click(function(event) {
  alert(1);
  /* Act on the event */
  var base_salary=$('#base_salary').val();
  var vaild_day=$('#vaild_day').val();
  var monthly_benefit=$('#monthly_benefit').val();
  var working_Ni=$('#working_Ni').val();
  var monthly_premium=$('#monthly_premium').val();
  var calculate=$('#calculate').val();
  //薪水＝（基本工资＋10╳月有效工作日天数＋月效益╳工作年限÷100）╳0.9－月保险金。
  var s=(parseInt(base_salary)+10*parseInt(vaild_day)+parseInt(monthly_benefit)*parseInt(working_Ni)/100)*0.9-parseInt(monthly_premium);
  $('#result').val(s);
  console.log(base_salary);
});
});
