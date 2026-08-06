import { Link } from "react-router-dom";
import "./Navbar.css";

function Navbar() {

    return (

        <nav className="navbar">

            <h2>FreelanceHub</h2>

            <div>

                <Link to="/">Home</Link>

                <Link to="/login">Login</Link>

                <Link to="/register">Register</Link>

            </div>

        </nav>

    );

}

export default Navbar;