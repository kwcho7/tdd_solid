package com.rsupport.example.lsp.rectangle

open class Rectangle {
    private var height: Int = 0
    private var width: Int = 0

    fun getHeight(): Int {
        return height
    }

    fun getWidth(): Int {
        return width
    }

    open fun setWidth(width: Int) {
        this.width = width
    }

    open fun setHeight(height: Int) {
        this.height = height
    }

    open fun getArea(): Int {
        return getWidth() * getHeight()
    }
}