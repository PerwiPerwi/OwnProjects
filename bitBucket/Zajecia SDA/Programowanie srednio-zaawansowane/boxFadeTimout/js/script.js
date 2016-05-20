(function ($) {
 
   $('.box').click(function() {
       
       var $this = $(this);
       
      setTimeout(function(){
         
          $this.fadeOut(1500, function(){
             
              $this.show();
             
          });
         
      }, 5000);
       
   });
 
})(jQuery);