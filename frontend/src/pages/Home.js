import { useNavigate } from "react-router-dom";

import Hero from "../components/Hero";
import CategoryCard from "../components/CategoryCard";
import FeatureCard from "../components/FeatureCard";
import Footer from "../components/Footer";

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

            <Hero />

            <div className="welcome-section">
    <h2>Welcome, {name}!</h2>

    <p>Email: {email}</p>

    <p>Role: {role}</p>

    <button onClick={handleLogout}>
        Logout
    </button>
</div>
           <section className="categories">
    <h2>Popular Categories</h2>

    <div className="category-container">
        <CategoryCard />
    </div>
</section>

<section className="features">
    <h2>Why Choose FreelanceHub?</h2>

    <div className="feature-container">
        <FeatureCard />
    </div>
</section>

<Footer />

        </div>
    );
}

export default Home;