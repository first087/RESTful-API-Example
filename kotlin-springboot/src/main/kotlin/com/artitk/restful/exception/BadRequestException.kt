package com.artitk.restful.exception

class BadRequestException : RuntimeException {
    constructor(): super()

    constructor(cause: Throwable): super(cause)
}
