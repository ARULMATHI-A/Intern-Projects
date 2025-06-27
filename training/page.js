function checkBMI(){
    let wt=document.getElementById('height').value ;
    let ht=document.getElementById('weight').value ;
    let cal=wt/((ht/100)**2);
    let bmi=cal.toFixed(2);

    if(bmi<18.5){
        document.getElementById('output').innerHTML=bmi+ ' UnderWeight';
    }
    else if(bmi>=18.5 || bmi<=24.5){
        document.getElementById('output').innerHTML=bmi+ ' Normal Weight';
    }
    else if(bmi>=25.0 || bmi<=29.9){
        document.getElementById('output').innerHTML=bmi+ ' OverWeight';
    }
    else{
        document.getElementById('output').innerHTML=bmi+ ' OBESE..please Exercise';

    }
}

