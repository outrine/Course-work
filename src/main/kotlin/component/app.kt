package component

import container.SeriesPageContainer
import container.genreContainer
import container.seriesListContainer
import data.Series
import data.genre
import react.*
import react.dom.*
import react.router.dom.*

interface AppProps : RProps {
    var series: Map<Int, Series>
    var genres: Map<Int, genre>
}

interface RouteNumberResult : RProps {
    var number: String
}

fun fApp() =
    functionalComponent<AppProps> { props ->
        div("home") {
            div {
                ul {
                    li { navLink("/series") { +"TV shows" } }
                    li { navLink("/genres") { +"Genres" } }
                    li { navLink("/watched") { +"Watched TV shows" } }
                    li { navLink("/recommendations") { +"Recommendations" } }
                }
            }
        }
        switch {
            route("/series",
                exact = true,
                render = { seriesListContainer{} }
            )
            route("/series/:number",
                exact = true,
                render = renderObject(
                    { props.series[it] },
                    { index, _ ->
                        SeriesPageContainer {
                            attrs.index = index

                        }
                    }
                )
            )
            route("/watched",
                exact = true,
                render = { watchedSeries(props.series) }
            )
            route("/genres",
                exact = true,
                render = { genreContainer{}}
            )

            route("/recommendations",
                exact = true,
                render = { recommendationsSeries(props.series) }
            )
        }
    }

fun <O> RBuilder.renderObject(
    selector: (Int) -> O?,
    rElement: (Int, O) -> ReactElement
) =
    { route_props: RouteResultProps<RouteNumberResult> ->
        val num = route_props.match.params.number.toIntOrNull() ?: -1
        val obj = selector(num)
        if (obj != null) {
            rElement(num, obj)
        } else
            p { +"Object not found" }
    }

