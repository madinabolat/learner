import {useState} from "react";

function Chat () {

    const [message, setMessage] = useState("")
    const [messages, setMessages] = useState([])
    const [error, setError] = useState('')

    const handleChat = (event) => {
        event.preventDefault();
        console.log("handleChat called")
        fetch('http://localhost:8080/api/chat', {
            method: "POST",
            body: JSON.stringify({message}),
            headers: {
                "Content-type": "application/json",
                "Authorization": "Bearer " + localStorage.getItem("token")
            }
        }).then (response => {
            if (response.status === 200 ){
                response.text().then(text => {
                    setMessages([...messages, message, text])
                    setMessage("")
                })
            }
            else {
                response.text().then(text => {
                        setError(text)
                    }
                )
            }
        })
            .catch(error => console.error('Error:', error));
    }


    return (
        <>
            <section>
                <div className="message-history">
                    {messages.map((msg, index) => <p key ={index}>{msg}</p>)}
                </div>

                <textarea value={message} onChange={(e) => setMessage(e.target.value)}/>

                <button onClick={handleChat}>Send</button>

            </section>
        </>
    )
}

export default Chat
