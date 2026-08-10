import { useState } from "react";
import "./Register.css";

function Register() {

    const [name, setName] = useState("");
    const [role, setRole] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const handleSubmit = async (event) => {
        event.preventDefault();

        const user = {
            name: name,
            role: role,
            email: email,
            password: password
        };

        try {

            const response = await fetch("http://localhost:8080/register", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(user)
            });

            const data = await response.json();

            console.log("Registration successful:", data);

        } catch (error) {

            console.error("Registration failed:", error);

        }
    };

    return (
        <div className="register-page">

            <h1>Create Your Account</h1>

            <form onSubmit={handleSubmit}>

                <input
                    type="text"
                    placeholder="Full Name"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                />

                <input
                    type="text"
                    placeholder="Role"
                    value={role}
                    onChange={(e) => setRole(e.target.value)}
                />

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
                    Register
                </button>

            </form>

        </div>
    );
}

export default Register;