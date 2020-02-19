package com.example.pouchnationexam.usecase.api


import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class Events(
    @SerializedName("eventId")
    val eventId: Int = 0, // 1
    @SerializedName("eventTitle")
    val eventTitle: String = "", // Paradise Music Festival 2019
    @SerializedName("eventDescription")
    val eventDescription: String = "", // Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
    @SerializedName("eventDateTime")
    val eventDateTime: String = "", // June 12, 2019
    @SerializedName("eventLocation")
    val eventLocation: String = "", // SM Mall of Asia
    @SerializedName("ticketTypes")
    val ticketTypes: List<TicketType> = listOf(),
    @SerializedName("packages")
    val packages: List<Package> = listOf()
) {
    data class TicketType(
        @SerializedName("ticketTypeId")
        val ticketTypeId: Int = 0, // 2
        @SerializedName("name")
        val name: String = "", // General Admission Phase 2
        @SerializedName("description")
        val description: String = "", // Lorem ipsum dolor sit amet, consectetur adipiscing elit
        @SerializedName("price")
        val price: BigDecimal = BigDecimal.ZERO // 1200.00
    )

    data class Package(
        @SerializedName("packageId")
        val packageId: Int = 0, // 2
        @SerializedName("name")
        val name: String = "", // Fan Package 2
        @SerializedName("description")
        val description: String = "", // Lorem ipsum dolor sit amet, consectetur adipiscing elit
        @SerializedName("price")
        val price: Double = 0.0, // 2200.00
        @SerializedName("ticketType")
        val ticketType: TicketType = TicketType(),
        @SerializedName("addOns")
        val addOns: List<AddOn> = listOf()
    ) {
        data class TicketType(
            @SerializedName("ticketTypeId")
            val ticketTypeId: Int = 0, // 1
            @SerializedName("name")
            val name: String = "" // General Admission Phase 1
        )

        data class AddOn(
            @SerializedName("addOnId")
            val addOnId: Int = 0, // 2
            @SerializedName("name")
            val name: String = "", // Beer
            @SerializedName("quantity")
            val quantity: Int = 0 // 4
        )
    }
}