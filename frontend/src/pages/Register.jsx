import { useState } from 'react'
import {useNavigate} from "react-router-dom";

function Register() {

    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')
    const [error, setError] = useState('')

    const handleNameChange = (event) => {
        setUsername(event.target.value);
    }

    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    }

    const navigate = useNavigate()

    const handleRegister = (event) => {
        event.preventDefault();
        fetch('http://localhost:8080/api/auth/register', {
            method: "POST",
            body: JSON.stringify({
                username, password //can also do username: username, password: password but since matching skipping
            }),
            headers: {
                "Content-type": "application/json"
            }
        })
            .then (response => {
                if (response.status === 201 ){
                    response.text().then(text => {
                        setError('')
                        navigate("/successregister")
                    }
                    )
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


    //read about form validation: https://www.freecodecamp.org/news/how-to-validate-forms-in-react/
  return (
    <>
      <section>
        <div>
          <h1>Register</h1>
            <form onSubmit={handleRegister}>
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
                <p>{error}</p>
            </form>


        </div>
      </section>
    </>
  )
}

export default Register
