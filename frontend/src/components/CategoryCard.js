import "./CategoryCard.css";
function CategoryCard() {
    return (
        <section className="categories">
            <h3>Popular Categories</h3>

            <div className="category-container">

                <div className="category-card">
                    <h3>Java Development</h3>
                    <p>Find skilled Java developers for your projects.</p>
                </div>

                <div className="category-card">
                    <h3>Web Development</h3>
                    <p>Build modern and responsive websites.</p>
                </div>

                <div className="category-card">
                    <h3>Database</h3>
                    <p>Get help with MySQL and database projects.</p>
                </div>

                <div className="category-card">
                    <h3>UI / UX Design</h3>
                    <p>Create attractive and user-friendly designs.</p>
                </div>

            </div>
        </section>
    );
}

export default CategoryCard;