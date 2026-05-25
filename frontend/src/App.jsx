import './App.css'
import { BrowserRouter, Routes, Route} from 'react-router-dom'
import Home from './pages/Home'
import Register from './pages/Register'
import SuccessRegister from "./pages/SuccessRegister.jsx";

function App() {

  return (
      <BrowserRouter>
        <Routes>
          <Route index element={<Home />} />
          <Route path="/home" element={<Home />} />
          <Route path="/register" element={<Register />} />
          <Route path="/successregister" element={<SuccessRegister />} />
        </Routes>
      </BrowserRouter>
  )
}

export default App
