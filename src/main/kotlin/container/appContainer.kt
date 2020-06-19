package container

import component.AppProps
import component.fApp
import react.*
import react.redux.rConnect
import data.*
import hoc.withDisplayName

val appContainer =
    rConnect<State, RProps, AppProps>(
        { state, _->
            series = state.series
            genres = state.genre

        },
        {
            pure = false
        }
    )(
        withDisplayName(
            "MyApp",
            fApp()
        )
            .unsafeCast<RClass<AppProps>>()
    )