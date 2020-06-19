package data

class State(
    val series: Map<Int, Series>,
    val genre: Map<Int, genre>
)

fun <T> Map<Int, T>.newId() =
    (this.maxBy { it.key }?.key ?: 0) +1

fun initialState() =
    State(
        seriesList().mapIndexed{ index, series ->
            index to series
        }.toMap(),
        genreList().mapIndexed{ index, genre ->
            index to genre
        }.toMap()
    )


