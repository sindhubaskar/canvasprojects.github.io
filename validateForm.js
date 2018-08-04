function validateForm()
{

	var name1=document.getElementById('name1').value;
	var email=document.getElementById('email').value;
	var phone=document.getElementById('phone').value;
    var info=document.getElementById('info').value;
    var by=document.myform.yes;
    var bn=document.myform.no;
    var check=document.myform.option;

   
    if(allLetter(name1))
	{
		if(validateEmail(email))
		{
			if(allNumeric(phone))
			{
			    if(select(check))
			    {
			      if(text(info))
			        {
			    	  if(validbeen(by,bn))
			            {
			            	
		                   alert("Information is valid");
		                }
		 		    }    
		 	     }   
		 	}
		}
	}
} 

function allLetter(name1) 
{ 
 var letters = /^[\w ]+$/;
   if(name1.match(letters)) 
   {
     return true;
   } else
      { 
	    alert('Name must have alphabet characters only');
	    return false;
      }
}

function validateEmail(email)
{
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
      if(email.match(mailformat))
      {
      	return true;

      } else
        {
        	alert("you have entered an invalid email address");
        	
        	return false;

        }
}

function allNumeric(phone)
{  
	var numbers=/^[0-9]+$/;
	if((phone.match(numbers))&&(phone.length==10))
	{
		return true;
	}else
	  {
	  	alert("phone numbers must have 10 digits");
	  	
	  	return false;
	  }
	  	
}

function text(info)
{
	
	if(info!=="")
	{
		return true;
	 }else{
		 alert("write some text here");
         return false;

	 }
}
function validbeen(by,bn)
{
	x=0;
	if(by.checked)
	{
		x++;
	}if(bn.checked)
	{
		x++;
	}
	if(x==0)
	{
		alert("select yes/no");
		return false;
	}
	else
	{
		return true;
	}
	
}

function select(check)
{
	for (var i=0;i<check.length;i++)
     { 
       if(check[i].checked)
       	return true;
     }
     if(i==check.length)
     	alert("No checkbox is checked");
     return false;
}  

