package component

import data.Series
import hoc.withDisplayName
import kotlinx.html.id
import react.*
import react.dom.*
import react.router.dom.navLink

interface WatchedSeriesProps : RProps {
    var series: Map<Int,Series>
}

val fWatchedSeries =
    functionalComponent<WatchedSeriesProps> {
        h2 { +"Watched series" }
        table {
            attrs.id = "table"
            tr {
                th { +"Title" }
                th { +"release Years" }
                th { +"Kinopoisk rating" }
            }
            it.series.map { series ->
                if (series.value.watched) {
                    tr {
                        td {navLink("/series/${series.key}") { +series.value.title }}
                        td { +"${series.value.releaseYears}" }
                        td { +"${series.value.kinopoisk}" }
                    }
                }
            }
        }
    }

fun RBuilder.watchedSeries(
    series: Map<Int,Series>
) = child(
    withDisplayName("Watched series", fWatchedSeries)
) {
    attrs.series = series
}