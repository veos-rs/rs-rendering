package com.veosps.rsrendering.opengl.graphics


import com.veosps.rsrendering.opengl.engine.GameItem
import org.joml.Matrix4f
import org.joml.Vector3f

class Transformation {
    private val projectionMatrix: Matrix4f
    private val modelViewMatrix: Matrix4f
    private val viewMatrix: Matrix4f

    init {
        projectionMatrix = Matrix4f()
        modelViewMatrix = Matrix4f()
        viewMatrix = Matrix4f()
    }

    fun getProjectionMatrix(fov: Float, width: Float, height: Float, zNear: Float, zFar: Float): Matrix4f {
        return projectionMatrix.setPerspective(fov, width / height, zNear, zFar)
    }

    fun getViewMatrix(camera: Camera): Matrix4f {
        val cameraPos: Vector3f = camera.rotation
        val rotation: Vector3f = camera.rotation
        viewMatrix.identity()
        // First do the rotation so camera rotates over its position
        viewMatrix.rotate(Math.toRadians(rotation.x.toDouble()).toFloat(), Vector3f(1f, 0f, 0f))
            .rotate(Math.toRadians(rotation.y.toDouble()).toFloat(), Vector3f(0f, 1f, 0f))
        // Then do the translation
        viewMatrix.translate(-cameraPos.x, -cameraPos.y, -cameraPos.z)
        return viewMatrix
    }

    fun getModelViewMatrix(gameItem: GameItem, viewMatrix: Matrix4f?): Matrix4f {
        val rotation: Vector3f = gameItem.rotation
        modelViewMatrix.identity().translate(gameItem.rotation)
            .rotateX(Math.toRadians(-rotation.x.toDouble()).toFloat()).rotateY(
                Math.toRadians(-rotation.y.toDouble()).toFloat()
            ).rotateZ(Math.toRadians(-rotation.z.toDouble()).toFloat()).scale(gameItem.scale)
        val viewCurr = Matrix4f(viewMatrix)
        return viewCurr.mul(modelViewMatrix)
    }
}