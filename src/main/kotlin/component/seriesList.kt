package component

import data.Series
import data.genre
import react.*
import org.w3c.dom.events.Event
import kotlinx.html.InputType
import kotlinx.html.id
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLSelectElement
import react.dom.*
import kotlin.browser.document

interface SeriesListProps : RProps {
    var series: Array<Series>
    var genres: Array<genre>
    var add: (Event) -> Unit
}

val fSeriesList =
    functionalComponent<SeriesListProps> {
        val (genre, currentGenre) = useState("Anime")
        h2 { +"TV series" }
        button(classes = "btn") {
            +"Add series "
            attrs.onClickFunction = {
                val addWindow = document.getElementById("addWindow") as HTMLElement
                addWindow.style.display = "block"
            }
        }
        select {
            for (element in it.genres) {
                attrs.id = "genre"
                option {
                    +element.title
                }
                attrs.onChangeFunction = {
                    val genres = document.getElementById("genre") as HTMLSelectElement
                    currentGenre(genres.value)
                }
            }
        }
        table {
            attrs.id = "table"
            tr {
                th { +"Title" }
                th { +"Release Years" }
                th { +"Age rating" }
                th { +"Kinopoisk rating" }
            }
            it.series.mapIndexed { index, series ->
                if (series.genre == genre) {
                    series(series ,index)
                }
            }
        }
        div("window") {
            attrs.id = "addWindow"
            div("window-content") {
                h1("window-h1") { +"Add series" }
                ul {
                    li {
                        +"Title"
                        input(InputType.text) {
                            attrs.id = "Title"
                        }
                    }
                    li {
                        +"Genre"
                        select {
                            for (element in it.genres) {
                                attrs.id = "Genre"
                                option {
                                    +element.title
                                }
                            }
                        }
                    }
                    li {
                        +"Release years"
                        input(InputType.text) {
                            attrs.id = "ReleaseYears"
                        }
                    }
                    li {
                        +"Tagline"
                        input(InputType.text) {
                            attrs.id = "Tagline"
                        }
                    }
                    li {
                        +"Logo (url of picture)"
                        input(InputType.text) {
                            attrs.id = "Logo"
                        }
                    }
                    li {
                        +"Age_rating"
                        input(InputType.text) {
                            attrs.id = "Age_rating"
                        }
                    }
                    li{
                        +"Kinopoisk rating"
                        input(InputType.text){
                            attrs.id = "Kinopoisk"
                        }
                    }
                    button(classes = "submit-btn") {
                        +"Add"
                        attrs.onClickFunction = it.add
                    }
                    button(classes = "submit-btn") {
                        +"Close"
                            attrs.onClickFunction = {
                            val title = document.getElementById("Title") as HTMLInputElement
                            title.value=""
                            val releaseYears = document.getElementById("ReleaseYears") as HTMLInputElement
                            releaseYears.value=""
                            val addWindow = document.getElementById("addWindow") as HTMLElement
                            addWindow.style.display = "none"
                            val logo = document.getElementById("Logo") as HTMLInputElement
                            logo.value=""
                            val genres = document.getElementById("Genre") as HTMLSelectElement
                            genres.value=""
                            val tagline = document.getElementById("Tagline") as HTMLInputElement
                            tagline.value=""
                            val age_rating = document.getElementById("Age_rating") as HTMLInputElement
                            age_rating.value=""
                            val kinopoisk = document.getElementById("Kinopoisk") as HTMLInputElement
                            kinopoisk.value = ""

                        }
                    }
                }
            }
        }
    }
