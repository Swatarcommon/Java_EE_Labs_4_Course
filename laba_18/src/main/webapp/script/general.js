let role;

function getRole() {
    let username ,password;
    if (document.getElementById('authUsername') != null)
        username =document.getElementById('authUsername').value;
    else
        username = 'client';
    if (document.getElementById('authPassword') != null)
        password =document.getElementById('authPassword').value;
    else
        password = 'password';
    fetch('/laba18_war/Users', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username: username,
            password: password
        })
    }).then(res => res.json()).then(res => {
        if (res) {
            if (res == "error") {
                alert("Enter correct username and password");
                role = 'client';
            }
            else if (res == "SignIn"){
                let form = `<p>Username:<input type="text" id="authUsername"></p>
                            <p>Password:<input type="text" id="authPassword"></p>
                            <p>
                            <input type="button" onclick="getRole()" value="Sign In">
                            <input type="button" onclick="clearContent('form')" value="Cancel">
                            </p>`
                            document.getElementById("form").innerHTML = form;
            }
            else {
                role = res;
                clearContent('form');
            }
            visibilityButtons();
        }
    })
}

function SignOut() {
    fetch('/laba18_war/Users', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username: 'reset',
            password: 'reset'
        })
    }).then(res => res.json()).then(res => {
        if (res) {
            role = res;
            visibilityButtons();
        }
    })
}

function visibilityButtons() {
    let buttons = `<input type="button" value="filter" onclick="visibilityFilterForm()">`;
    if (role == 'admin')
        buttons += `<input type="button" value="insert" onclick="visibilityInsertForm()">
                    <input type="button" value="sign out" onclick="SignOut()">`
    document.getElementById('buttons').innerHTML = buttons;
    getReferences();
}

function visibilityInsertForm() {
    let form = `<p>Url:<input type="text" id="url"></p>
            <p>Description:<input type="text" id="description"></p>
            <p>
                <input type="button" onclick="addReference()" value="Add Reference">
                <input type="button" onclick="clearContent('form')" value="Cancel">
            </p>`
    document.getElementById("form").innerHTML = form;
}

function visibilityCommentsInsertForm(id) {
    let needId = "insertComment"+id;
    let form = `<p>Comment:<input type="text" id="comment"></p>
                <p>
                    <input type="button" onclick="addComment(${id})" value="Add comment">
                    <input type="button" value="Cancel" onclick="clearContent('insertComment${id}')">
                </p>`
    document.getElementById(needId).innerHTML = form;
}

function visibilityFilterForm() {
    let form = `<p>Description:<input type="text" id="filterDescription"></p>
                <p>
                    <input type="button" onclick="getReferences()" value="Filter">
                    <input type="button" onclick="clearContent('form')" value="Cancel">
                </p>`
    document.getElementById("form").innerHTML = form;
}

function updateContentVisibility(id,url,description) {
    let form = `<table>
                    <tr><td>
                        <p>Url:<input type="text" id="editUrl" value="${url}" ></p>
                        <p>Description:<input type="text" id="editDescription" value="${description}"></p>
                        <p>
                            <input type="button" onclick="updateReference(${id})" value="Update Reference">
                            <input type="button" value="Cancel" onclick="clearContent(${id})">
                        </p>
                    </td></tr>
            </table>`
    document.getElementById(id).innerHTML = form;
}

function deleteContentVisibility(id) {
    let attention = `<table>
                        <tr><td>
                            You sure to delete reference with id ${id} 
                            <input type="button" value="Yes" onclick="deleteReference(${id})">
                            <input type="button" value="Cancel" onclick="clearContent(${id})">
                        </td></tr>
                     </table>`;
    document.getElementById(id).innerHTML = attention;
}

function clearContent(id) {
    document.getElementById(id).innerHTML = "";
}

