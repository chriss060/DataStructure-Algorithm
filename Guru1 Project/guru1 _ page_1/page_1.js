$(document).ready(function(){  

		$(".topnav").hover(function() { //마우스를 topnav에 오버시
			$(this).parent().find(".subnav").slideDown('normal').show(); //subnav가 내려옴.
			$(this).parent().hover(function() {  
			}, function(){  
				$(this).parent().find(".subnav").slideUp('fast'); //subnav에서 마우스 벗어났을 시 원위치시킴  
			});  
		}); 

	});  

$(document).ready(function(){  

		$("#lang").click(function() { //상단 메뉴 클릭시
      if($(this).parent().find('#lang_li').is(":visible")){ //하위 메뉴가 화면상 보일때 (:is visible) slideup
        $(this).parent().find("#lang_li").slideUp('normal');
      }
      else{  
				$(this).parent().find("#lang_li").slideDown('normal'); //안보일 때 slideDown
			} 
}); 

});



$(document).ready(function(){
  $('.btn_site_map_down').click(function(){
    if($('.btn_site_map_down').hasClass('btn_site_map_down')){
       $('.btn_site_map_down').addClass('btn_site_map_up').removeClass('btn_site_map_down');
       $('.site_map').slideDown();
    }else if($('.btn_site_map_up').hasClass('btn_site_map_up')){
       $('.btn_site_map_up').addClass('btn_site_map_down').removeClass('btn_site_map_up');
        $('.site_map').slideUp();         
    }
  });
});

 $(function() {
  var count0 = 338;
  var count1 = 12;
  var count2 = 0;
  var count3 = 1858;

  timeCounter();
  setTimeout(textPrinter, 5000);

  function timeCounter() {

    id0 = setInterval(count0Fn, 12.015259);

    function count0Fn() {
      count0 += 1111;
      if (count0 > 328083) {
        clearInterval(id0);
      } else {
        $(".number").eq(0).text(count0);
      }
    }

    id1 = setInterval(count1Fn, 11.888888);

    function count1Fn() {
      count1 += 21;
      if (count1 > 3960) {
        clearInterval(id1);
      } else {
        $(".number").eq(1).text(count1);
      }
    }

    id2 = setInterval(count2Fn, 4.36205016);

    function count2Fn() {
      count2 += 41;
      if (count2 > 19270) {
        clearInterval(id2);
      } else {
        $(".number").eq(2).text(count2);
      }
    }

    id3 = setInterval(count3Fn, 12.105740);

    function count3Fn() {
      count3 += 8999;
      if (count3 > 2584571) {
        clearInterval(id3);
      } else {
        $(".number").eq(3).text(count3);
      }
    }
  }

  function textPrinter() {
    var printer = document.getElementsByClassName('number');
    printer[0].textContent = "328,083";
    printer[1].textContent = "3,960";
    printer[2].textContent = "19,270";
    printer[3].textContent = "2,584,571";
  }
});








