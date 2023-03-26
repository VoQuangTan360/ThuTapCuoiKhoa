package com.example.thuctapcuoiky.data.divider

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.thuctapcuoiky.UI.Home.SearchFragment

class SpacesItemDecoration(context: SearchFragment, space: Int = 10) : RecyclerView.ItemDecoration() {
    private var space = convertDPtoPX(context, space)

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.left = space
        outRect.right = space
        outRect.bottom = space
        if (parent.getChildAdapterPosition(view) == 0) outRect.top = space
    }

    private fun convertDPtoPX(context: SearchFragment, dp: Int): Int = (dp * context.resources.displayMetrics.density).toInt()
}