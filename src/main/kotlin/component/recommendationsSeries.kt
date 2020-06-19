package component

import data.Series
import hoc.withDisplayName
import kotlinx.html.id
import react.*
import react.dom.*
import react.router.dom.navLink

interface RecommendationsSeriesProps : RProps {
    var series: Map<Int,Series>
}

val fRecommendationsSeries =
    functionalComponent<RecommendationsSeriesProps> {
        h2 { +"Recommendations series" }
        table {
            attrs.id = "table"
            tr {
                th { +"Title" }
                th { +"release Years" }
                th { +"Kinopoisk rating" }
            }
            it.series.map { series ->
                if (series.value.recommendation) {
                    tr {
                        td {navLink("/series/${series.key}") { +series.value.title }}
                        td { +"${series.value.releaseYears}" }
                        td { +"${series.value.kinopoisk}" }
                    }
                }
            }
        }
    }

fun RBuilder.recommendationsSeries(
    series: Map<Int,Series>
) = child(
    withDisplayName("Recommendations series", fRecommendationsSeries)
) {
    attrs.series = series
}