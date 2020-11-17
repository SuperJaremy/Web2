//x: 108.66668701171875 y: 109 - центр координат
//x: 188.66668701171875 y: 109 - R

function draw(){
    let ctx;
    const canvas = document.getElementById("int_elem");
    canvas.addEventListener('mousedown', function(e) {
        if(canvas.getContext){
            const point = getCursorPosition(canvas, e);
            const newPoint = transformPoint(point.x, point.y);
            if(newPoint!=null) {
                submitPoint(newPoint.x, newPoint.y, newPoint.r)
                    .then(function (result) {
                        ctx = canvas.getContext("2d");
                        ctx.beginPath();
                        ctx.arc(point.x, point.y, 3, 0, Math.PI * 2);
                        if (checkHit(newPoint.x, newPoint.y, newPoint.r, result))
                            ctx.fillStyle = 'rgb(0,255,0)';
                        else ctx.fillStyle = 'rgb(255,0,0)';
                        ctx.fill();
                        refreshTable(result);
                        const canvas1 = document.getElementById("int_elem");
                        sessionStorage.setItem('canvas',canvas1.toDataURL());
                    })
            }
        }
    })
    if(canvas.getContext){
        ctx = canvas.getContext("2d");
        const img = new Image();
        img.src="webGrid.png";
        img.onload=function (){
            ctx.drawImage(img,0,0);
            const previous = sessionStorage.getItem("canvas");
            if(previous!=null){
                const canvasImg = new Image();
                canvasImg.src=previous;
                canvasImg.onload =function () {
                    ctx.drawImage(canvasImg, 0, 0);
                }
            }
        }
    }
}
function getCursorPosition(canvas, event){
    const rect = canvas.getBoundingClientRect()
    const x = event.clientX - rect.left
    const y = event.clientY - rect.top
    return {x: x, y: y};
}

function submitPoint(x, y, r){
    return new Promise(function (resolve){
    const req = new XMLHttpRequest();
    req.onreadystatechange = function (){
        if(this.readyState == 4 && this.status == 200){
            resolve(this.responseText);
        }
    }
    req.open("POST","controller", false);
    req.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    const body = 'x='+x+'&y='+y+'&r='+r+'&f=false';
    req.send(body);
});}

function transformPoint(x,y){
    const r = document.getElementById("rad").value;
    if(r===undefined||r===''||r==null) {
        alert("Не задан радиус");
        return null;
    }
    const newX = (x-108.66668701171875)*(r/80);
    const newY = -(y-109)*(r/80);
    return {x:newX, y: newY, r:r};
}

function checkHit(x,y,r,response){
    const reg = '<tr><td>'+x+'</td><td>'+y+'</td><td>'+r+'</td><td>';
    const regexp1=new RegExp(reg);
    const regexp2 =/<\/td><\/tr>/;
    let index = response.search(regexp1);
    let resp = response.substr(index, response.length-index);
    index = resp.search(regexp2);
    resp =resp.substring(reg.length,index);
    return resp==="Точка входит в область";
}

function refreshTable(response){
    const begin = "<table>";
    const end = "</table>";
    let index = response.search(begin);
    let resp = response.substring(index);
    index = resp.search(end);
    resp = resp.substring(0,index+end.length+1);
    document.getElementById("table").innerHTML=resp;
}

