package data

data class genre(
    val title: String
)

fun genreList() =
    arrayOf(
        genre("Anime"),
        genre("Biographical film"),
        genre("Action film"),
        genre("Western"),
        genre("War film"),
        genre("Documentary"),
        genre("Drama"),
        genre("Historical film"),
        genre("Comedy"),
        genre("Short film"),
        genre("Music film"),
        genre("Cartoon"),
        genre("Sci-fi"),
        genre("Adventure"),
        genre("Family Film"),
        genre("Sports movie"),
        genre("TV show"),
        genre("Thriller"),
        genre("Horror"),
        genre("Fantasy")
    )