import React from 'react'
import { Link } from 'react-router-dom'
import './NavBar.css'


const NavBar = () => {
  return (
    <nav className='Navbar'>
        <ul className='NavItems'>
            <li><h2>EMPLOYEE MANAGEMENT</h2></li>
<li><Link className="btn btn-outline-light" to="/listemployees">
            List Employees
          </Link></li>
          
          <Link className="btn btn-outline-light" to="/register">
            register
          </Link>
        </ul>
    </nav>
  )
}

export default NavBar