package component

import data.Series
import react.*
import hoc.withDisplayName
import react.dom.*
import react.router.dom.navLink

interface SeriesProps : RProps {
    var series : Series
    var index: Int
}

val fSeries =
    functionalComponent<SeriesProps> {
        tr {
            td {  navLink("/series/${it.index}") {+it.series.title } }
            td { +"${it.series.releaseYears}" }
            td { +"${it.series.age_rating }"}
            td { +"${it.series.kinopoisk }"}
        }
    }

fun RBuilder.series(
    series : Series,
    index: Int
) = child(
    withDisplayName("series ", fSeries )
) {
    attrs.series  = series
    attrs.index = index
}