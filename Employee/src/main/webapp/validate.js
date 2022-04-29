function ValidateEmail(mail) 
{
	var email1=document.getElementById('email');
 if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(myForm.email1.value))
  {
    return (true)
  }
    alert("You have entered an invalid email address!")
    return (false)
}