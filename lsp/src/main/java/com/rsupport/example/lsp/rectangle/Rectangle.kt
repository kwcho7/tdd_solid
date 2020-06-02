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

    fun setWidth(width: Int) {
        this.width = width
    }

    fun setHeight(height: Int) {
        this.height = height
    }
}