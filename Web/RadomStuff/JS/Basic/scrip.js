// const today = new Date();
//     const day = today.getDay();
//     const daylist = ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];
//     console.log("Today is : " + daylist[day] + ".");
//     let hour = today.getHours();
//     const minute = today.getMinutes();
//     const second = today.getSeconds();

//     let prepand = (hour>=12) ? "PM" : "AM";
//     hour = (hour>=12) ? hour - 12 : hour;
//     if(hour==0&&prepand=='PM'){
//         if(minute==0&&second==0){
//             hour='12'
//             prepand = 'Noon';
//         }
//         else{
//             prepand='PM';
//             hour=12;
//         }
//     }
//     if(hour==0&&prepand=='AM'){
//         if(minute==0&&second==0){
//             hour=12;
//             prepand='Midnight';
//         }
//         else{
//             hour=12;
//             prepand='AM';
//         }
//     }
function clock(){
    let h=document.getElementById('hour');
    let mn=document.getElementById('minute');
    let s=document.getElementById('second');
    var hour = new Date().getHours();
    var minute = new Date().getMinutes();
    var second = new Date().getSeconds();
    h.innerHTML = hour;
    mn.innerHTML= minute;
    s.innerHTML= second;
}
var interval = setInterval(clock,1000);