import './App.css';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import ListEmployees from './ListEmployees';
import RegisterLogin from './RegisterLogin';
import NavBar from './NavBar';
import UpdateEmployee from './UpdateEmployee';

function App() {
  return (
    <div className="App">
     
     <Router>
        <NavBar />

        <Routes>
          <Route exact path="/login" element={<RegisterLogin  />} />
          <Route exact path="/register" element={<RegisterLogin  />} />
          <Route exact path="/update/:employeeId" element={<UpdateEmployee  />} />
          <Route exact path="/listemployees" element={<ListEmployees/>} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
