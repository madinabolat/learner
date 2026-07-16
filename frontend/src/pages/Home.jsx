import { useNavigate } from 'react-router-dom'

function Home () {
    const navigate = useNavigate()
    return (
        <>
            <section>
                <div>
                    <h1>Welcome to Learner</h1>
                </div>
                <button onClick={() => navigate("/register")}>
                    Register
                </button>
                <button onClick={() => navigate("/login")}>
                    Log In
                </button>
            </section>
        </>
    )
}

export default Home
