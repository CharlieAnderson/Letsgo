package com.example.charlesanderson.letsgo

import android.content.Context
import android.graphics.*
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat.setLayerType
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

public class GradientDecoration(val context: Context) : ItemDecoration() {
    lateinit var eraser: Paint

    init {
        setupEraser()
    }

    override fun onDraw(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(canvas, parent, state)
        val radius = context.resources.getDimensionPixelSize(R.dimen.bubble_radius).toFloat()
        parent.setLayerType(View.LAYER_TYPE_HARDWARE, null)
        for (i in 0..parent.childCount) {
            val child = parent.getChildAt(i)
            if(child!=null) {
                val hole = RectF()
                hole.set(child.left.toFloat(), child.top.toFloat(), child.right.toFloat(), child.bottom.toFloat())
                canvas.drawRoundRect(hole, radius, radius, eraser)
            }
        }
    }

    private fun setupEraser() {
        eraser = Paint()
        eraser.color = ContextCompat.getColor(context, android.R.color.transparent)
        eraser.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
        eraser.isAntiAlias = true
        eraser.setShadowLayer(context.resources.getDimensionPixelSize(R.dimen.bubble_radius).toFloat(), 0F,
            context.resources.getDimensionPixelSize(R.dimen.bubble_radius).toFloat(), R.color.primary_dark_material_dark )

    }




}