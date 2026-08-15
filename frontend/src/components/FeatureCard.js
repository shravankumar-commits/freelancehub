import "./FeatureCard.css";

function FeatureCard() {
    return (
        <section className="features">

            <h2>Why Choose FreelanceHub?</h2>

            <div className="feature-container">

                <div className="feature-card">
                    <h3>Find Skilled Talent</h3>
                    <p>
                        Connect with skilled freelancers who can
                        help complete your projects.
                    </p>
                </div>

                <div className="feature-card">
                    <h3>Find Freelance Work</h3>
                    <p>
                        Discover projects and opportunities that
                        match your skills.
                    </p>
                </div>

                <div className="feature-card">
                    <h3>Simple & Secure</h3>
                    <p>
                        A simple platform designed to connect
                        clients and freelancers.
                    </p>
                </div>

            </div>

        </section>
    );
}

export default FeatureCard;