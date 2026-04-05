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
