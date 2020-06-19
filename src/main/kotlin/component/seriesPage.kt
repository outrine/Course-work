package component

import data.Series
import data.genre
import react.*
import kotlinx.html.InputType
import kotlinx.html.id
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLElement
import org.w3c.dom.events.Event
import react.dom.*
import kotlin.browser.document
import kotlin.browser.window

interface SeriesPageProps : RProps {
    var index: Int
    var series: Array<Series>
    var genres: Array<genre>
    var add: (Int) -> (Event) -> (Unit)
    var delete: (Int) -> Unit
    var edit: (Int) -> Unit
}

val fSeriesPage =
    functionalComponent<SeriesPageProps> { props ->
        div("card") {
            img(classes = "pic") {
                attrs.src = props.series[props.index].logo
                attrs.alt = "Wrong url to picture"
            }
            div("container") {
                h4 { +props.series[props.index].title }
                p { +"Genre: ${props.series[props.index].genre}" }
                p { +"Release years: ${props.series[props.index].releaseYears}" }
                p { +"Tagline rating: ${props.series[props.index].tagline}" }
                p { +"Age rating rating: ${props.series[props.index].age_rating}+" }
                p { +"Kinopoisk rating: ${props.series[props.index].kinopoisk} out of 10" }
                if (!props.series[props.index].watched) {
                    button(classes = "btn") {
                        +"Add to Watched list"
                        attrs.onClickFunction = props.add(props.index)
                    }
                } else {
                    p { +"You Watched it" }
                }
                p {
                    button(classes = "btn") {
                        +"Delete"
                        attrs.onClickFunction = {
                            props.delete(props.index)
                            window.history.back()
                        }
                    }
                }
                p{
                    button(classes = "btn") {
                        +"Edit"
                        attrs.onClickFunction = {
                            val editWindow = document
                                .getElementById("editWindow") as HTMLElement
                            editWindow.style.display = "block"
                        }
                    }
                }
            }
        }
        div("window") {
            attrs.id = "editWindow"
            div("window-content") {
                h1("window-h1") { +"Edit series" }
                ul {
                    li {
                        +"Title"
                        input(InputType.text) {
                            attrs.id = "eTitle"
                            attrs.defaultValue = props.series[props.index].title
                            attrs.placeholder = props.series[props.index].title
                        }
                    }
                    li {
                        +"Genre"
                        select {
                            for (element in props.genres) {
                                attrs.id = "eGenre"
                                option {
                                    +element.title
                                }
                            }
                        }
                    }
                    li {
                        +"Release years"
                        input(InputType.text) {
                            attrs.id = "eReleaseYears"
                            attrs.defaultValue = props.series[props.index].releaseYears.toString()
                            attrs.placeholder = props.series[props.index].releaseYears.toString()
                        }
                    }
                    li {
                        +"tagline"
                        input(InputType.text) {
                            attrs.id = "eTagline"
                            attrs.placeholder = props.series[props.index].tagline
                            attrs.defaultValue = props.series[props.index].tagline
                        }
                    }
                    li {
                        +"Logo (link of picture)"
                        input(InputType.text) {
                            attrs.id = "eLogo"
                            attrs.defaultValue = props.series[props.index].logo
                            attrs.placeholder = props.series[props.index].logo
                        }
                    }
                    li {
                        +"age_rating"
                        input(InputType.text) {
                            attrs.id = "eAge_rating"
                            attrs.placeholder = props.series[props.index].age_rating.toString()
                            attrs.defaultValue = props.series[props.index].age_rating.toString()
                        }
                    }
                    li {
                        +"Kinopoisk rating"
                        input(InputType.text) {
                            attrs.id = "eKinopoisk"
                            attrs.placeholder = props.series[props.index].kinopoisk.toString()
                            attrs.defaultValue = props.series[props.index].kinopoisk.toString()
                        }
                    }
                    button(classes = "submit-btn"){
                        +"Edit"
                        attrs.onClickFunction = {props.edit(props.index)}
                    }
                    button(classes = "submit-btn"){
                        +"Close"
                        attrs.onClickFunction = {
                            val editWindow = document
                                .getElementById("editWindow") as HTMLElement
                            editWindow.style.display = "none"
                        }
                    }
                }
            }
        }
    }
