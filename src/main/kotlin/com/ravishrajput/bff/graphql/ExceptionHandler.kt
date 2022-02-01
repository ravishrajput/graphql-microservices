package com.ravishrajput.bff.graphql

import graphql.ErrorClassification
import graphql.GraphQLError
import graphql.execution.DataFetcherExceptionHandlerParameters
import graphql.execution.DataFetcherExceptionHandlerResult
import graphql.execution.SimpleDataFetcherExceptionHandler
import graphql.language.SourceLocation
import jakarta.inject.Singleton
import org.slf4j.LoggerFactory

@Singleton
class ExceptionHandler : SimpleDataFetcherExceptionHandler() {
    private val log = LoggerFactory.getLogger(this.javaClass)

    override fun onException(handlerParameters: DataFetcherExceptionHandlerParameters): DataFetcherExceptionHandlerResult {
        val exception = handlerParameters.exception
        log.error("Exception", exception)
        val error = object : GraphQLError {
            override fun getMessage(): String = "Error is: ${exception.message}"
            override fun getLocations(): MutableList<SourceLocation>? = null
            override fun getErrorType(): ErrorClassification? = null
        }
        return DataFetcherExceptionHandlerResult.newResult().error(error).build()
    }
}