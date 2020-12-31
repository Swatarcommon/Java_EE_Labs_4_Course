var socket = null;

function startWS() {
    if (socket !== null) {
        return;
    }

    socket = new WebSocket('ws://localhost:8081/Lab16/ws');
    socket.onopen = () => {
        console.log('Socket has been opened');
        document.getElementById('response-div').innerText = '';
        socket.send('connection');
    };

    socket.onclose = (s) => {
        console.log('Socket has been closed', s);
    };

    socket.onmessage = message => {
        let responseDiv = document.getElementById('response-div');
        responseDiv.innerHTML = `${responseDiv.innerHTML}<br> ${message.data}`;
        console.log('Received message:', message);
    };
}

function stopWs() {
    socket.close();
    socket = null;
    console.log('Socket has been closed');
}