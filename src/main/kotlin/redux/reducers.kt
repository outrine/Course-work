package redux

import data.State
import data.*
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLSelectElement
import kotlin.browser.document

fun editReducer(state: State, action: RAction) =
    when(action) {
        is EditSeries ->{
            val editWindow = document.getElementById("editWindow") as HTMLElement
            val title = document.getElementById("eTitle") as HTMLInputElement
            val logo = document.getElementById("eLogo") as HTMLInputElement
            val genre = document.getElementById("eGenre") as HTMLSelectElement
            val releaseYears = document.getElementById("eReleaseYears") as HTMLInputElement
            val tagline = document.getElementById("eTagline") as HTMLInputElement
            val age_rating = document.getElementById("eAge_rating") as HTMLInputElement
            val kinopoisk = document.getElementById("eKinopoisk") as HTMLInputElement
            val editSeries = Series(
                if(title.value == "") "no name" else title.value,
                if(logo.value == "") "no logo" else logo.value,
                genre.value,
                if(releaseYears.value =="") 0 else releaseYears.value.toInt(),
                if (tagline.value == "") "no name" else tagline.value,
                if(age_rating.value =="") 0 else age_rating.value.toInt(),
                if(kinopoisk.value =="") 0 else kinopoisk.value.toInt(),
                false, false
            )
            editWindow.style.display ="none"
            State(
                state.series.toMutableMap()
                    .apply { this[action.id] = editSeries },
                state.genre
            )
        }
        is EditGenre -> {
            val editWindow = document.getElementById("editWindow") as HTMLElement
            val eGenre = document.getElementById("eGenre") as HTMLInputElement
            val editGenre = genre(eGenre.value)
            editWindow.style.display = "none"
            eGenre.value=""
            State(
                state.series,
                state.genre.toMutableMap()
                    .apply { this[action.id] = editGenre }
            )
        }
        else -> state
    }

fun deleteReducer(state: State, action: RAction) =
    when (action) {
        is DeleteSeries -> State(
            state.series.minus(action.id),
            state.genre
        )
        is DeleteGenre -> State(
            state.series,
            state.genre.minus(action.id))
        else -> state
    }


fun addReducer(state: State, action: RAction, newId: Int = -1) =
    when (action) {
        is AddSeries -> {
            val addWindow = document.getElementById("addWindow") as HTMLElement
            val title = document.getElementById("Title") as HTMLInputElement
            val logo = document.getElementById("Logo") as HTMLInputElement
            val genre = document.getElementById("Genre") as HTMLSelectElement
            val releaseYears = document.getElementById("ReleaseYears") as HTMLInputElement
            val tagline = document.getElementById("Tagline") as HTMLInputElement
            val age_rating = document.getElementById("Age_rating") as HTMLInputElement
            val kinopoisk = document.getElementById("Kinopoisk") as HTMLInputElement
            val newSeries = Series(
                if(title.value == "") "no name" else title.value,
                logo.value,
                genre.value,
                if(releaseYears.value == "") 0 else releaseYears.value.toInt(),
                tagline.value,
                if(age_rating.value == "") 0 else age_rating.value.toInt(),
                if(kinopoisk.value=="") 0 else kinopoisk.value.toInt(),
                false, false
            )
            addWindow.style.display = "none"
            title.value = ""
            releaseYears.value = ""
            tagline.value = ""
            logo.value = ""
            age_rating.value = ""
            kinopoisk.value = ""

            State(
                state.series.plus(newId to newSeries),
                state.genre
            )
        }
        is AddToWatched -> {
            State(
                state.series.apply {
                    state.series.getValue(action.index).watched = true
                },
                state.genre
            )
        }
        is AddGenre ->{
            val addWindow = document.getElementById("addWindow") as HTMLElement
            val nGenre = document.getElementById("newGenre") as HTMLInputElement
            val newGenre = genre(if(nGenre.value == "") "no name" else nGenre.value)
            addWindow.style.display = "none"
            nGenre.value =""
            State(
                state.series,
                state.genre.plus( newId to newGenre)
            )
        }
        else -> state
    }

fun rootReducer(state: State, action: RAction) = //work
    when (action) {
        is AddSeries -> {
            val id = state.series.newId()
            addReducer(state, action, id)}
        is AddGenre -> {
            val id = state.genre.newId()
            addReducer(state,action,id)
        }
        is AddToWatched -> addReducer(state, action)
        is DeleteGenre -> deleteReducer(state, action)
        is DeleteSeries -> deleteReducer(state, action)
        is EditSeries -> editReducer(state, action)
        is EditGenre -> editReducer(state, action)
        else -> state
    }
