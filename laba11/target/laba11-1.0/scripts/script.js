function crReq ()
{
    let req = null;
    if (window.XMLHttpRequest)
    {
        req = new XMLHttpRequest();
        //req = window.XMLHttpRequest;
    }
    else if (window.ActiveXObject)
    {
        try{
            req = new ActiveXObject("Msxml2.XMLHTTP");
        }catch(e){
            try{
                req = new ActiveXObject("Microsoft.XMLHTTP");
            }catch(e){
                req = null;
            }
        }
    }
    return req;
}
function JsonPost() {
    let req  = new XMLHttpRequest();
    // if (req){
    //     req.open("POST","/laba11/GoSssJson",false);
    //     req.onreadystatechange = function () {
    //         if (req.readyState == 4){
    //             if (req.status == 200){
    //                 let  res = eval('('+req.responseText+')');
    //                 let str = "";
    //                 for (var i = 0; i < res.Numbers.length; i++){
    //                     str += (res.Numbers[i].rand +" ");
    //                 }
    //                 document.getElementById("json").innerHTML = str;
    //             }
    //             else alert("status = "+ req.statusText);
    //         }
    //     }
    //     req.setRequestHeader("XRand-N", nj.value);
    //     req.send("null");
    // }
    // else
    //     alert("error");
    fetch('/laba11/GoSssJson', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'XRand-N' : document.getElementById("nj").value,
        }
    }).then(response=> response.json())
        .then(res=>{
            let str = "";
            for (let i = 0; i < res.Numbers.length; i++){
                str += res.Numbers[i].rand+" ";
            }
            document.getElementById("json").innerHTML = str;
        }).catch((err) => console.log(`Fetch ERROR by ${LINK}: ${err}`));
}
function XmlPost() {
    let req = new XMLHttpRequest();
    // if (req){
    //     req.open("POST","/laba11/GoSssXml",false);
    //     req.onreadystatechange = function () {
    //         if (req.readyState == 4){
    //             if (req.status == 200){
    //                 let xmldoc = req.responseXML;
    //                 let  tsnum = xmldoc.getElementsByTagName("num");
    //                 let str = "";
    //                 for (let i = 0; i < tsnum.length; i++){
    //                     str += tsnum[i].textContent+" ";
    //                 }
    //                 document.getElementById("xml").innerHTML = str;
    //             }
    //             else alert("status = "+ req.statusText);
    //         }
    //     }
    //     req.setRequestHeader("XRand-N", n.value);
    //     req.send("null");
    // }
    // else
    //     alert("error");
    fetch('/laba11/GoSssXml', {
        method: 'POST',
        headers: {
            'Content-Type': 'text/xml',
            'XRand-N' : document.getElementById("n").value,
        }
    }).then(response=> response.text())
        .then(textResponse=>{
            let parser = new DOMParser();
            let numbers = parser.parseFromString(textResponse,"text/xml").getElementsByTagName("num");
            let str = "";
            for (let i = 0; i < numbers.length; i++){
                str += numbers[i].textContent+" ";
            }
            document.getElementById("xml").innerHTML = str;
        })
        .catch((err) => console.log(`Fetch ERROR by ${LINK}: ${err}`));
}
function Post() {
    let req  = new XMLHttpRequest();
    // if (req){
    //     req.open("POST","/laba11/GoSssHeader",false);
    //     req.onreadystatechange = function () {
    //         if (req.readyState == 4){
    //             if (req.status == 200)
    //                 document.getElementById('z').value = req.getResponseHeader("Value-z");
    //             else alert("status = "+ req.statusText);
    //         }
    //     }
    //     req.setRequestHeader("Value-X", x.value);
    //     req.setRequestHeader("Value-Y", y.value);
    //     req.send("null");
    // }
    // else
    //     alert("error");
    fetch('/laba11/GoSssHeader', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Value-x' : document.getElementById("x").value,
            'Value-y' : document.getElementById("y").value
        }
    }).then(response => {
        document.getElementById('z').value = response.headers.get("Value-z");
    }).catch((err) => console.log(`Fetch ERROR by ${LINK}: ${err}`));
}