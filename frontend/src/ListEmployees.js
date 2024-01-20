import React, { useEffect } from 'react'
import './ListEmployees.css'
import { useState } from 'react';
import axios from 'axios';
import {Link} from 'react-router-dom';
import { getAllEmployees } from './getEmployees';

const ListEmployees = () => {

    const url = "http://localhost:8080/api/employees";

    const [data, setData] = useState([]);
    const deleteEmployee= async (employeeId) =>{
        await axios.delete(`http://localhost:8080/api/employees/${employeeId}`);
        fetchData();
    }
    const fetchData = ()=>{
        getAllEmployees().then(
            (res)=>{
                setData(...data,res);
            })
    }
   useEffect(()=>{fetchData()},[]);
    console.log(data);

  return (
    <div className="Container">
    <h1>Employee List</h1>
    <a>
        <button><Link
                    className="btn btn-primary mx-2"
                    to={`/register`}>
                    Add Employee
                  </Link></button>
    </a>

    <table className="table">
        <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email id</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
            {!data &&  <p>No Data To Display</p>}
        
            {data &&
                            data.map(
                                employee =>(
                                    <tr key={employee.id}>
                                        <td>{employee.firstName}</td>
                                            <td>{employee.lastName}</td>
                                            <td>{employee.email}</td>
                                            <td>
                <button><Link
                    to={`/update/${employee.id}`}>
                    Update
                  </Link></button>
                <button onClick={()=>deleteEmployee(employee.id)}>Delete</button>
            </td>
                                    </tr>
                                ))
                        }
            
        
        </tbody>
    </table>
</div>
  )
}

export default ListEmployees