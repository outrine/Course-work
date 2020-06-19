package container

import component.SeriesPageProps
import component.fSeriesPage
import data.*
import hoc.withDisplayName
import org.w3c.dom.events.Event
import react.*
import react.redux.rConnect
import redux.*

interface SeriesPageDispatchProps : RProps {
    var add: (Int)->(Event) -> Unit
    var delete: (Int) -> Unit
    var edit: (Int) -> Unit
}

interface SeriesPageStateProps: RProps {
    var series: Array<Series>
    var genres: Array<genre>
}

interface SeriesPageOwnProps : RProps {
    var index: Int
}

val seriesPageHoc =
    rConnect<
            State,
            RAction,
            WrapperAction,
            SeriesPageOwnProps,
            SeriesPageStateProps,
            SeriesPageDispatchProps,
            SeriesPageProps
            >(
        mapStateToProps = { state, _ ->
            series = state.series.values.toTypedArray()
            genres = state.genre.values.toTypedArray()
        },
        mapDispatchToProps = { dispatch, _ ->
            add =
                { index ->
                    {
                        dispatch(AddToWatched(index))
                    }
                }
            delete = {dispatch(DeleteSeries(it))}
            edit = {dispatch(EditSeries(it))}
        }
    )

val SeriesPageRClass =
    withDisplayName(
        "SeriesPage",
        fSeriesPage
    )
        .unsafeCast<RClass<SeriesPageProps>>()

val SeriesPageContainer =
    seriesPageHoc(SeriesPageRClass)
