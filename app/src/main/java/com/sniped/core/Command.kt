package com.sniped.core

/**
 * Defines a command with no parameters.
 */
interface Command {

    fun execute()

    companion object {

        val NULL = {} as Command
    }
}
