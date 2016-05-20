/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var tilesNumbers = 20,
    tilesInLine = 5,
    tiles = [],
    downloadedTiles = [],
    numberOfTries = 0,
    canTake = true,
    completePairsOfTiles = 0,
    tilesPictures = [
        'img/title_1.png',
        'img/title_2.png',
        'img/title_3.png',
        'img/title_4.png',
        'img/title_5.png',
        'img/title_6.png',
        'img/title_7.png',
        'img/title_8.png',
        'img/title_9.png',
        'img/title_10.png'
    ];
    
function startGame(){
    tiles = [];
    downloadedTiles = [];
    canTake = true;
    numberOfTries = 0;
    completePairsOfTiles = 0;
    
    var gameBoard = $('.gameBoard').empty();   

        for (i = 0; i < tilesNumbers; i++){
            tiles.push(Math.floor(i/2));
        }

        for (i = tilesNumbers -1; i > 0; i--){
            var swap = Math.floor(Math.random()*i);
            var tmp = tiles[i];
            tiles[i] = tiles[swap];
            tiles[swap] = tmp;

        }

        for (i = 0; i < tilesNumbers; i++){
            var tile = $('<div class="tiles"></div>');
            gameBoard.append(tile);
            tile.data('cardType',tiles[i]);
            tile.data('index',i);
            
            tile.css({
                left : 5+(tile.width()+5)*(i%tilesInLine)
            });
            tile.css({
                top : 5+(tile.height()+5)*(Math.floor(i/tilesInLine))
            });

            tile.bind('click', function(){
               tilesClick($(this)); 
               
            });
        }
            $('.points').html('Liczba prób: '+numberOfTries);
        }  

        function tilesClick(element){
            if(canTake){    
                if(!downloadedTiles[0] || (downloadedTiles[0].data('index') != element.data('index'))){
                   downloadedTiles.push(element);
                   element.css({
                       'background-image' : 'url('+tilesPictures[element.data('cardType')]+')'
                   });
               }

                if(downloadedTiles.length === 2){
                    canTake = false;
                    if(downloadedTiles[0].data('cardType') == downloadedTiles[1].data('cardType')){
                        setTimeout('removeTiles()', 500);
                    } else {
                        setTimeout('resetTiles()', 500);
                    }
                    numberOfTries++;
                    $('.points').html('Liczba prób: '+numberOfTries);
                }
                
            }
        }

        function removeTiles(){
            downloadedTiles[0].fadeOut(function(){
                $(this).remove();
            });
            downloadedTiles[1].fadeOut(function(){
                $(this).remove();

                completePairsOfTiles++;
                if(completePairsOfTiles >= (tilesNumbers/2)){
                    alert('Koniec Gry! \npo '+numberOfTries+' próbach!');
                }
                canTake = true;
                downloadedTiles = new Array();
            });          
        }

        function resetTiles(){
            downloadedTiles[0].css({
                'background-image' : 'url(img/title.png)'
            });
            downloadedTiles[1].css({
                'background-image' : 'url(img/title.png)'
            });
            canTake = true;
            downloadedTiles = new Array();
        }

$(document).ready(function(){
    $('#startGame').click(function(){
        startGame();
    });
});