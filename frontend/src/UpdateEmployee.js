import React from 'react'
import { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams,useNavigate } from 'react-router-dom';


const UpdateEmployee = () => {
    let navigate = useNavigate();

    const [employeeById , setEmployeeById] = useState([]);

    useEffect(() => {
        loadEmployee();
      }, []);
    
      const { employeeId } = useParams();

      const loadEmployee = async () => {
        const result = await axios.get(`http://localhost:8080/api/employees/${employeeId}`);
        setEmployeeById(result.data);
      };

    const onfNameChange = (value) => {
        const employee =  {...employeeById,firstName : value};
        setEmployeeById(employee);
    }
    const onlNameChange = (value) => {
        const employee =  {...employeeById,lastName : value};
        setEmployeeById(employee);
    }
    const onEmailChange = (value) => {
        const employee =  {...employeeById,email : value};
        setEmployeeById(employee);
    }
    const onPassChange = (value) => {
        const employee =  {...employeeById,password : value};
        setEmployeeById(employee);
    }
    
    
    const handleSubmit = async (e) => {
    e.preventDefault();
    await axios.put(`http://localhost:8080/api/employees/${employeeId}`, employeeById);
    navigate("/listemployees");

    }
  return (
    <div className="container">
    <h1 align="center">Update Employee</h1>
    <form className="form" method="post" onSubmit={(e) => handleSubmit(e)}>
        <div className="input-box">
                  <label for="exampleInputEmail1">First Name</label>
                  <input type="text" class="form-control" value={employeeById.firstName} onChange={(e) => onfNameChange(e.target.value)}
                      placeholder="Enter First Name"></input>
        </div><div className="input-box">
                      <label>Last Name</label>
                      <input type="text" class="form-control" value={employeeById.lastName} onChange={(e) => onlNameChange(e.target.value)}
                          placeholder="Enter Last Name"></input>
                  </div>
        <div className="input-box">
            <label >Email Address</label>
            <input type="email" class="form-control" value={employeeById.email} onChange={(e) => onEmailChange(e.target.value)}
             placeholder="Enter Email Address"></input>
        </div>
        <div className="input-box">
            <label >Password</label>
            <input type="password" class="form-control" value={employeeById.password} onChange={(e) => onPassChange(e.target.value)}
             placeholder="Password"></input>
        </div>

        <button 
        type="submit">Update</button>
       
    </form>
</div>
  )
}

export default UpdateEmployee