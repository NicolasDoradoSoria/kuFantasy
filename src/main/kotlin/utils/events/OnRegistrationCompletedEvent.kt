package ar.edu.unsam.phm.utils.events

import ar.edu.unsam.phm.models.User


class OnRegistrationCompletedEvent(
    val user: User,
    val confirmationURL: String
)