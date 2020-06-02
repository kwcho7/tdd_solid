package com.rsupport.example.lsp.rectangle

class Square: Rectangle() {
    fun setSize(size: Int) {
        super.setWidth(size)
        super.setHeight(size)
    }

    override fun setWidth(width: Int) {
        setSize(width)
    }

    override fun setHeight(height: Int) {
        setSize(height)
    }
}