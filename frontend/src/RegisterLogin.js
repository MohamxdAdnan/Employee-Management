import { useState } from 'react';
import './RegisterLogin.css';
import axios from "axios";
import {useNavigate} from "react-router-dom";


const RegisterLogin = () => {
    let navigate = useNavigate();
    const url = "http://localhost:8080/api/employees/create";
const [newEmployee , setEmployee] = useState({firstName : "",lastName : "",email : "",password : ""});
 const [action, setAction] = useState("Register");



// try{
//     const createEmployee = async () => {
//         const response = await ApiRequest(url ,newEmployee);
//         const respBody = await response.json();
//         console.log(respBody);
//         };

//         createEmployee();
// }catch(err){
//     console.log(err);
// }
const onfNameChange = (value) => {
    const employee =  {...newEmployee,firstName : value};
    setEmployee(employee);
}
const onlNameChange = (value) => {
    const employee =  {...newEmployee,lastName : value};
    setEmployee(employee);
}
const onEmailChange = (value) => {
    const employee =  {...newEmployee,email : value};
    setEmployee(employee);
}
const onPassChange = (value) => {
    const employee =  {...newEmployee,password : value};
    setEmployee(employee);
}





const onSubmit = async (e) => {
    e.preventDefault();
    await axios.post(url, newEmployee);
    navigate("/");
  };


  return (
    <div className="container">
    {/* <h1 align="center">{action}</h1> */}
    <h1>Register</h1>
    <form className="form" method="post" onSubmit={(e) => onSubmit(e)}>
        <div className="input-box">
                  <label for="exampleInputEmail1">First Name</label>
                  <input type="text" class="form-control" value={newEmployee.firstName} onChange={(e) => onfNameChange(e.target.value)}
                      placeholder="Enter First Name"></input>
        </div><div className="input-box">
                      <label>Last Name</label>
                      <input type="text" class="form-control" value={newEmployee.lastName} onChange={(e) => onlNameChange(e.target.value)}
                          placeholder="Enter Last Name"></input>
                  </div>
        <div className="input-box">
            <label >Email Address</label>
            <input type="email" class="form-control" value={newEmployee.email} onChange={(e) => onEmailChange(e.target.value)}
             placeholder="Enter Email Address"></input>
        </div>
        <div className="input-box">
            <label >Password</label>
            <input type="password" class="form-control" value={newEmployee.password} onChange={(e) => onPassChange(e.target.value)}
             placeholder="Password"></input>
        </div>

        <button 
        type="submit" >Register</button>
       
    </form>
</div>
  )
}

export default RegisterLogin