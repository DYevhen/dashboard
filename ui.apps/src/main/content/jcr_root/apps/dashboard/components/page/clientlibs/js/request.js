let pageNum = 1;

function loadNews(){
    console.log("we are in load news");
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == XMLHttpRequest.DONE) {   // XMLHttpRequest.DONE == 4
           if (xmlhttp.status == 200) {
               console.log(xmlhttp);
               document.getElementById("add_here").innerHTML += xmlhttp.response;
           }
           else if (xmlhttp.status == 400) {
              alert('There was an error 400');
           }
           else {
               alert('something else other than 200 was returned');
           }
        }
    };
    xmlhttp.open("GET", "/content/dashboard/us/en/landing/jcr:content/root/container/gridcomponent.html?wcmmode=disabled&pageNum="+pageNum, true);
    xmlhttp.send();
    pageNum += 1;
}

window.addEventListener('scroll',()=>{
    if(window.scrollY + window.innerHeight >=
    document.documentElement.scrollHeight){
        console.log("URA!!!");
        loadNews();
    }
})