import { useState } from "react";
import "./Login.css";

import { useNavigate } from "react-router-dom";

function Login() {

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    const handleSubmit = async (event) => {
        event.preventDefault();

        const loginData = {
            email: email,
            password: password
        };

        try {
            const response = await fetch("http://localhost:8080/login", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(loginData)
            });

            const data = await response.json();

          localStorage.setItem("token", data.token);
          localStorage.setItem("name", data.name);
          localStorage.setItem("email", data.email);
          localStorage.setItem("role", data.role);
          console.log("Login successful:", data);
          navigate("/");

        } catch (error) {
            console.error("Login failed:", error);
        }
    };

    return (
        <div className="login-page">

            <h1>Login</h1>

            <form onSubmit={handleSubmit}>

                <input
                    type="email"
                    placeholder="Email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                />

                <input
                    type="password"
                    placeholder="Password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />

                <button type="submit">
                    Login
                </button>

            </form>

        </div>
    );
}

export default Login;