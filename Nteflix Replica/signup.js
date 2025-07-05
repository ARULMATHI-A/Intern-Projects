function checkPwd(){
    let pwd=document.getElementById('pwd').value ;
    let warn=document.getElementById('demo');
    let len=parseInt(8);
    let hasUpper=false;
    let hasLower=false;
    let hasDigit=false;
    let hasSym=false;

    for(let i=0;i<pwd.length;i++){
        let ch=pwd[i];
        if(ch>='A' && ch<='Z' ) hasUpper=true;
        else if(ch>='a' && ch<='z') hasLower=true;
        else if(ch>='0' && ch<='9') hasDigit=true;
        else hasSym=true;
        console.log(ch);
    }

    if(pwd.length<len){
        warn.textContent='Weak Password';
        warn.style.color='red';
    }
   
    else if(hasUpper && hasLower && hasDigit && hasSym){
        warn.innerHTML='Strong Password';
        warn.style.color='green'
    }
    
     else if(hasUpper && hasLower && hasDigit){
        warn.innerHTML='Medium Password';
        warn.style.color='yellow'
    }
        
}