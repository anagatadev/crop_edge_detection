package dev.anagata.cropedgedetection.scan

import android.view.Display
import android.view.SurfaceView
import dev.anagata.cropedgedetection.view.PaperRectangle

interface IScanView {
    interface Proxy {
        fun exit()
        fun getDisplay(): Display
        fun getSurfaceView(): SurfaceView
        fun getPaperRect(): PaperRectangle
    }
}