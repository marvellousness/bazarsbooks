package com.asoft.bazar.model

sealed interface MediaType {
    enum class Common(val type: String) : MediaType {
        Authors(AuthorsType),
        Vendors(VendorsType),
        TopOfWeek(TopOfWeekType)
    }
}

private const val AuthorsType = "authors"
private const val VendorsType = "vendors"
private const val TopOfWeekType = "top_of_week"