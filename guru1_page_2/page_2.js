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

		$(".top_menu").click(function() { //상단 메뉴 클릭시
      if($(this).parent().find('.menu_content').is(":visible")){ //하위 메뉴가 화면상 보일때 (:is visible) slideup
        $(this).parent().find(".menu_content").slideUp('normal');
      }
      else{  
        $(this).parent().find(".menu_content").slideDown('normal'); //안보일 때 slideDown
        $(this).closest("#location").siblings().find(".menu_content").slideUp("normal"); //다른 메뉴들은 slideUp
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