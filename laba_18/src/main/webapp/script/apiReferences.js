let sessionId;

function getReferences() {
    let url;
    document.getElementById("references").innerHTML = "";
    if (document.getElementById("filterDescription") == null)
        url = '/laba18_war/References';
    else
        url = '/laba18_war/References?filter='+ document.getElementById("filterDescription").value;

    fetch(url, {
        method: 'GET'
    }).then(res => {
        sessionId = res.headers.get('sessionId');
        return res.json();
    }).then(res => {
        if (res) {
            res.forEach(element =>{
                let reference = `<table><tr><td>`;
                if(role == "admin")
                    reference +=`<input type="button" value="delete" onclick="deleteContentVisibility(${element.id})">
                                 <input type="button" value="update" onclick="updateContentVisibility('${element.id}','${element.url}','${element.description}')">`
                reference +=`<input type="button" value="+${element.plus}" onclick="updateReference('${element.id}','plus', '${element.plus}')">
                             <input type="button" value="-${element.minus}" onclick="updateReference('${element.id}','minus', '${element.minus}')">
                             <input type="button" value="comments" onclick="getCommentForReference(${element.id})">
                             [${element.id}]
                             <a href="${element.url}">${element.description}</a>
                             </td></tr>
                             <tr><td id="${element.id}">
                             </td></tr>
                </table><br>`
                document.getElementById("references").innerHTML += reference;
            })
        }
    })
}

function addReference() {
    if (document.getElementById('url').value != "" && document.getElementById('description').value != "")
        fetch('/laba18_war/References', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                url: document.getElementById('url').value,
                description: document.getElementById('description').value
            })
        }).then(()=>{
            clearContent("form")
            getReferences();
        })
    else
        alert('Input fields must be filled')
}

function updateReference(id, recent, value) {
    let plus = -1;
    let minus = -1;
    let url, description;

    if (recent == "plus")
        plus = value;
    else if (recent == "minus")
        minus = value;
    if (document.getElementById('editUrl') != null)
        url = document.getElementById('editUrl').value;
    if (document.getElementById('editDescription') != null)
        description =  document.getElementById('editDescription').value;
    fetch('/laba18_war/References', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id: id, url: url, description: description, plus : plus, minus: minus
        })
    }).then(()=>{
        getReferences();
    })
}

function deleteReference(id) {
    fetch('/laba18_war/References?id='+id,{
        method : 'DELETE'
    }).then(()=>{
        getReferences();
    })
}