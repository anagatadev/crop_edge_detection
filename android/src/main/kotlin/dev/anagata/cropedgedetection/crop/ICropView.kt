package dev.anagata.cropedgedetection.crop

import android.widget.ImageView
import dev.anagata.cropedgedetection.view.PaperRectangle


/**
 * Created on 15/09/2017.
 */
class ICropView {
    interface Proxy {
        fun getPaper(): ImageView
        fun getPaperRect(): PaperRectangle
        fun getCroppedPaper(): ImageView
    }
}