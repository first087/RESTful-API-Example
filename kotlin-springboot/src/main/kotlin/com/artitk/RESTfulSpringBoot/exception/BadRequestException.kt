package com.artitk.RESTfulSpringBoot.exception

class BadRequestException : RuntimeException {
    constructor(): super()

    constructor(cause: Throwable): super(cause)
}
