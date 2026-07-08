import {useState} from "react";
import {useNavigate} from "react-router-dom";

function Login() {


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

  const handleLogin = (event) => {
    event.preventDefault();
    fetch('http://localhost:8080/api/auth/login', {
      method: "POST",
      body: JSON.stringify({
        username, password
      }),
      headers: {
        "Content-type": "application/json"
      }
    })
        .then (response => {
          if (response.status === 202 ){
            response.text().then(text => {
                  setError('')
                  localStorage.setItem("token", text)
              //TO DO: token is not being saved
                  navigate("/chat")
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


  return (
      <>
        <section>
          <div>
            <h1>LogIn</h1>
            <form onSubmit={handleLogin}>
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

export default Login
