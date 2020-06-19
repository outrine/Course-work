package container

import component.SeriesListProps
import component.fSeriesList
import data.*
import hoc.withDisplayName
import org.w3c.dom.events.Event
import react.*
import react.redux.rConnect
import redux.*

interface SeriesListDispatchProps : RProps {
    var add: (Event) -> Unit
}

interface SeriesListStateProps : RProps {
    var series: Array<Series>
    var genres: Array<genre>
}

val seriesListHoc =
    rConnect<
            State,
            RAction,
            WrapperAction,
            RProps,
            SeriesListStateProps,
            SeriesListDispatchProps,
            SeriesListProps
            >(
        mapStateToProps = { state, _ ->
            series = state.series.values.toTypedArray()
            genres = state.genre.values.toTypedArray()
        },
        mapDispatchToProps = { dispatch, _ ->
            add = {dispatch(AddSeries())}
        }
    )

val seriesListRClass =
    withDisplayName(
        "SeriesList",
        fSeriesList
    )
        .unsafeCast<RClass<SeriesListProps>>()

val seriesListContainer =
    seriesListHoc(seriesListRClass)