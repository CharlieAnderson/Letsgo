package com.example.charlesanderson.letsgo.views

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.charlesanderson.letsgo.R

public class EventFeedConstraintLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
    ) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var childId: Int = 0
    private lateinit var childView: View
    private lateinit var eraser: Paint
    private var radius: Float = 0F
    private val childRect = RectF()

    init {
        setup(attrs!!)
    }

    private fun setup(attrs: AttributeSet) {
        val ta = context.obtainStyledAttributes(attrs,
            R.styleable.EventFeedConstraintLayout
        )
        this.childId = ta.getResourceId(R.styleable.EventFeedConstraintLayout_child_id, 0)
        this.radius = resources.getDimensionPixelSize(R.dimen.bubble_radius).toFloat()
        if (this.childId != 0) {
            ta.recycle()
            setupEraser()
            return
        }
        throw IllegalArgumentException("unable to find childId to create a hole")
    }

    override fun onViewAdded(view: View) {
        super.onViewAdded(view)
        if (view.id == this.childId) {
            this.childView = view
        }
    }

    private fun setupEraser() {
        eraser = Paint()
        eraser.color = ContextCompat.getColor(context, android.R.color.transparent)
        eraser.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
        eraser.isAntiAlias = true
        setLayerType(View.LAYER_TYPE_HARDWARE, null)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        childRect.set(childView.left.toFloat(), childView.top.toFloat(),
            childView.right.toFloat(), childView.bottom.toFloat())
        canvas.drawRoundRect(childRect, radius, radius, eraser)
    }

}
