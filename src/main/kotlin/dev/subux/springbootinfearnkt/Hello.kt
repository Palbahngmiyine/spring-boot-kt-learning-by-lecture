package dev.subux.springbootinfearnkt

data class Hello(var prefix: String, var name: String) {
    override fun toString(): String {
        return prefix + " " + name
    }
}
