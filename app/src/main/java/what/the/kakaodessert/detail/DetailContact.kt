package what.the.kakaodessert.detail

import what.the.kakaodessert.response.PhotoInfo

interface DetailContact {

    interface View {
        fun showInfo(info: PhotoInfo)
    }

    interface Presenter {
        var view: View
    }

}