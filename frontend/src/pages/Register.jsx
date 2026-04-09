import { useState } from 'react'

function Register() {

    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')

    const handleNameChange = (event) => {
        setUsername(event.target.value);
    }

    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        fetch('http://localhost:8080/api/auth/register', {
            method: "POST",
            body: JSON.stringify({
                username, password //can also do username: username, password: password but since matchign skipping
            }),
            headers: {
                "Content-type": "application/json"
            }
        })
            .then(response => response.text())
            .then(json => console.log(json))
            .catch(error => console.error('Error:', error));
    }

  return (
    <>
      <section>
        <div>
          <h1>Register</h1>
            <form onSubmit={handleSubmit}>
                <label>
                    username
                    <input
                        type="text"
                        value={username}
                        onChange={handleNameChange}
                    />
                </label>
                <label>
                    password
                    <input
                        type="password"
                        value={password}
                        onChange={handlePasswordChange}
                    />
                </label>
                <button type="submit">Submit</button>
            </form>


        </div>
      </section>
    </>
  )
}

export default Register
