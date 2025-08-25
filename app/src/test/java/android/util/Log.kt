package android.util

/**
 * Class to simulate the android.log
 *
 * TODO: What's the impact of JvmStatic??
 * **/
object Log {

    @JvmStatic
    fun d(tag: String?, msg: String?): Int {
        println("DEBUG: $tag: $msg")
        return 0
    }

    @JvmStatic
    fun i(tag: String?, msg: String?): Int {
        println("INFO: $tag: $msg")
        return 0
    }

    @JvmStatic
    fun w(tag: String?, msg: String?): Int {
        println("WARN: $tag: $msg")
        return 0
    }

    @JvmStatic
    fun e(tag: String, msg: String): Int {
        println("ERROR: $tag: $msg")
        return 0
    }
}