function Chat () {


    const handleChat = (event) => {
        event.preventDefault();
        fetch('http://localhost:8080/api/chat', {
            method: "POST",
            body: JSON.stringify({
            }),
            headers: {
                "Content-type": "application/json"
            }
        })
    }


    return (
        <>
            <section>
                <div>
                    <h1>Let's chat</h1>
                </div>
                <form onSubmit={handleChat}>
                    <label>
                        chat
                    </label>
                </form>
            </section>
        </>
    )
}

export default Chat
