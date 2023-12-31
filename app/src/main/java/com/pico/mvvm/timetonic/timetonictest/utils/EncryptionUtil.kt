package com.pico.mvvm.timetonic.timetonictest.utils

import android.util.Base64
import android.util.Log
import java.nio.charset.Charset
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

object EncryptionUtil {
    private const val ALGORITHM = "AES"
    private const val TRANSFORMATION = "AES/CBC/PKCS5Padding"
    private const val SECRET_KEY = "0123456789012345"
    private const val IV = "0123456789012345"

    /**
     *  Here we encrypt a string using the algorithm AES and return a encrypted String
     *  @param text: String
     *  @return String
     */
    fun encrypt(text: String): String {
        try {
            val cipher = Cipher.getInstance(TRANSFORMATION)
            val keySpec = SecretKeySpec(SECRET_KEY.toByteArray(), ALGORITHM)
            val ivSpec = IvParameterSpec(IV.toByteArray())

            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec)

            val encryptedBytes = cipher.doFinal(text.toByteArray())
            return Base64.encodeToString(encryptedBytes, Base64.DEFAULT)
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("SimpleEncryptionUtil", "Encryption error: ${e.message}")
            throw e
        }
    }

    /**
     *  Here we decrypt a encrypted string using the algorithm AES and return a  decrypted String
     *  @param text: String
     *  @return String
     */
    fun decrypt(cipherText: String): String {
        try {
            val cipher = Cipher.getInstance(TRANSFORMATION)
            val keySpec = SecretKeySpec(SECRET_KEY.toByteArray(), ALGORITHM)
            val ivSpec = IvParameterSpec(IV.toByteArray())

            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec)

            val decryptedBytes = cipher.doFinal(Base64.decode(cipherText, Base64.DEFAULT))
            return String(decryptedBytes, Charset.defaultCharset())
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("SimpleEncryptionUtil", "Encryption error: ${e.message}")
            throw e
        }
    }

    private fun generateIV(): String {
        return "0123456789012345"
    }
}