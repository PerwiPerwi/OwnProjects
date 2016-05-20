/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
    
    
    
   
      
    //$('#parent').click(function(e){
        
        $('a.switch').click(function(){
        
            if( $(this).hasClass('active') ){

                $(this).removeClass('active');

                $('div.child').each(function(){

                    if( $(this).hasClass('child1') ){

                        $(this).animate({'right': 700, 'top': 50}, 1000);

                    }

                    else{

                        $(this).animate({'left': 700, 'top': 50}, 1000);

                    }
                });
            }


            else{

                $(this).addClass('active');

                $('div.child').each(function(){

                    if( $(this).hasClass('child1') ){


                        $(this).animate({'right': 100, 'top': 300}, 1000);

                    }

                    else{

                        $(this).animate({'left': 100, 'top': 300}, 1000);

                    }
                });
            }


        });
        
  $('#facebookBox .label').click(function(){      
        if($(this).hasClass('active')){
            $(this).removeClass('active');
            $(this).parent().animate({'left': -210},500);
            
        }
        
        else{
            $(this).addClass('active');
            $(this).parent().animate({'left': 0},500);
        }
      });  
        
        
     
});