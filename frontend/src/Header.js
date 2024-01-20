import React from 'react'
import './Header.css'

const Header = () => {
  return (
    <div className="container">
    <nav className="navbar">
        <div>
            <a class="navbar" href="home">EMPLOYEE MANAGEMENT</a>
            <div className="mystyle">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a className="nav-link active"  href="#">Login</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
  )
}

export default Header