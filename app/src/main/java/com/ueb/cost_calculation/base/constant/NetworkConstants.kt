package com.ueb.cost_calculation.base.constant

class NetworkConstants {

    companion object {
        object Retrofit {
            const val BASE_URL =
                "https://prod-storyly-media.s3.eu-west-1.amazonaws.com/test-scenarios/"
        }

        object CostCalculator {
            object Endpoint {
                const val GET_ITEM = "sample_3.json"
            }
        }

    }

}