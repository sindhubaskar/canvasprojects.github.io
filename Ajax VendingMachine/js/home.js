

$(document).ready(function(){
        loadItems();

        $('#dollar').click(function(){
           addMoney(1);
         
        })
        $('#quarter').click(function(){
            
           addMoney(0.25);
        })
        $('#dime').click(function(){
           addMoney(0.10);
             
        })
        $('#nickel').click(function(){
            addMoney(0.05);
            
        })

        $('#makePurchase').click(function(){

            $.ajax({
                type:"GET",
                url:'http://localhost:8080/money/'+ $("#total").val() +'/item/'+ $("#item").val(),

                 success:function(change){
                    var changeElement=$('#change');
                    var changeBack='';

                    changeBack='quarter:'+change.quarters
                    changeBack+='dime:'+change.dimes
                    changeBack+='nickel:'+change.nickels+ 'pennies:'+change.pennies;
                    
                    changeElement.val(changeBack);
                    addMoney(-amount);
                    $("#itemButtons").empty();
                    loadItems();

                 },
                 error:function(a,b,c){
                     $('#message').val(a.responseJSON.message);

                 }

            })



        })


         $('#changeReturn').click(function(){
             $('#message').val('');
             $('#change').val('');
             $('#total').val('');
             $('#item').val('');
               
         })
         
         

       
});

function loadItems(){
   
    var contentButtons=$("#itemButtons");

    
   $.ajax({
        type:"GET",
        url:"http://localhost:8080/items",
        success:function(itemArray){
            $.each(itemArray,function(dontUseMe,item){
                var itemList=item.id +'<br>'+
                           item.name +'<br>'+
                           item.price+'<br>'+
                           item.quantity;
                    var row='<button>';
                    row+='<button onclick=loadItemId('+item.id+')>'+ itemList + '</button>';
                     
                     row+='</button>';

                    contentButtons.append(row);

            });
           
            
        },
        error: function(a,b,c){
            alert('Failure');
        }
    })
}

function loadItemId(id){
    $('#item').val(id);
    
}

var amount = 0;
function addMoney( toAdd )
{
    amount+=toAdd;
    $('#total').val(amount);

}




