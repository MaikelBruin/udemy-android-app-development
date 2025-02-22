package mb.courses.musicappui

import androidx.annotation.DrawableRes

data class Lib(@DrawableRes val icon: Int, val name: String)

val libraries = listOf<Lib>(
    Lib(R.drawable.baseline_playlist_add_24, "Playlists"),
    Lib(R.drawable.baseline_smart_toy_24, "Artists"),
    Lib(R.drawable.baseline_person_add_alt_1_24, "Albums"),
    Lib(R.drawable.baseline_auto_awesome_24, "Songs"),
    Lib(R.drawable.baseline_share_location_24, "Genres"),
)
