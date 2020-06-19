package redux

class AddSeries: RAction
class AddGenre: RAction
class AddToWatched(val index:Int): RAction
class DeleteSeries(val id: Int): RAction
class DeleteGenre(val id: Int): RAction
class EditSeries(val id: Int): RAction
class EditGenre(val id: Int): RAction

