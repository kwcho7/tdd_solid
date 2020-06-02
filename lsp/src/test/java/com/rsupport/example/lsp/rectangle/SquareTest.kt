package com.rsupport.example.lsp.rectangle

import org.hamcrest.Matchers
import org.hamcrest.Matchers.`is`
import org.junit.Assert
import org.junit.Test

class SquareTest{

    @Test
    fun width() {
        val rectangle = createSquare(100)
        val width = rectangle.getWidth()
        Assert.assertThat("설정 값과 달라서 실패", width, `is`(100))
    }

    @Test
    fun height() {
        val rectangle: Rectangle = createSquare(200)
        val actual = rectangle.getHeight()
        Assert.assertThat("설정 값과 달라서 실패", actual, `is`(200))
    }

    @Test
    fun change() {
        val rectangle = createSquare().apply {
            setWidth(100)
            setHeight(200)
        }
        val width = rectangle.getWidth()
        val height = rectangle.getHeight()
        Assert.assertThat("설정 값과 달라서 실패", width == height, `is`(true))
    }

    @Test
    fun area() {
        val rectangle = createSquare().apply {
            setWidth(100)
            setHeight(200)
        }

        Assert.assertThat("설정 값과 달라서 실패", rectangle.getArea(), `is`(20000))
    }

    private fun createSquare(size: Int = 0): Rectangle {
        return Square().apply {
            setSize(size)
        }
    }

}