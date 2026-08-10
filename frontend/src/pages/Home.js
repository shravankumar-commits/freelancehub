import { useNavigate } from "react-router-dom";

function Home() {

    const navigate = useNavigate();
    const name = localStorage.getItem("name");
    const email = localStorage.getItem("email");
    const role = localStorage.getItem("role");
    
    const handleLogout = () => {
    localStorage.removeItem("token");
    localStorage.removeItem("name");
    localStorage.removeItem("email");
    localStorage.removeItem("role");

    navigate("/login");
};
    return (
        
        <div>

            <h1>Welcome, {name}!</h1>

            <p>Email: {email}</p>

            <p>Role: {role}</p>

            <button onClick={handleLogout}>
                Logout
            </button>
        </div>
        
    );
}

export default Home;