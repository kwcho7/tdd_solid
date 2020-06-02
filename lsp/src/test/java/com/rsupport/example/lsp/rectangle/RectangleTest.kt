package com.rsupport.example.lsp.rectangle

import org.hamcrest.Matchers.`is`
import org.junit.Assert.*
import org.junit.Test

class RectangleTest{

    @Test
    fun width() {
        val rectangle = createRectangle(width = 100)
        val width = rectangle.getWidth()
        assertThat("설정 값과 달라서 실패", width, `is`(100))
    }

    @Test
    fun height() {
        val rectangle: Rectangle = createRectangle(height = 200)
        val actual = rectangle.getHeight()
        assertThat("설정 값과 달라서 실패", actual, `is`(200))
    }

    @Test
    fun change() {
        val rectangle = createRectangle().apply {
            setWidth(100)
            setHeight(200)
        }
        val width = rectangle.getWidth()
        val height = rectangle.getHeight()
        assertThat("설정 값과 달라서 실패", width, `is`(100))
        assertThat("설정 값과 달라서 실패", height, `is`(200))
    }

    @Test
    fun area() {
        val rectangle = createRectangle().apply {
            setWidth(100)
            setHeight(200)
        }

        assertThat("설정 값과 달라서 실패", rectangle.getArea(), `is`(20000))
    }

    private fun createRectangle(height: Int = 0, width: Int = 0): Rectangle {
        return Rectangle().apply {
            setHeight(height)
            setWidth(width)
        }
    }
}