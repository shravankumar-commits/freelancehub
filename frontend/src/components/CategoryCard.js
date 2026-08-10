function CategoryCard({ title, description }) {
    return (
        <div className="category-card">

            <h3>{title}</h3>

            <p>{description}</p>

        </div>
    );
}

export default CategoryCard;