package what.the.kakaodessert.main

import what.the.kakaodessert.response.Photos

interface MainContact {
    interface View {
        fun showImages(photos: Photos)
    }

    interface Presenter {
        var view: View
    }
}