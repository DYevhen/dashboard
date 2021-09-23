let pageNum = 10;
let itemsPerPage = 6;
let isSend = false;

function loadNews(){
    isSend = true;
    console.log("we are in load news");
    var xmlhttp = new XMLHttpRequest();
    let param = new URLSearchParams(window.location.search);
    let searchText = param.get("searchText");
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == XMLHttpRequest.DONE) {   // XMLHttpRequest.DONE == 4
           if (xmlhttp.status == 200) {
               console.log(xmlhttp);
               document.getElementById("add_here").innerHTML += xmlhttp.response;
               isSend = false;
           }
           else if (xmlhttp.status == 400) {
              alert('There was an error 400');
           }
           else {
               alert('something else other than 200 was returned');
           }
        }
    };
    xmlhttp.open("GET", "/content/dashboard/us/en/landing/jcr:content/root/container/gridcomponent.html?wcmmode=disabled&pageNum="+pageNum+
                 "&itemsPerPage="+itemsPerPage+"&searchText="+searchText, true);
    xmlhttp.send();
    pageNum += 6;
}

window.addEventListener('scroll',()=>{
    if(window.scrollY + window.innerHeight >=
    document.documentElement.scrollHeight-10 && !isSend){
        console.log("URA!!!");
        loadNews();
    }
})