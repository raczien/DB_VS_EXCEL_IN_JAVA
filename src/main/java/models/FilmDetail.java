package models;

public class FilmDetail {

    public static String FILM_DETAIL_SQL = """
                select
                    f.film_id,
                	f.title,
                	f.description,
                	f.release_year,
                	c."name" as category,
                	l."name" as language,
                	f.rating
                from film f
                inner join film_category fc on fc.film_id = f.film_id
                inner join category c on c.category_id = fc.category_id
                inner join "language" l on f.language_id = l.language_id
                where f.film_id < 101
            """;

    private final long filmId;
    private final String title;
    private final String description;
    private final int releaseYear;
    private final String categoryName;
    private final String language;
    private final String rating;

    public FilmDetail(long filmId, String title, String description, int releaseYear, String categoryName, String language, String rating) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.categoryName = categoryName;
        this.language = language;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "FilmDetails{" +
                "filmId=" + filmId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", language='" + language + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
