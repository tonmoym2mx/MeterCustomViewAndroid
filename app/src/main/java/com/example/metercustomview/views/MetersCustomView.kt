package com.example.metercustomview.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View

class MetersCustomView :View {
    private var radius:Int = 300
    private var isInit:Boolean = false
    private lateinit var paintText: Paint
    private lateinit var paintLine: Paint
    private var textList:List<String> =  ArrayList<String>()
    private var xyList:MutableList<xyAxiz> = ArrayList()
    private var speed:Int =0

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    )

    override fun onDraw(canvas: Canvas?) {
        if(!isInit){
            initDraw(canvas)
        }
        drowText(canvas)
        drowPoint(canvas)
        drowLine(canvas,speed)

    }
    public fun setCurrentSpeed(speed:Int){
        this.speed = speed
        postInvalidate()
    }

    private fun drowLine(canvas: Canvas?,i:Int) {
        paintLine = Paint()
        paintLine.color = Color.GREEN
        paintLine.isAntiAlias = true
        paintLine.strokeWidth = 4f

            canvas!!.drawLine(
                (width / 2).toFloat(), (height ).toFloat(),
                xyList.get(i).x, xyList.get(i).y, paintLine
            )

    }

    private fun drowPoint(canvas: Canvas?) {
        canvas!!.drawCircle((width/2).toFloat(), (height).toFloat(),20f,paintText)
    }

    private fun drowText(canvas: Canvas?) {
        paintText = Paint()
        paintText.textSize = 30f
        paintText.color = Color.GREEN
        paintText.isAntiAlias = true
        for(i in 0..10){
            var angle = Math.PI /10 *(i-10)
            var xx = Math.cos(angle)*radius + (width/2)-20
            var yy = Math.sin(angle)*radius + height
            //xyList.add(xyAxiz(xx.toFloat(),yy.toFloat()))
            canvas!!.drawText("${textList.get(i)}", xx.toFloat(),yy.toFloat(),paintText)

        }
        for(j in 0..199){
            var angle = Math.PI /200 *(j-199)
            var xx = (Math.cos(angle)*(radius-35) + (width/2))
            var yy = (Math.sin(angle)*(radius-35) + height)
            xyList.add(xyAxiz(xx.toFloat(),yy.toFloat()))
           // canvas!!.drawCircle(xx.toFloat(), yy.toFloat(), 10F,paintText)
        }
    }

    private fun initDraw(canvas: Canvas?){
        textList = arrayListOf("0","20","40","60","80","100","120","140","160","180","200")
        isInit = true
    }
}