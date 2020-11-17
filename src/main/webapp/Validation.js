
function setR(r){
    document.getElementById("Radius").innerHTML='Задан радиус '+r;
    document.getElementById('rad').value=r;
}
function validateData(){
    let x,y,r;
    x = document.forms['data'];
    let val = "";
    let i;
    for(i=0;i<x.length;i++){
        if(x[i].checked){
            val+=x[i].value+",";
        }
    }
    if(val==="") {
        alert("Не выбрана координата x");
        return false;
    }
    y=parseLocal(document.forms['data']['y'].value);
    if(y==="" || isNaN(y) || y<-3 || y>5 || equals(y,5) || equals(y,-3)){
        alert("Неверная координата y");
        return false;
    }
    else
        document.forms['data']['y'].value=y;
    r= parseLocal(document.forms['data']['r'].value);
    if(r===""){
        alert("Радиус не задан");
        return false;
    }
}
function equals(a,b){
    let epsilon = 2**-50;
    return Math.abs(a-b)<epsilon;
}
function parseLocal(num){
    return num.replace(',','.');
}